package com.anggarad.dev.bangunganku

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.anggarad.dev.bangunganku.data.UserPreferences
import com.anggarad.dev.bangunganku.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPref = UserPreferences(this)

        userPref.accessToken.asLiveData().observe(this, {
            Toast.makeText(this, it ?: "Token null", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AuthActivity::class.java))
//            startActivity(Intent(this, MapsActivity::class.java))
        })

//        startActivity(Intent(this, AuthActivity::class.java))
    }
}