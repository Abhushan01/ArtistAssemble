package com.aditya.artistassemble.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.aditya.artistassemble.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent = getIntent()
        setContentView(R.layout.activity_order)
        var tempBundle = intent.getExtras()
        if (tempBundle != null) {
            txtArtworkName.text = tempBundle.getString("artTitle")
            txtArtistName.text = tempBundle.getString("artistName")
            txtRating.text = tempBundle.getString("artRating")
            txtCost.text = tempBundle.getString("artCost")
            imgArtworkThumbnail.setImageResource(tempBundle.getInt("artImage"))

            btnPlace.setOnClickListener {
                val join = Intent(this@OrderActivity, SuccessActivity::class.java)
                join.putExtra("artCost", tempBundle.getString("artCost"));
                startActivity(join)
            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
