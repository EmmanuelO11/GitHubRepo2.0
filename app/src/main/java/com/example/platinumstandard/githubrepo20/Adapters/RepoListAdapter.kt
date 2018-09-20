package com.example.platinumstandard.githubrepo20.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.platinumstandard.githubrepo20.Holders.RepoListViewHolder
import com.example.platinumstandard.githubrepo20.Models.RepoListModel.RepoUserList
import com.example.platinumstandard.githubrepo20.R

class RepoListAdapter : RecyclerView.Adapter<RepoListViewHolder>() {
    var currentResult: ArrayList<RepoUserList> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.content_repo_list, parent, false)
        return RepoListViewHolder(cardItem)
    }

    override fun getItemCount(): Int {
        return  currentResult.size
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        var page = currentResult[position]
        holder?.updayewithPage(page)
    }
}