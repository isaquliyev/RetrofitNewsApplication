package com.example.newsapplication1905.network

import com.example.newsapplication1905.Constants
import com.example.newsapplication1905.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        var instance: RetrofitClient? = null
        lateinit var myApi: Api
        fun getInstances(): RetrofitClient? {
            if (instance == null) {
                val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                myApi = retrofit.create(Api::class.java)
                instance = RetrofitClient()
            }
            return instance
        }
    }

    fun getMyApi(): Api {
        return myApi
    }
}