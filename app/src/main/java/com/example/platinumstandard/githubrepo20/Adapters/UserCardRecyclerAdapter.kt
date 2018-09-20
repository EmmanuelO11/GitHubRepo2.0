package com.example.platinumstandard.githubrepo20.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.platinumstandard.githubrepo20.Models.HomeModels.ItemUserModel
import com.example.platinumstandard.githubrepo20.R
import com.example.platinumstandard.githubrepo20.Holders.UserCardViewHolder


class UserCardRecyclerAdapter : RecyclerView.Adapter<UserCardViewHolder>() {

    val currentResult: ArrayList<ItemUserModel> = ArrayList<ItemUserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCardViewHolder {
        val cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.user_card_item, parent, false)

        return UserCardViewHolder(cardItem)
    }

    override fun getItemCount(): Int {

        return currentResult.size
    }

    override fun onBindViewHolder(holder: UserCardViewHolder, position: Int) {
        var page = currentResult[position]
        holder?.updateWithPage(page)
    }
}