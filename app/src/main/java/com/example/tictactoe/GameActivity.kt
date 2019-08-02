package com.example.tictactoe

import android.graphics.Color.BLUE
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_game)
    }

    protected fun buClick(view : View) {
        val buSelecetd = view as Button
        var cellID = 0
        when (buSelecetd.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }
    }

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1

    fun playGame(cellID:Int,buSelected:Button){

        if (activePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(RED)
            player1.add(cellID)
            activePlayer=2
            AutoPlay()
        }else{
            buSelected.text="O"
            buSelected.setBackgroundColor(BLUE)
            player1.add(cellID)
            activePlayer=2
        }
        buSelected.isEnabled=false
        CheckWinner()
    }

    fun CheckWinner() {
        var winner = -1

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 1
        }

        //column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 1
        }

        //column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 1
        }

        //side 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 1
        }

        //side 2
        if (player1.contains(7) && player1.contains(5) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(5) && player2.contains(3)) {
            winner = 1
        }

        // declaring the winner
        if (winner !=-1){
            if  (winner==1){
                Toast.makeText(this,"X wins", Toast.LENGTH_LONG).show()
            }else{ Toast.makeText(this,"O wins", Toast.LENGTH_LONG).show()

            }
        }
    }

    fun AutoPlay(){
        val emptyCells=ArrayList<Int>()
        for ( cellID in 1..9){


            if(!( player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }

        val r= Random()
        val randIndex=r.nextInt(emptyCells.size-0)+0

        val cellID =emptyCells[randIndex]

        val buSelect:Button?
        when(cellID){
            1-> buSelect=bu1
            2-> buSelect=bu2
            3-> buSelect=bu3
            4-> buSelect=bu4
            5-> buSelect=bu5
            6-> buSelect=bu6
            7-> buSelect=bu7
            8-> buSelect=bu8
            9-> buSelect=bu9

            else->{
                buSelect=bu1
            }
        }

        playGame(cellID,buSelect)
    }

}
