package com.example.fooddelivery

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class ForgetPasswordActivity : AppCompatActivity() {

    lateinit var txt_mob:EditText
    lateinit var txt_em:EditText
    lateinit var img_chef:ImageView
    lateinit var btn_submit:Button
    lateinit var sharedPrefrences:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_forget_password)

        setTitle("Forget Password")

        sharedPrefrences=getSharedPreferences(getString(R.string.prefrence_file_name), Context.MODE_PRIVATE)

        var isLoggedin =   sharedPrefrences.getBoolean("isLoggedin",false)

        txt_em=findViewById(R.id.txt_em)

        txt_mob=findViewById(R.id.txt_mob)

        btn_submit=findViewById(R.id.btn_submit)

        img_chef=findViewById(R.id.img_chef)
        if(isLoggedin)
        {
            val intent = Intent(this@ForgetPasswordActivity,WelcomeUserActivity::class.java)
            startActivity(intent)
            finish()
        }

        img_chef.setOnClickListener{(Toast.makeText(this@ForgetPasswordActivity,"This is the logo of the application made by yours truely Waqar Ahmad using PhotoShop CC2019 ",Toast.LENGTH_LONG).show())}

        btn_submit.setOnClickListener {
            val em =txt_em.text.toString()
            val ph=txt_mob.text.toString()

            val intent = Intent(this@ForgetPasswordActivity,WelcomeUserActivity::class.java)
            setPrefrences(em,ph)
            startActivity(intent)
        }
    }



    fun setPrefrences(Email:String , Phone:String)
    {
        sharedPrefrences.edit().putBoolean("isLoggedin",true).apply()
        sharedPrefrences.edit().putString("name",Email).apply()
        sharedPrefrences.edit().putString("password",Phone).apply()

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}