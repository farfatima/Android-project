package com.example.fooddelivery

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class LoginActivity : AppCompatActivity() {

    lateinit var txt_UN: EditText
    lateinit var txt_pass: EditText
    lateinit var btn_login: Button
    lateinit var txt_forgot_pass: TextView
    lateinit var txt_register: TextView
    lateinit var chef2:ImageView
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)


        sharedPreferences = getSharedPreferences(getString(R.string.prefrence_file_name), Context.MODE_PRIVATE)


        var isLoggedIn: Boolean = sharedPreferences.getBoolean("isLoggedIn",false)
        val intent= Intent(this@LoginActivity,WelcomeUserActivity::class.java)
        setContentView(R.layout.activity_main)
        if(isLoggedIn)
        {

            startActivity(intent)
            finish()
        }

        txt_UN=findViewById(R.id.txt_UN)
        txt_pass=findViewById(R.id.txt_pass)
        btn_login=findViewById(R.id.btn_login)
        txt_forgot_pass=findViewById(R.id.txt_forgot_pass)
        txt_register=findViewById(R.id.txt_register)
        chef2=findViewById(R.id.chef2)
        var valid_name= arrayOf("waqar","fariya","nadeem","shoib","Azra","mushir","mariya","bashar")

        chef2.setOnClickListener{(Toast.makeText(this@LoginActivity,"This is the logo of the application made by yours truely Waqar Ahmad using PhotoShop CC2019 ",Toast.LENGTH_LONG).show())}
        btn_login.setOnClickListener {
            var name=txt_UN.text.toString();
            var password=txt_pass.text.toString()
            if (name.length>2 && password.length>2)
            {



                savePrefrence(name,password)
                startActivity(intent)
            }
            else {
              Toast.makeText(
                    this@LoginActivity,
                    "Name and Password is too short, minimum two characters are required",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

        txt_forgot_pass.setOnClickListener {
            val intent2= Intent(this@LoginActivity,ForgetPasswordActivity::class.java)

            startActivity(intent2)
        }

        txt_register.setOnClickListener {

            val intent1= Intent(this@LoginActivity,RegistrationActivity::class.java)
            startActivity(intent1)
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePrefrence(name:String,pas:String)
    {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("name",name).apply()
        sharedPreferences.edit().putString("password",pas).apply()

    }

}