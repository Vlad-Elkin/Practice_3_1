package com.example.practice_3_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val a = intent.getIntExtra("a",0)
        val b = intent.getIntExtra("b",0)
        val range = a..b
        guessNumber(range)
    }
    fun guessNumber(range: IntRange) {
        val textView = findViewById<TextView>(R.id.textView)
        val button_yes = findViewById<Button>(R.id.button_yes)
        val button_no = findViewById<Button>(R.id.button_no)

        when(range.count()){
            1 -> {
                textView.text = "Загаданное число - ${range.first}"
            }
            2 -> {
                val even:Int
                val odd:Int
                if (range.first%2==0){
                    even=range.first;
                    odd=range.last;
                }
                else{
                    odd=range.first;
                    even=range.last;
                }
                textView.text = "Загаданное число - чётное?"
                button_no.setOnClickListener {textView.text = "Загаданное число - $odd"}
                button_yes.setOnClickListener{textView.text = "Загаданное число - $even"}
            }
            else ->{
                val middle0 = (range.first+range.last)/2
                val middle1 = (range.first+range.last+2)/2
                val first_half = range.first..middle0
                val second_half = middle1..range.last
                textView.text = "Загаданное число больше $middle0?"
                button_no.setOnClickListener { guessNumber(first_half) }
                button_yes.setOnClickListener{ guessNumber(second_half)}
            }
        }
    }
}