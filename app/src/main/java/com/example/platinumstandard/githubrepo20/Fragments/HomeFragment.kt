package com.example.platinumstandard.githubrepo20.Fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.platinumstandard.githubrepo20.Activities.SearchActivity
import com.example.platinumstandard.githubrepo20.R
import com.example.platinumstandard.githubrepo20.Adapters.UserCardRecyclerAdapter
import com.example.platinumstandard.githubrepo20.UserDataProvider
import java.lang.Exception




/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {

    var searchCardView: CardView? = null
    private val dataProvider: UserDataProvider = UserDataProvider()
    var homeRecycler: RecyclerView? = null

    var mAdapter: UserCardRecyclerAdapter = UserCardRecyclerAdapter()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_home, container, false)

        searchCardView = view.findViewById(R.id.search_card_view)
        homeRecycler = view.findViewById(R.id.home_user_recycler)
        homeRecycler!!.layoutManager = LinearLayoutManager(context)
        homeRecycler!!.adapter = mAdapter


        searchCardView!!.setOnClickListener{
            val searchIntent = Intent(context, SearchActivity::class.java)
            context!!.startActivity(searchIntent)
        }


        getRandomRepos()


        return view

    }

    private fun getRandomRepos(){


       try {

        dataProvider.getRandom(1,{ searchResults ->
            mAdapter.currentResult.clear()
            mAdapter.currentResult.addAll( searchResults.items)
            activity!!.runOnUiThread {
                mAdapter.notifyDataSetChanged()

            }
        })
    }
       catch (ex: Exception){
           val builder = AlertDialog.Builder(this.context!!)
           builder.setMessage(ex.message).setTitle("oops!")
           val dialog = builder.create()
           dialog.show()
       }
    }


}