package com.example.platinumstandard.githubrepo20.Holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.platinumstandard.githubrepo20.Models.HomeModels.ItemUserModel
import com.example.platinumstandard.githubrepo20.R

import com.squareup.picasso.Picasso

class UserCardViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val userAvatarImage: ImageView = view.findViewById(R.id.user_image)
    private val logintextView : TextView = view.findViewById(R.id.user_login)

    private var currentPage: ItemUserModel? = null

    fun updateWithPage(query: ItemUserModel){
        currentPage = query

        logintextView.text = query.owner!!.login

        if(query.owner != null){
            Picasso.with(itemView.context).load(query.owner!!.avatar_url).into(userAvatarImage)
        }

    }
}