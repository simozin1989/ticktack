package com.example.gamandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Xml
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.gamandroid.R.id.*
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1


    fun buAction(view: View) {
        val butChoice = view as Button

        var cellID = 0
        when (butChoice.id) {
            but1 -> cellID = 1
            R.id.but2 -> cellID = 2
            R.id.but3 -> cellID = 3
            R.id.but4 -> cellID = 4
            R.id.but5 -> cellID = 5
            R.id.but6 -> cellID = 6
            R.id.but7 -> cellID = 7
            R.id.but8 -> cellID = 8
            R.id.but9 -> cellID = 9

        }
        //Log.d("Hi we are", cellID.toString())
        playGame(cellID, butChoice)
        butChoice.setBackgroundResource(R.color.white)

    }

    private fun playGame(cellId: Int, butChoice: Button) {
        if (activePlayer == 1) {
            butChoice.text = "X"
            butChoice.setBackgroundResource(R.color.teal_200)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        } else {
            butChoice.text = "0"
            butChoice.setBackgroundResource(R.color.green)
            player2.add(cellId)
            activePlayer = 1
        }
        butChoice.isEnabled = false
        checkWinner()
    }

    private fun checkWinner() {
        var winner = 1
        //Row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1

        }
        //Row 2
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2

        }
        //Row 3
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 1

        }
        //com 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2

        }
        //com 2
        if (player2.contains(1) && player2.contains(5) && player2.contains(8)) {
            winner = 1

        }
        //com 3
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2

        }
        if (winner != -1) {

            if (winner == 1) {
                Toast.makeText(this, "Player 1 is Win in this Game", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Player 2 is Win in this Game", Toast.LENGTH_LONG).show()

            }

        }
    }

    private fun autoPlay() {
        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {
            if (player1.contains(cellID) || player2.contains(cellID)) {
                emptyCells.add(cellID)
            }
        }
        val rnd = Random.nextInt(emptyCells.size - 1) + 0;
        val cellId = emptyCells[rnd]
        var butSelect:Button?
        when (cellId) {
            1 -> butSelect = but1 as Button
            2 -> butSelect = but2 as Button
            3 -> butSelect = but3 as Button
            4 -> butSelect = but4 as Button
            5 -> butSelect = but5 as Button
            6 -> butSelect = but6 as Button
            7 -> butSelect = but7 as Button
            8 -> butSelect = but8 as Button
            9 -> butSelect = but9 as Button

            else -> {
                butSelect = but1 as Button
            }

        }
         playGame(cellId, butSelect!!)
    }


}