package com.example.pakidax

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var playButton = findViewById<Button>(R.id.main_play)
        playButton.setOnClickListener(){
            val playIntent = Intent(this, Game::class.java)
            playIntent.putExtra("first_player", findViewById<EditText>(R.id.main_player_one).text.toString())
            playIntent.putExtra("second_player", findViewById<EditText>(R.id.main_player_two).text.toString())
            startActivity(playIntent)
        }
    }
}