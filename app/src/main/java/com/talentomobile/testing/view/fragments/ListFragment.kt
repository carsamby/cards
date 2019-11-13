package com.talentomobile.testing.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.talentomobile.testing.R
import com.talentomobile.testing.model.Account
import com.talentomobile.testing.view.fragments.recyclerview.MyRecyclerAdapter
import kotlinx.android.synthetic.main.list_fragment.*
import kotlinx.android.synthetic.main.list_fragment.view.*

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.list_fragment, container, false).apply {
        // set basic toggle listener
        this.fab_toggle.setOnClickListener {
            if (viewModel.showAll) showOnlyVisibleAccounts() else showAllAccounts()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // init viewmodel
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        viewModel.getAccounts()?.observe(this, Observer {
            viewModel.mAccounts = it ?: return@Observer
            recycler_account.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            recycler_account.adapter = MyRecyclerAdapter(it as ArrayList<Account>)
        })
    }

    /**
     * Function that refreshes the recyclerview showing all accounts
     */
    private fun showAllAccounts(){
        recycler_account.adapter = MyRecyclerAdapter(viewModel.mAccounts as ArrayList<Account>)
        fab_toggle.setImageResource(R.drawable.ic_visibility_black_24dp)
        viewModel.showAll = true
    }

    /**
     * Function that refreshes the recyclerview showing only visible accounts
     */
    private fun showOnlyVisibleAccounts(){
        recycler_account.adapter = MyRecyclerAdapter(viewModel.getVisibleAccounts() as ArrayList<Account>)
        fab_toggle.setImageResource(R.drawable.ic_visibility_off_black_24dp)
        viewModel.showAll = false
    }

}
