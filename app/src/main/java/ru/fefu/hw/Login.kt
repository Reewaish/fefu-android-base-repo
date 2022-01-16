package ru.fefu.hw

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class Login : AppCompatActivity(R.layout.login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_login)

        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, Welcome::class.java)
            finish()
        }

    }
}