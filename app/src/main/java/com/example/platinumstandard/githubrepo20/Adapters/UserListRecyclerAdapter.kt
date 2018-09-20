package com.example.platinumstandard.githubrepo20.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.platinumstandard.githubrepo20.Models.SearchModels.ItemRepoModel
import com.example.platinumstandard.githubrepo20.R
import com.example.platinumstandard.githubrepo20.Holders.UserListViewHolder

class UserListRecyclerAdapter : RecyclerView.Adapter<UserListViewHolder>() {

    val currentResult: ArrayList<ItemRepoModel> = ArrayList<ItemRepoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.user_list_item, parent, false)

        return UserListViewHolder(cardItem)
    }

    override fun getItemCount(): Int {

        return currentResult.size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        var page = currentResult[position]
        holder?.updateWithPage(page)
    }
}
