package com.example.bnccapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bnccapplication.adapter.LookUpAdapter
import kotlinx.android.synthetic.main.activity_lookup.*

class LookupActivity : AppCompatActivity() {

    private val mockLookUpList = mutableListOf<LookUpData>(
        LookUpData("DKI Jakarta"),
        LookUpData("Sumatera"),
        LookUpData("Papua"),
        LookUpData("Kalimantan")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lookup)

        btnBack.setOnClickListener{
            openMainActivity()
        }

        val lookUpAdapter = LookUpAdapter(mockLookUpList)
        rvLookUp.layoutManager = LinearLayoutManager(this)
        rvLookUp.adapter = lookUpAdapter

    }

    private fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(MainActivity.EXTRAS, "this is from lookup activity")
        }
        startActivity(intent)
    }

}