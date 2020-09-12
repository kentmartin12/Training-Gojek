package com.example.bnccapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bnccapplication.adapter.HotlineAdapter
import com.example.bnccapplication.adapter.LookUpAdapter
import kotlinx.android.synthetic.main.activity_lookup.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException
import java.lang.Exception

class LookupActivity : AppCompatActivity() {

    private val okHttpClient = OkHttpClient()

    private val mockLookUpList = mutableListOf<LookUpData>(
        LookUpData("DKI Jakarta", 16538, 10444,736),
        LookUpData("Sumatera", 12345, 3200, 458),
        LookUpData("Papua", 1236, 147, 148),
        LookUpData("Kalimantan", 2545, 50, 150)
    )

    private val mockHotlineList = mutableListOf(
        HotlineData(name = "Loading...", imgIcon = "", phone = "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lookup)

        btnBack.setOnClickListener{
            openMainActivity()
        }

        val lookUpAdapter = LookUpAdapter(mockLookUpList)
        val hotlineAdapter = HotlineAdapter(mockHotlineList)
        rvLookUp.layoutManager = LinearLayoutManager(this)
//        rvLookUp.adapter = lookUpAdapter
        rvLookUp.adapter = hotlineAdapter

        val request = Request.Builder()
            .url("https://bncc-corona-versus.firebaseio.com/v1/hotlines.json")
            .build()

        okHttpClient.newCall(request)
            .enqueue(
                getCallback(hotlineAdapter)
            )
    }

    private fun getCallback(hotlineAdapter: HotlineAdapter): Callback{
        return object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                this@LookupActivity.runOnUiThread {
                    Toast.makeText(this@LookupActivity, e.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    val jsonString = response.body?.string()
                    val jsonArray = JSONArray(jsonString)
                    val hotlineListFromNetwork = mutableListOf<HotlineData>()

                    for(i in 0 until jsonArray.length()){
                        hotlineListFromNetwork.add(
                            HotlineData(
                                imgIcon = jsonArray.getJSONObject(i).getString("img_icon"),
                                phone = jsonArray.getJSONObject(i).getString("phone"),
                                name = jsonArray.getJSONObject(i).getString("name")
                            )
                        )
                    }
                    this@LookupActivity.runOnUiThread {
                        hotlineAdapter.updateData(hotlineListFromNetwork)
                    }
                    hotlineAdapter.updateData(hotlineListFromNetwork)
                }catch (e: Exception){
                    this@LookupActivity.runOnUiThread {
                        Toast.makeText(this@LookupActivity, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun openMainActivity(){
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(MainActivity.EXTRAS, "this is from lookup activity")
        }
        startActivity(intent)
    }

}