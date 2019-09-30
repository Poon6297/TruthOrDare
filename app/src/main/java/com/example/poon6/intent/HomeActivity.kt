package com.example.poon6.intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.home_page.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        btn_start.setOnClickListener {
            startGame()
        }
    }

    private fun startGame() {
        val intent = Intent(this, PlayerActivity::class.java)
        startActivity(intent)
    }
}





