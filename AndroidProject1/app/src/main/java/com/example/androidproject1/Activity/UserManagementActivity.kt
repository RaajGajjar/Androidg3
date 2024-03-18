package com.example.androidproject1.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidproject1.R
import com.example.androidproject1.Activity.Bottomtabas
import com.example.androidproject1.Modals.User
import com.google.firebase.auth.FirebaseAuth

class UserManagementActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_management)

        auth = FirebaseAuth.getInstance()




        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // User is signed in, navigate to main activity
            startActivity(Intent(this, Bottomtabas::class.java))
            finish() // Finish this activity to prevent going back to it on pressing back button
        }


        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        val signUpButton: TextView = findViewById(R.id.signUpButton)
        val signInButton: Button = findViewById(R.id.signInButton)
//        val updateProfileButton: Button = findViewById(R.id.updateProfileButton)
//        val resetPasswordButton: Button = findViewById(R.id.resetPasswordButton)

        signUpButton.setOnClickListener { signUp() }
        signInButton.setOnClickListener { signIn() }
//        updateProfileButton.setOnClickListener { updateProfile() }
//        resetPasswordButton.setOnClickListener { resetPassword() }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun signUp() {
        Log.d(this.toString(), "signUp: => acitiv ")
        val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
    }

    private fun signIn() {
        Log.d(this.toString(), "signUp: => acitiv ")

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
if(!email.isEmpty() && !password.isEmpty()){


        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                Log.d("=====signIn ==> ", "signIn: "+task)

                if (task.isSuccessful) {
                    // Sign in success
                    val user = auth.currentUser
                    val userId = user?.uid ?: ""
                    Log.d("SignedInUserID *******>", "User ID: $userId")

                    val intent = Intent(this, Bottomtabas::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Please enter correct details", Toast.LENGTH_SHORT).show()
                    // Sign in failed
                }
            }
}else{
    Toast.makeText(this, "Please enter details", Toast.LENGTH_SHORT).show()

}
    }

    object CurrentUser {
        var userData: User? = null
    }
}
