package com.example.platinumstandard.githubrepo20.Holders

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.platinumstandard.githubrepo20.Activities.RepositoryListActivity
import com.example.platinumstandard.githubrepo20.Models.RepoListModel.RepoUserList
import com.example.platinumstandard.githubrepo20.Models.SearchModels.ItemRepoModel
import com.example.platinumstandard.githubrepo20.R
import com.google.gson.Gson

import com.squareup.picasso.Picasso

class UserListViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val userAvatarImage: ImageView = view.findViewById(R.id.result_icon)
    private val logintextView : TextView = view.findViewById(R.id.result_title)

    private var currentPage: ItemRepoModel? = null


    companion object {
        val TAG = "page"
    }

    init {
        view.setOnClickListener { view: View ->

            var repoListIntent = Intent(view.context, RepositoryListActivity::class.java)
            var pageJson = Gson().toJson(currentPage)
            repoListIntent.putExtra(TAG, pageJson)
            view.context.startActivity(repoListIntent)

        }
    }

    fun updateWithPage(query: ItemRepoModel){
        currentPage = query

        logintextView.text = query.login

        if(query.avatar_url != null){
            Picasso.with(itemView.context).load(query.avatar_url).into(userAvatarImage)
        }

    }
}