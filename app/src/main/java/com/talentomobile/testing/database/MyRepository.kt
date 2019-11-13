package com.talentomobile.testing.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.talentomobile.testing.model.Account
import java.util.concurrent.Executors

data class MyRepository(val application: Application) {

    private var mDao: MyDao?

    init {
        val database = MyDatabase.getInstance(application)
        mDao = database.mDao()
    }

    fun getAllAccounts() : LiveData<List<Account>>?{

        Executors.newSingleThreadScheduledExecutor().execute {
            val mData = MyData(HARDCODED)
            mData.accounts.forEach { account -> mDao?.insert(account) }
        }

        return mDao?.getAllAccounts()
    }


}