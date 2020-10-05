package com.example.fooddelivery

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class WelcomeUserActivity : AppCompatActivity() {
    lateinit var gif_shiro:pl.droidsonroids.gif.GifImageView
  lateinit var sharedPrefrences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome_user)
        sharedPrefrences = getSharedPreferences(getString(R.string.prefrence_file_name), Context.MODE_PRIVATE)
        var name= sharedPrefrences.getString("name","")
        var pass = sharedPrefrences.getString("password","")
        var phone = sharedPrefrences.getString("phone","")
        var email = sharedPrefrences.getString("email","")
        var address = sharedPrefrences.getString("address","")


        title="Welcome $name , $pass ,$phone , $email , $address"
        gif_shiro = findViewById(R.id.gif_shiro)
        gif_shiro.setOnClickListener{Toast.makeText(this@WelcomeUserActivity,"Whoever reading this , Believe in Youself you will be Successfull one day",Toast.LENGTH_LONG).show()}


    }
}