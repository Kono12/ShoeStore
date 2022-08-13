package com.udacity.shoestore

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

open class Login : AppCompatActivity() {
        lateinit var shared: SharedPreferences


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            shared = getSharedPreferences("LOGINNN", Context.MODE_PRIVATE)


            val Login = shared.getBoolean("state", false)
            //TODO:Login to shared preferences
            if (Login) {
                val intent = Intent(this.applicationContext, AppFragmentsActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val BTN: Button = findViewById(R.id.login_btn)
                BTN.setOnClickListener {
                    val Email: EditText = findViewById(R.id.EmailET)
                    val Pass: EditText = findViewById(R.id.PassET)
                    var email = Email.text
                    var pass = Pass.text
                    Loged()

                    Toast.makeText(this, "" +
                            "Welcome "+ email, Toast.LENGTH_LONG)
                        .show()

                    val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()



                }
            }
        }

     fun  Loged() {
        shared = getSharedPreferences("LOGINNN", Context.MODE_PRIVATE)
        val edit = shared.edit()
        edit.putBoolean("state", true)
        edit.apply()
    }

    fun signUp(view: View) {
            Toast.makeText(this,"Account was created", Toast.LENGTH_SHORT)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }