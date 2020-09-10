package com.example.bnccapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bnccapplication.adapter.LookUpAdapter
import kotlinx.android.synthetic.main.activity_lookup.*

class LookupActivity : AppCompatActivity() {

    private val mockLookUpList = mutableListOf<LookUpData>(
        LookUpData("DKI Jakarta", 16538, 10444,736),
        LookUpData("Sumatera", 12345, 3200, 458),
        LookUpData("Papua", 1236, 147, 148),
        LookUpData("Kalimantan", 2545, 50, 150)
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