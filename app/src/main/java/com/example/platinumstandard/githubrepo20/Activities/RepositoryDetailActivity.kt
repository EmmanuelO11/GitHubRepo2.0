package com.example.platinumstandard.githubrepo20.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.platinumstandard.githubrepo20.Holders.RepoListViewHolder
import com.example.platinumstandard.githubrepo20.Models.RepoListModel.RepoUserList
import com.example.platinumstandard.githubrepo20.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_repository_detail.*

class RepositoryDetailActivity : AppCompatActivity() {

    var  repoPage: RepoUserList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_detail)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Repository"

        val repoPageJson = intent.getStringExtra(RepoListViewHolder.TAG)
        repoPage = Gson().fromJson<RepoUserList>(repoPageJson, RepoUserList::class.java)

        repo_detail_webview?.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return true
            }

        }

        repo_detail_webview.loadUrl(repoPage!!.html_url)

    }
}
