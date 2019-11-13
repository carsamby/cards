package com.talentomobile.testing.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.talentomobile.testing.database.MyRepository
import com.talentomobile.testing.model.Account

class ListViewModel(private val mApplication: Application) : AndroidViewModel(mApplication) {

    lateinit var mAccounts: List<Account>
    var showAll = true

    fun getAccounts(): LiveData<List<Account>>? = MyRepository(mApplication).getAllAccounts()

    /**
     * Function that refreshes the recyclerview showing only visible accounts
     */
    fun getVisibleAccounts(): List<Account> = mAccounts.filter { account -> account.mIsVisible }

}
