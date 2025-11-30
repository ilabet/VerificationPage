package com.example.verificationpage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val verifyButton = findViewById<Button>(R.id.verifyButton)

        verifyButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            if (isStudentVSUEmail(email)) {
                Toast.makeText(this, "Valid student email", Toast.LENGTH_SHORT).show()
                // Add further actions (e.g., next registration step)
            } else {
                Toast.makeText(this, "Please use your @students.vsu.edu email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Email validation function for @students.vsu.edu
    private fun isStudentVSUEmail(email: String): Boolean {
        val vsuPattern = Regex("^[A-Za-z0-9._%+-]+@students\\.vsu\\.edu\$", RegexOption.IGNORE_CASE)
        return vsuPattern.matches(email)
    }
}
