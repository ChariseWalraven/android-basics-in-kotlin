package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

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

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // create new dice with six sides for first dice and roll it for a random number
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // get dice image to change later
        val diceImage: ImageView = findViewById(R.id.diceImage)

        // return the correct resource for the dice roll value
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // set image to correct resource
        diceImage.setImageResource(drawableResource)

        // set content description so screen readers have the right thing to read
        diceImage.contentDescription = diceRoll.toString()
    }
}


// Dice class that rolls. Pretty obvious, I guess.
class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}