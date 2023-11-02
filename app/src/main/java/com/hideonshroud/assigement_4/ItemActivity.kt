package com.hideonshroud.assigement_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ItemActivity : AppCompatActivity() {

    private lateinit var fullName: TextView
    private lateinit var fullDesc: TextView
    private lateinit var fullImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)


            fullName = findViewById(R.id.fullName)
            fullDesc = findViewById(R.id.fullDesc)
            fullImageView = findViewById(R.id.fullImageView)

            fullName.text = intent.getStringExtra("NAME")
            fullDesc.text = intent.getStringExtra("DESC")
            Glide.with(this)
                .load(intent.getStringExtra("IMAGE"))
                .into(fullImageView);
        }



}