package com.example.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_game_page.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_main.*


class gamePage : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)

        var boardGame = arrayListOf<String>("", "", "", "", "", "", "", "", "")
        var winPositions = arrayOf<Int>(0,1,2,3,4,5,6,7,8,0,3,6,1,4,7,2,5,8,0,4,8,2,4,6)

        var numberOfMoves: Int = 1

        fun setPlayerText(numberMoves: Int)
        {
            if(numberOfMoves%2 == 1)
            {
                player.setText("Player 1 - Play with X.")
            }else
            {
                player.setText("Player 2 - Play with O.")
            }
        }

        fun setMoves(i: Int)
        {
            if(boardGame[i] == "")
            {
                if(numberOfMoves%2 == 1)
                {
                    boardGame[i] = "X"
                }else
                {
                    boardGame[i] = "O"
                }
                numberOfMoves++
                setPlayerText(numberOfMoves)
            }
        }

        fun getMoves(i: Int): String
        {
            return boardGame[i]
        }

        fun disableButtonsIfPlayerWin()
        {
            btn_1.isEnabled = false
            btn_2.isEnabled = false
            btn_3.isEnabled = false
            btn_4.isEnabled = false
            btn_5.isEnabled = false
            btn_6.isEnabled = false
            btn_7.isEnabled = false
            btn_8.isEnabled = false
            btn_9.isEnabled = false
        }

        fun enableButtonsIfPlayerWin()
        {
            btn_1.isEnabled = true
            btn_2.isEnabled = true
            btn_3.isEnabled = true
            btn_4.isEnabled = true
            btn_5.isEnabled = true
            btn_6.isEnabled = true
            btn_7.isEnabled = true
            btn_8.isEnabled = true
            btn_9.isEnabled = true
        }

        fun checkWhoWin()
        {
            var stringForCheck:String = ""

            for (i in 0..winPositions.size-3 step 3)
            {
                stringForCheck = boardGame[winPositions[i]] + boardGame[winPositions[i+1]] + boardGame[winPositions[i+2]]

                if(stringForCheck == "XXX")
                {
                    msgWinner.setText("Player 1 Win.")
                    player.setText("")
                    disableButtonsIfPlayerWin()
                }else if(stringForCheck == "OOO"){
                    msgWinner.setText("Player 2 Win.")
                    player.setText("")
                    disableButtonsIfPlayerWin()
                }
                else if(numberOfMoves == 10){
                    msgWinner.setText("Equality.")
                    player.setText("")
                    disableButtonsIfPlayerWin()
                }
            }

        }

        fun clearButtonText()
        {
            btn_1.setText("")
            btn_2.setText("")
            btn_3.setText("")
            btn_4.setText("")
            btn_5.setText("")
            btn_6.setText("")
            btn_7.setText("")
            btn_8.setText("")
            btn_9.setText("")
        }

        fun reset()
        {
            enableButtonsIfPlayerWin()
            clearButtonText()
            boardGame = arrayListOf<String>("", "", "", "", "", "", "", "", "")
            numberOfMoves = 1
            msgWinner.setText("")
        }


        btn_1.setOnClickListener{
            setMoves(0)
            btn_1.setText(getMoves(0))
            checkWhoWin()
        }
        btn_2.setOnClickListener{
            setMoves(1)
            btn_2.setText(getMoves(1))
            checkWhoWin()
        }
        btn_3.setOnClickListener{
            setMoves(2)
            btn_3.setText(getMoves(2))
            checkWhoWin()
        }
        btn_4.setOnClickListener{
            setMoves(3)
            btn_4.setText(getMoves(3))
            checkWhoWin()
        }
        btn_5.setOnClickListener{
            setMoves(4)
            btn_5.setText(getMoves(4))
            checkWhoWin()
        }
        btn_6.setOnClickListener{
            setMoves(5)
            btn_6.setText(getMoves(5))
            checkWhoWin()
        }
        btn_7.setOnClickListener{
            setMoves(6)
            btn_7.setText(getMoves(6))
            checkWhoWin()
        }
        btn_8.setOnClickListener{
            setMoves(7)
            btn_8.setText(getMoves(7))
            checkWhoWin()
        }
        btn_9.setOnClickListener{
            setMoves(8)
            btn_9.setText(getMoves(8))
            checkWhoWin()
        }

        btnReset.setOnClickListener{
            reset()
        }







    }
}
