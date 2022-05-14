package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows the user to roll the dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // create new dice with six sides for first dice and roll it for a random number
        val firstDice = Dice(6)
        val firstDiceRoll = firstDice.roll()
        // update the screen with the result for the second dice (cast to a String)
        val firstResultTV: TextView = findViewById(R.id.firstResult)
        firstResultTV.text = firstDiceRoll.toString()
        // create new dice with six sides for second dice and roll it for a random number
        val dice = Dice(6)
        val secondDiceRoll = dice.roll()
        // update the screen with the result for the second dice (cast to a String)
        val secondResultTV: TextView = findViewById(R.id.secondResult)
        secondResultTV.text = secondDiceRoll.toString()
    }
}

class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}