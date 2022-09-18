package com.developper.investproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.developper.investproject.`class`.Constants.Companion.baza
import com.developper.investproject.`class`.Constants.Companion.key_Email
import com.developper.investproject.`class`.Constants.Companion.key_User
import com.developper.investproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var preferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        preferences = getSharedPreferences(baza, MODE_PRIVATE)



        binding.btnSignUp.setOnClickListener {

            val email = binding.edEmail.text.toString()
            val user = binding.edUser.text.toString()
            if (email.isNullOrEmpty()) {

                binding.edEmail.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            } else if (user.isNullOrEmpty()) {

                binding.edUser.setHintTextColor(ContextCompat.getColor(this, R.color.red))
            } else {

                saveUser(email, user)
                Toast.makeText(this, "Account created $user", Toast.LENGTH_LONG).show()
                intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            finish()
        }
    }


    fun saveUser(email: String, user: String) {
        val myEdit: SharedPreferences.Editor = preferences.edit()
        myEdit.putString(key_Email, email)
        myEdit.putString(key_User, user)

        myEdit.apply()
        finish()
    }

}