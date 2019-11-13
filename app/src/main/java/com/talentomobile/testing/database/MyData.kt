package com.talentomobile.testing.database

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.reflect.TypeToken
import com.talentomobile.testing.model.Account

val HARDCODED = "{\n" +
        "\"accounts\": [\n" +
        "{\n" +
        "\"accountBalanceInCents\": 985000,\n" +
        "\"accountCurrency\": \"EUR\",\n" +
        "\"accountId\": 748757694,\n" +
        "\"accountName\": \"Hr P L G N StellingTD\",\n" +
        "\"accountNumber\": 748757694,\n" +
        "\"accountType\": \"PAYMENT\",\n" +
        "\"alias\": \"\",\n" +
        "\"isVisible\": true,\n" +
        "\"iban\": \"NL23INGB0748757694\"\n" +
        "},\n" +
        "{\n" +
        "\"accountBalanceInCents\": 1000000,\n" +
        "\"accountCurrency\": \"EUR\",\n" +
        "\"accountId\": 700000027559,\n" +
        "\"accountName\": \",\",\n" +
        "\"accountNumber\": 748757732,\n" +
        "\"accountType\": \"PAYMENT\",\n" +
        "\"alias\": \"\",\n" +
        "\"isVisible\": false,\n" +
        "\"iban\": \"NL88INGB0748757732\"\n" +
        "},\n" +
        "{\n" +
        "\"accountBalanceInCents\": 15000,\n" +
        "\"accountCurrency\": \"EUR\",\n" +
        "\"accountId\": 700000027559,\n" +
        "\"accountName\": \"\",\n" +
        "\"accountNumber\": \"H 177-27066\",\n" +
        "\"accountType\": \"SAVING\",\n" +
        "\"alias\": \"G\\\\UfffdLSAVINGSdiacrits\",\n" +
        "\"iban\": \"\",\n" +
        "\"isVisible\": true,\n" +
        "\"linkedAccountId\": 748757694,\n" +
        "\"productName\": \"Oranje Spaarrekening\",\n" +
        "\"productType\": 1000,\n" +
        "\"savingsTargetReached\": 1,\n" +
        "\"targetAmountInCents\": 2000\n" +
        "}\n" +
        "],\n" +
        "\"failedAccountTypes\" : \"CREDITCARDS\",\"returnCode\" : \"OK\"\n" +
        "}"

class MyData(json: String) {

    @Expose
    var accounts: ArrayList<Account>
    @Expose
    var failedAccountTypes: String
    @Expose
    var returnCode: String

    init {
        Gson().fromJson<MyData>(json, object : TypeToken<MyData>() {}.type).also {
            this.accounts = it.accounts
            this.failedAccountTypes = it.failedAccountTypes
            this.returnCode = it.returnCode
        }
    }

}