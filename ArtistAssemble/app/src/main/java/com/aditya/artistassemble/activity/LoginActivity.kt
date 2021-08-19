package com.aditya.artistassemble.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aditya.artistassemble.R
import com.aditya.artistassemble.activity.MainActivity

class LoginActivity : AppCompatActivity() {

    /*Declaring the different variables used for this activity*/
    private lateinit var registerYourself: TextView
    private lateinit var login: Button
    private lateinit var etMobileNumber: EditText
    private lateinit var etPassword: EditText
    private lateinit var txtForgotPassword: TextView
    lateinit var sharedPreferences: SharedPreferences

    /*Default password and phone number for login*/
    val validMobileNumber = "8295935601"
    val validPassword = "1234"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        title = "Log In"

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*Initialising the views with the ones defined in the XML*/
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        registerYourself = findViewById(R.id.txtRegisterYourself)
        login = findViewById(R.id.btnLogin)

        /*Handling the clicks using the setOnClickListener method*/
        txtForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }
        registerYourself.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }


        login.setOnClickListener {
            /*Checking login credentials*/
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            /*Declaring the intent which sets up the route for the navigation of the activity*/
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            if ((mobileNumber == validMobileNumber)) {
                if (password == validPassword) {
                    startActivity(intent)
                    savePreferences()
                } else {
                    Toast.makeText(this@LoginActivity, "Incorrect Password", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_SHORT)
                    .show()
            }

        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences() {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
    }
}
