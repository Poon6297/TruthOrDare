package com.example.poon6.intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.difficulty.*

class DifficultyActivity : AppCompatActivity() {

    var noOfPeople = 0
    var difficulty = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.difficulty)

        noOfPeople = intent.getIntExtra("noOfPeople", 0)


        btn_easy.setOnClickListener {
            difficulty = 1
            nextActivity()
        }

        btn_middle.setOnClickListener {
            difficulty = 2
            nextActivity()
        }

        btn_exciting.setOnClickListener {
            difficulty = 3
            nextActivity()
        }
    }














    private fun nextActivity() {
        val intent = Intent(this, TruthOrDareActivity::class.java)
        intent.putExtra("noOfPeople", noOfPeople)
        intent.putExtra("difficulty", difficulty)
        startActivity(intent)
    }


}