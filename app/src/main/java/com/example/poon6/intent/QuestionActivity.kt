package com.example.poon6.intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class QuestionActivity : AppCompatActivity() {

    var noOfPeople = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noOfPeople = intent.getIntExtra("noOfPeople", 0)
        val question = intent.getStringExtra("question")
        tv_question.text = question

        btn_back.setOnClickListener {
            nextActivity()
        }

        btn_home.setOnClickListener {
            homeActivity()
        }
    }

    private fun nextActivity() {
        val intent = Intent(this, DifficultyActivity::class.java)
        intent.putExtra("noOfPeople", noOfPeople)
        startActivity(intent)
    }

    private fun homeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}