package com.example.platinumstandard.githubrepo20.Activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.platinumstandard.githubrepo20.Adapters.RepoListAdapter
import com.example.platinumstandard.githubrepo20.Holders.UserListViewHolder
import com.example.platinumstandard.githubrepo20.Models.RepoListModel.RepoResult
import com.example.platinumstandard.githubrepo20.Models.RepoListModel.RepoUserList
import com.example.platinumstandard.githubrepo20.Models.SearchModels.ItemRepoModel
import com.example.platinumstandard.githubrepo20.R
import com.example.platinumstandard.githubrepo20.UserDataProvider
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_repository_list.*

class RepositoryListActivity : AppCompatActivity() {

    private var mAdapter: RepoListAdapter = RepoListAdapter()
    private var repoPage: RepoUserList? = null
    private var currentPage: ItemRepoModel? = null
    private val dataProvider: UserDataProvider = UserDataProvider()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Repositories"

        initRecyclerView()

        val repoPageJson = intent.getStringExtra(UserListViewHolder.TAG)
        currentPage = Gson().fromJson<ItemRepoModel>(repoPageJson, ItemRepoModel::class.java)

        getSearchedRepo()
    }

    private fun initRecyclerView() {
        recycler_repo_content.layoutManager = LinearLayoutManager(this)
        recycler_repo_content.adapter = mAdapter
        val dividerItemDecoration = DividerItemDecoration(
                recycler_repo_content.context,
                DividerItemDecoration.VERTICAL
        )
        recycler_repo_content.addItemDecoration(dividerItemDecoration)
    }


    private fun getSearchedRepo(){

        dataProvider.getSearchedRepo(currentPage!!.login.toString(), 1) { repoResult ->
            mAdapter.currentResult.clear()
            mAdapter.currentResult.addAll(repoResult.items)
            this.runOnUiThread { mAdapter.notifyDataSetChanged() }
        }

    }

}
