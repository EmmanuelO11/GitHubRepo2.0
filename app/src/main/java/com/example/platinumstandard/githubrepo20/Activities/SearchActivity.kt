package com.example.platinumstandard.githubrepo20.Activities

import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import com.example.platinumstandard.githubrepo20.R
import com.example.platinumstandard.githubrepo20.UserDataProvider
import com.example.platinumstandard.githubrepo20.Adapters.UserListRecyclerAdapter
import kotlinx.android.synthetic.main.activity_search.*
import java.lang.Exception

class SearchActivity : AppCompatActivity() {

    private var mAdapter: UserListRecyclerAdapter = UserListRecyclerAdapter()
    private var dataProvider: UserDataProvider = UserDataProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        search_results_recycler.layoutManager = LinearLayoutManager(this)
        search_results_recycler.adapter = mAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home){
            finish()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)

        val searchItem = menu!!.findItem(R.id.action_search)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = searchItem!!.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)
        searchView.requestFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                // do the search and update the elements
                    dataProvider?.search(query, { searchUsers ->
                        mAdapter.currentResult.clear()
                        mAdapter.currentResult.addAll(searchUsers.items)
                        runOnUiThread { mAdapter.notifyDataSetChanged() }
                    })
                println("updated search")

                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })


        return super.onCreateOptionsMenu(menu)
    }
}


