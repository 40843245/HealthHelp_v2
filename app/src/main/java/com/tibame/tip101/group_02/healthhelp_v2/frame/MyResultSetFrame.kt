package com.tibame.tip101.group_02.healthhelp_v2.frame

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tibame.tip101.group_02.healthhelp_v2.util.dbms.jdbc.drivermanager.MyDriverManager
import com.tibame.tip101.group_02.healthhelp_v2.util.dbms.jdbc.drivermanager.info.DriverManagerInfoEnum
import com.tibame.tip101.group_02.healthhelp_v2.util.dbms.jdbc.drivermanager.resultset.MyResultSet

@Composable
fun MyResultSetFrame(){
    val TAG = "MyResultSetFrame"

    Log.d(TAG,"MyResultSetFrame was called")
    val url = DriverManagerInfoEnum.URL.value
    val username = DriverManagerInfoEnum.USERNAME.value
    val password = DriverManagerInfoEnum.PASSWORD.value
    Log.d(TAG,"url = ${url}")
    Log.d(TAG,"username = ${username}")
    Log.d(TAG,"password = ${password}")
    val myDriverManager = MyDriverManager(
        url = url,
        username = username,
        password = password,
    )

    Log.d(TAG,"create a MyDriverManager instance successfully")

    /*
    val sqlCommand = "SELECT * FROM `user` WHERE userId = ? AND userEmail = ? ;"

    val userId = 2
    val userEmail = "jayw711kb@gmail.com"

    val valueForPreparation = listOf<Any>(userId,userEmail)

    Log.d(TAG,"ready to set  a MyDriverManager instance")

    myDriverManager
        .sqlCommand(sqlCommand)
        .prepareStatement()
        .prepareValue(valueForPreparation)

    Log.d(TAG,"finish to set a MyDriverManager instance")

    val statementAfterPreparation = myDriverManager.preparedStatement

    val resultSet = myDriverManager.executeQuery()

    val myResultSet = MyResultSet(
        resultSet = resultSet,
        separator = ',',
    )

    val metaData = myResultSet.metaData
    val columNames = myResultSet.columnNames
    val columnCount = myResultSet.columnCount
    val valuesAsText = myResultSet.valueAsText
    val dataAsText = myResultSet.dataAsText

    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Log.d(TAG,"enter into Column component")

        Text(statementAfterPreparation.toString())
        Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())

        Text(metaData.toString())
        Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())

        Text(columNames.toString())
        Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())

        Text(columnCount.toString())
        Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())

        Text(valuesAsText.toString())
        Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())

        Text(dataAsText.toString())
        Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())

     */
}