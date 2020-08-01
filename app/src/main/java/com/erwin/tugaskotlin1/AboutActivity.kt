package com.erwin.tugaskotlin1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnDialWa: Button = findViewById(R.id.btn_whatsapp)
        btnDialWa.setOnClickListener(this)

        val titlebar = findViewById<TextView>(R.id.toolbarTittle)
        titlebar.setText("Halaman About")

        val btnHome = findViewById<ImageButton>(R.id.toolbarHome)
        btnHome.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.toolbarHome -> {
                val moveIntent = Intent(this@AboutActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_whatsapp -> {
                val number = "6282284363365"
                val url = "https://api.whatsapp.com/send?phone=" + number
                val dialWaIntent = Intent(Intent.ACTION_VIEW)
                dialWaIntent.setData(Uri.parse(url))
                startActivity(dialWaIntent)
            }
        }
    }
}
