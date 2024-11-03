package com.example.mybtuapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sendButton: Button = findViewById(R.id.send_button)
        val messageEditText: EditText = findViewById(R.id.message)
        val senderMail: EditText = findViewById(R.id.sender)
        val receiverMail: EditText = findViewById(R.id.receiver)

        sendButton.setOnClickListener {
            val message = messageEditText.text.toString()
            val sender = senderMail.text.toString()
            val receiver = receiverMail.text.toString()

            if (message.isEmpty() || sender.isEmpty() || receiver.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            } else if (!isValidEmail(sender) || !isValidEmail(receiver)) {
                Toast.makeText(this, "Please enter valid email addresses.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, Main3Activity::class.java).apply {
                    putExtra("message", message)
                    putExtra("sender", sender)
                    putExtra("receiver", receiver)
                }

                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}