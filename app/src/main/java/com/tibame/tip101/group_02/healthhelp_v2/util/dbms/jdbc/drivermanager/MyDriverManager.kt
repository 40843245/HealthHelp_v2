package com.tibame.tip101.group_02.healthhelp_v2.util.dbms.jdbc.drivermanager

import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class MyDriverManager(
    val url:String,
    val username:String,
    val password:String,
) {
    val TAG = "MyDriverManager"

    private var connection : Connection = DriverManager.getConnection(
        this.url,
        this.username,
        this.password,
    )
    var sqlCommand: String = ""
    lateinit var preparedStatement: PreparedStatement

    init{
        Log.d(TAG,"this.url:${this.url}")
        Log.d(TAG,"this.username:${this.username}")
        Log.d(TAG,"this.password:${this.password}")
        try {
            if(this.connection.isClosed){
                this.connection.close()
            }
            this.connection  = DriverManager.getConnection(
                this.url,
                this.username,
                this.password,
            )
            Log.d(TAG, "init block of MyDriverManager was called.")
            Log.d(TAG, "this.url:${this.url}.")
            Log.d(TAG, "this.username:${this.username}.")
            Log.d(TAG, "this.password:${this.password}.")


            this.sqlCommand = ""
            this.preparedStatement = this.connection.prepareStatement("")
            Log.d(TAG, "init block of MyDriverManager was finished.")
        }catch (ex :Exception){
            Log.d(TAG,"message:${ex.message},stacktrace:${ex.stackTrace.joinToString { "," }}")
        }
    }

    fun sqlCommand(
        sqlCommand:String
    ): MyDriverManager {
        this.sqlCommand = sqlCommand
        return this
    }

    fun prepareStatement(): MyDriverManager {
        this.preparedStatement = this.connection.prepareStatement(this.sqlCommand)
        return this
    }

    fun prepareValue(
        values:List<Any>
    ): MyDriverManager {
        values.forEachIndexed{ index , value ->
            this.preparedStatement.setObject(index,value)
        }
        return this
    }

    fun executeQuery(): ResultSet {
        return this.preparedStatement.executeQuery()
    }

    fun executeUMDQuery():Int{
        return this.preparedStatement.executeUpdate()
    }

    fun closePreparedStatement(){
        if(this.preparedStatement!= null && this.preparedStatement.isClosed){
            this.preparedStatement.close()
        }
    }

    fun closeConnection(){
        if(this.connection!=null && this.connection.isClosed){
            this.connection.close()
        }
    }
}