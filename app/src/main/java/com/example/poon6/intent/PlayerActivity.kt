package com.example.poon6.intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.player.*

class PlayerActivity : AppCompatActivity() {

    var noOfPeople : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.player)

        btn_confirm.setOnClickListener {
            noOfPeople = et_no_of_people.text.toString().toIntOrNull()
            if (noOfPeople != null) {
                nextActivity()
            } else {
                val toast = Toast.makeText(this, "Please enter valid integer", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }


    private fun nextActivity() {
        val noOfPeople = 20

        val intent = Intent(this, DifficultyActivity::class.java)
        intent.putExtra("noOfPeople", noOfPeople)
        startActivity(intent)
    }
}