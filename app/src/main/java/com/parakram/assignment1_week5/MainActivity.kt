package com.parakram.assignment1_week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parakram.assignment1_week5.adapter.UsersAdapter
import com.parakram.assignment1_week5.modules.Users
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var recyclerViewUser: RecyclerView
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignupPage: Button

    private var arrUser = arrayListOf<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewUser = findViewById(R.id.recyclerViewUser)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignupPage = findViewById(R.id.btnSignupPage)

        if (intent.hasExtra("user")) {
            arrUser = intent.getSerializableExtra("user") as ArrayList<Users>

            val adapter = UsersAdapter(arrUser, this@MainActivity, 1)
            recyclerViewUser.layoutManager = LinearLayoutManager(this@MainActivity)

            recyclerViewUser.adapter = adapter
        }

        btnLogin.setOnClickListener(this)
        btnSignupPage.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            btnLogin -> {
                if(checkEmptyValues()){
                    login()
                }
            }
            btnSignupPage -> {
                val intent = Intent(this, SingupActivity::class.java)
                intent.putExtra("user", arrUser)
                startActivity(intent)
            }
        }
    }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        when {
            username == "admin" && password == "admin" -> {
                Toast.makeText(this, "admin logged in", Toast.LENGTH_SHORT).show()
            }
            else -> {
                if (arrUser.size > 0) {
                    for (i in arrUser.indices) {
                        if (username == arrUser[i].username && password == arrUser[i].password) {
                            val user = mutableListOf<String>()
                            user.add(arrUser[i].username)
                            user.add(arrUser[i].profileLink)

                            val intent = Intent(this, DashboardActivity::class.java)
                            intent.putExtra("user", arrUser)
                            intent.putExtra("username", arrUser[i].username)
                            intent.putExtra("profileLink", arrUser[i].profileLink)
                            startActivity(intent)
                            break
                        } else {
                            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Invalid login credential", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun checkEmptyValues(): Boolean {
        var flag = true
        when {
            TextUtils.isEmpty(etUsername.text) -> {
                etUsername.error = "Please enter your username"
                etUsername.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etPassword.text) -> {
                etPassword.error = "Please enter student name"
                etPassword.requestFocus()
                flag = false
            }
        }
        return flag
    }
}




