package com.example.bnccapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lookup.*

class LookupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lookup)

        btnBack.setOnClickListener{
            openMainActivity()
        }

    }

    private fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(MainActivity.EXTRAS, "this is from lookup activity")
        }
        startActivity(intent)
    }

}