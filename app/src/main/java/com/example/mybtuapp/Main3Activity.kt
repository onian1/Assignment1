package com.example.mybtuapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Toast

class Main3Activity : AppCompatActivity() {
    private lateinit var email1TextView: TextView
    private lateinit var email2TextView: TextView
    private lateinit var messageTextView: TextView
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        email1TextView = findViewById(R.id.to)
        email2TextView = findViewById(R.id.from)
        messageTextView = findViewById(R.id.message_text)
        clearButton = findViewById(R.id.clear)

        val email1 = intent.getStringExtra("sender")
        val email2 = intent.getStringExtra("receiver")
        val message = intent.getStringExtra("message")

        email1TextView.text = getString(R.string.from, email1 ?: "No email")
        email2TextView.text = getString(R.string.to, email2 ?: "No email")
        messageTextView.text = message ?: "No message"

        clearButton.setOnClickListener {
            messageTextView.text = ""
            email1TextView.text = ""
            email2TextView.text = ""
            Toast.makeText(this, "Message cleared", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}