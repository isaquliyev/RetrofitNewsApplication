package com.example.newsapplication1905

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapplication1905.adapter.Adapter
import com.example.newsapplication1905.databinding.ActivityMainBinding
import com.example.newsapplication1905.model.Results
import com.example.newsapplication1905.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getNews()
    }

    fun getNews() {
        val call: Call<Results?>? = RetrofitClient.getInstances()!!
            .getMyApi().getNews()
        call!!.enqueue(object : Callback<Results?> {

            override fun onResponse(call: Call<Results?>, response: Response<Results?>) {
                val newsList: Results = response.body() as Results
                binding.recyclerView.adapter = Adapter(newsList)
            }

            override fun onFailure(call: Call<Results?>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }

}