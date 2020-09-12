package com.example.bnccapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bnccapplication.adapter.HotlineAdapter
import kotlinx.android.synthetic.main.activity_lookup.*
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    companion object{
        const val EXTRAS = "Extras"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLookup.setOnClickListener{
            openLookupActivity()
        }
    }

    private fun openLookupActivity(){
        val intent = Intent(this, LookupActivity::class.java).apply {
            putExtra(EXTRAS, "this is from main activity")
        }
        startActivity(intent)
    }
}