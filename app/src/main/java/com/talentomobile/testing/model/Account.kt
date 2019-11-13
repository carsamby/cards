package com.talentomobile.testing.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

const val ACCOUNT_TABLE = "account_table"

@Entity(tableName = ACCOUNT_TABLE)
data class Account (
    @SerializedName("accountBalanceInCents")
    var balanceInCents: Int = 0,
    @SerializedName("accountCurrency")
    var currency: String = "",
    @Expose
    var accountId: Long = 0,
    @SerializedName("accountName")
    var name: String = "",
    @PrimaryKey
    @SerializedName("accountNumber")
    var number: String = "",
    @SerializedName("accountType")
    val type: String = "",
    @Expose
    var alias: String = "",
    @SerializedName("isVisible")
    var mIsVisible: Boolean = false,
    @Expose
    var iban: String = "",
    @Expose
    var linkedAccountId: Int?,
    @Expose
    var productName: String?,
    @Expose
    var productType: Int?,
    @Expose
    var savingsTargetReached: Int?,
    @Expose
    var targetAmountInCents: Int?
)