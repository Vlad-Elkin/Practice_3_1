package com.example.practice_3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button0)
        button.setOnClickListener {
            var a = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toInt()
            var b = findViewById<EditText>(R.id.editTextNumberDecimal1).text.toString().toInt()
            if (a<b){
                var intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("a",a)
                intent.putExtra("b",b)
                startActivity(intent)
            }
        }
    }
}