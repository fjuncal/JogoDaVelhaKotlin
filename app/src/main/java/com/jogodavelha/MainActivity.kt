package com.jogodavelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun btnClique(view: View){
        val btnSelecionado = view as Button
        var idBtn = 0

        //mesma coisa que o Switch em java
        when(btnSelecionado.id){
            R.id.btn_1 -> idBtn = 1
            R.id.btn_2 -> idBtn = 2
            R.id.btn_3 -> idBtn = 3
            R.id.btn_4 -> idBtn = 4
            R.id.btn_5 -> idBtn = 5
            R.id.btn_6 -> idBtn = 6
            R.id.btn_7 -> idBtn = 7
            R.id.btn_8 -> idBtn = 8
            R.id.btn_9 -> idBtn = 9
        }

        //Toast.makeText(this, "ID $idBtn", Toast.LENGTH_SHORT).show()
        jogarJogo(idBtn, btnSelecionado)
    }

    //Array para guardar as jogadas de cada jogador
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    //turno do jogador
    var jogadorAtivo = 1

    fun jogarJogo(idBtn: Int, btSelecionado: Button){
        if (jogadorAtivo == 1){
            btSelecionado.text = "X"
            btSelecionado.setBackgroundColor(Color.GREEN)
            player1.add(idBtn)
            jogadorAtivo = 2
        } else{
            btSelecionado.text = "O"
            btSelecionado.setBackgroundColor(Color.RED)
            player2.add(idBtn)
            jogadorAtivo = 1
        }
        btSelecionado.isEnabled = false
        checarVencedor()
    }

    fun checarVencedor(){
        var vencedor = -1

        //linha 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            vencedor = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            vencedor = 2
        }

        //linha 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            vencedor = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            vencedor = 2
        }

        //linha 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            vencedor = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            vencedor = 2
        }

        //////////////////COLUNAS/////////////////
        //coluna 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            vencedor = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            vencedor = 2
        }

        //coluna 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            vencedor = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            vencedor = 2
        }

        //coluna 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            vencedor = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            vencedor = 2
        }
        /////////////////DIAGONAL
        //Principal
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            vencedor = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            vencedor = 2
        }
        //Secundaria
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            vencedor = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            vencedor = 2
        }






        if (vencedor == 1){
            Toast.makeText(this, "O jogador 1 ganhou", Toast.LENGTH_SHORT).show()

        } else if (vencedor == 2){
            Toast.makeText(this, "O jogador 2 ganhou", Toast.LENGTH_SHORT).show()
        }
    }
}