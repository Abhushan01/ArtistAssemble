package com.aditya.artistassemble.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aditya.artistassemble.R
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_success.*
import kotlinx.android.synthetic.main.activity_success.txtCost

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        intent = getIntent()
        txtCost.text = intent.getStringExtra("artCost")

        btnSuccess.setOnClickListener {
            val join = Intent(this@SuccessActivity, MainActivity::class.java)
            startActivity(join)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}