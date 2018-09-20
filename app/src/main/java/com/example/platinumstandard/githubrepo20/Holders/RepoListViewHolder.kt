package com.example.platinumstandard.githubrepo20.Holders

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.platinumstandard.githubrepo20.Activities.RepositoryDetailActivity
import com.example.platinumstandard.githubrepo20.Activities.RepositoryListActivity
import com.example.platinumstandard.githubrepo20.Models.RepoListModel.RepoUserList
import com.example.platinumstandard.githubrepo20.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_repo_list.view.*

class RepoListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val userAvatarImage: ImageView = view.findViewById(R.id.user_imageView)
    private val loginName: TextView = view.findViewById(R.id.login_name)
    private val repoName: TextView = view.findViewById(R.id.repo_name)
    private val language: TextView = view.findViewById(R.id.language_textview)
    private val starCount: TextView = view.findViewById(R.id.star_count)

    var repoPage: RepoUserList? = null

    companion object {
        val TAG = "page"
    }
    init {
        view.setOnClickListener { view: View ->

            var repoListIntent = Intent(view.context, RepositoryDetailActivity::class.java)
            var pageJson = Gson().toJson(repoPage)
            repoListIntent.putExtra(TAG, pageJson)
            view.context.startActivity(repoListIntent)

        }
    }



    fun updayewithPage(page: RepoUserList) {
        repoPage = page

        loginName.text = page.owner!!.login
        repoName.text = page.name
        language.text = (" Language: " + page.language)
        starCount.text = page.stargazers_count.toString()

        if (page.owner!!.avatar_url != null) {
            Picasso.with(itemView.context).load(page.owner!!.avatar_url).into(userAvatarImage)


        }

    }
}
