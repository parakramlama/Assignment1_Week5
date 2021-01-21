package com.parakram.assignment1_week5

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.parakram.assignment1_week5.modules.Users

class SingupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etProfileLink: EditText
    private lateinit var etCovID: EditText
    private lateinit var etFName: EditText
    private lateinit var etLName: EditText
    private lateinit var etSignUsername: EditText
    private lateinit var etSignPassword: EditText
    private lateinit var spinner: Spinner
    private lateinit var btnSignUp: Button

    private val batch = arrayListOf("25A", "25B", "25C", "25D")
    private var arrUser = arrayListOf<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        etProfileLink = findViewById(R.id.etProfileLink)
        etCovID = findViewById(R.id.etCovID)
        etFName = findViewById(R.id.etFName)
        etLName = findViewById(R.id.etLName)
        etSignUsername = findViewById(R.id.etSignUsername)
        etSignPassword = findViewById(R.id.etSignPassword)
        spinner = findViewById(R.id.spinner)
        btnSignUp = findViewById(R.id.btnSignUp)

        if (intent != null) {
            arrUser = intent.getSerializableExtra("user") as ArrayList<Users>
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            batch
        )
        spinner.adapter = adapter

        btnSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            btnSignUp -> {
                if (checkEmptyValues()) {
                    val profileLink = etProfileLink.text.toString()
                    val covID = etCovID.text.toString().toInt()
                    val firstName = etFName.text.toString()
                    val lastName = etLName.text.toString()
                    val username = etSignUsername.text.toString()
                    val password = etSignPassword.text.toString()
                    val batch: String = spinner.selectedItem.toString()

                    val user = Users(covID, firstName, lastName, username, password, batch, profileLink)
                    arrUser.add(user)

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("user", arrUser)
                    intent.putExtra("user", arrUser)
                    startActivity(intent)
                }
            }
        }
    }

    private fun checkEmptyValues(): Boolean {
        var flag = true
        when {
            TextUtils.isEmpty(etProfileLink.text) -> {
                etProfileLink.error = "Please enter photo link"
                etProfileLink.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etCovID.text) -> {
                etCovID.error = "Please enter your coventry ID"
                etCovID.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etFName.text) -> {
                etFName.error = "Please enter your first name"
                etFName.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etLName.text) -> {
                etLName.error = "Please enter your last name"
                etLName.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etSignUsername.text) -> {
                etSignUsername.error = "Please enter your username"
                etSignUsername.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etSignPassword.text) -> {
                etSignPassword.error = "Please enter your password"
                etSignPassword.requestFocus()
                flag = false
            }
        }
        return flag
    }
}


