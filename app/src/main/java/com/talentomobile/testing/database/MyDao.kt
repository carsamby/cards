package com.talentomobile.testing.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.talentomobile.testing.model.Account

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: Account?)

    @Query("SELECT * FROM ACCOUNT_TABLE")
    fun getAllAccounts(): LiveData<List<Account>>

}
