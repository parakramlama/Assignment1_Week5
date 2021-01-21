package com.parakram.assignment1_week5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parakram.assignment1_week5.R
import com.parakram.assignment1_week5.modules.Users
import de.hdodenhof.circleimageview.CircleImageView

class UsersAdapter(
    val lstUser: ArrayList<Users>,
    val context: Context,
    val viewTypeId: Int
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProfile: CircleImageView
        val tvUsername: TextView

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvUsername = view.findViewById(R.id.tvUsername)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return when (viewTypeId) {
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_list_layout, parent, false)
                UserViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.story_layout, parent, false)
                UserViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = lstUser[position]
        holder.tvUsername.text = user.username
        Glide.with(context)
            .load(user.profileLink)
            .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return lstUser.size
    }
}

