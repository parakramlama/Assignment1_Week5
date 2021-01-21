package com.parakram.assignment1_week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.parakram.assignment1_week5.modules.Post
import com.parakram.assignment1_week5.modules.Users

class CreatepostActivity : AppCompatActivity() {
    private lateinit var etPostImageLink: EditText
    private lateinit var etCaption: EditText
    private lateinit var btnSubmit: Button
    private var arrUser = arrayListOf<Users>()

    private var postDetails = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createpost)

        etPostImageLink = findViewById(R.id.etPostImageLink)
        etCaption = findViewById(R.id.etCaption)
        btnSubmit = findViewById(R.id.btnSubmit)

        if(intent != null){
            arrUser = intent.getSerializableExtra("user") as ArrayList<Users>
        }

        btnSubmit.setOnClickListener{
            if(intent != null){
                val userName = intent.getStringExtra("userName").toString()
                val profileLink = intent.getStringExtra("profileLink").toString()

                val postImageLink = etPostImageLink.text.toString()
                val caption = etCaption.text.toString()

                val postDetails = intent.getSerializableExtra("post") as ArrayList<Post>

                val post = Post(userName, profileLink, postImageLink, caption)
                postDetails.add(post)

                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("postDetails", postDetails)
                intent.putExtra("user", arrUser)
                intent.putExtra("profileLink", profileLink)
                startActivity(intent)
            }
        }
    }

    private fun checkEmptyValues(): Boolean {
        var flag = true
        when {
            TextUtils.isEmpty(etPostImageLink.text) -> {
                etPostImageLink.error = "Please enter photo link"
                etPostImageLink.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etCaption.text) -> {
                etCaption.error = "Please enter caption"
                etCaption.requestFocus()
                flag = false
            }
        }
        return flag
    }
}



