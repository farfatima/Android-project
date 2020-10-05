package com.example.fooddelivery

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegistrationActivity : AppCompatActivity() {

    lateinit var text_name:EditText
    lateinit var text_email:EditText
    lateinit var text_phno:EditText
    lateinit var text_delv_address:EditText
    lateinit var text_pass:EditText
    lateinit var text_conform_pass:EditText
    lateinit var btn_register:Button
    lateinit var sharedPrefrences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setTitle("Register Yourself")
        sharedPrefrences = getSharedPreferences(getString(R.string.prefrence_file_name), Context.MODE_PRIVATE)

        text_name = findViewById(R.id.text_name)
        text_email = findViewById(R.id.text_email)
        text_phno = findViewById(R.id.text_phno)
        text_pass = findViewById(R.id.text_pass)
        text_delv_address = findViewById(R.id.text_delv_address)
        text_conform_pass = findViewById(R.id.text_conform_pass)
        btn_register = findViewById(R.id.btn_register)

        btn_register.setOnClickListener{
            var name = text_name.text.toString()
            var email = text_email.text.toString()
            var phone = text_name.text.toString()
            var address = text_name.text.toString()
            val intent = Intent(this@RegistrationActivity,WelcomeUserActivity::class.java)
            savePrefrences(name,email,phone,address)
            startActivity(intent)
        }

    }

    fun savePrefrences(name:String, email:String, phone:String, address:String)
    {
        sharedPrefrences.run {
            edit().putString("name",name).apply()
            edit().putString("email",email).apply()
            edit().putString("phone",phone).apply()
            edit().putString("address",address).apply()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}