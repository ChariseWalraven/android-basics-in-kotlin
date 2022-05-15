package com.example.debugging

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.concurrent.thread

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logging()
        division()
    }

    @SuppressLint("SetTextI18n")
    private fun division() {
        val numerator = 60
        var denominator = 4
        val divisionTextView: TextView = findViewById(R.id.division_textview)
        // create a new thread (and start it immediately)
        thread(start=true) {
            repeat(3) {
                Thread.sleep(1000L)
                // assuming you've done the ``findViewById`` and assigned it to a variable
                runOnUiThread { divisionTextView.text = "${numerator/denominator}" }
                denominator--
            }
            Thread.sleep(1000L)
            runOnUiThread {divisionTextView.text = "Crashing in three..."}
            Thread.sleep(1000L)
            runOnUiThread {divisionTextView.text = "two..."}
            Thread.sleep(1000L)
            runOnUiThread {divisionTextView.text = "one..."}
            Thread.sleep(1000L)
            divisionTextView.text = "Pew pew pew, crash!"
        }
    }

    private fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
}