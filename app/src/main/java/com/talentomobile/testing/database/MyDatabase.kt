package com.talentomobile.testing.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.talentomobile.testing.model.ACCOUNT_TABLE
import com.talentomobile.testing.model.Account


@Database(entities = [Account::class], version = 6)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        private var instance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, ACCOUNT_TABLE)
                .fallbackToDestructiveMigration()
                .build()

    }

    abstract fun mDao(): MyDao

}
