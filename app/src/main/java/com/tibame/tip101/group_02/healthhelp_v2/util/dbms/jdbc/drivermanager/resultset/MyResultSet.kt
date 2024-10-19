package com.tibame.tip101.group_02.healthhelp_v2.util.dbms.jdbc.drivermanager.resultset

import android.util.Log
import java.sql.ResultSet
import java.sql.ResultSetMetaData

class MyResultSet(
    val resultSet: ResultSet,
    val separator: Char,
) {
    private val TAG = "MyResultSet"
    val metaData: ResultSetMetaData
        get() //= this.resultSet.metaData
            {
                Log.d(TAG, "metaData was called.")
                return this.resultSet.metaData
            }

    val columnCount: Int
        get() //= metaData.columnCount
        {
            Log.d(TAG, "columnCount was called.")
            return metaData.columnCount
        }

    val columnNames: List<String>
        get() {
            Log.d(TAG, "columnNames was called.")
            val names = mutableListOf("")
            for (i in 0..this.columnCount - 1) {
                names.add(this.metaData.getColumnName(i))
            }
            return names.toList()
        }

    val valueAsText: List<String>
        get() {
            Log.d(TAG, "valueAsText was called.")
            val valuesAsText = mutableListOf("")
            val stringBuilder = StringBuilder()
            while (this.resultSet.next()) {
                stringBuilder.clear()
                stringBuilder.append(this.resultSet.getString(this.columnNames[0]))
                for (elem in this.columnNames) {
                    stringBuilder.append(this.separator)
                    stringBuilder.append(this.resultSet.getString(elem))
                }
                stringBuilder.append("\n")

                valuesAsText.add(stringBuilder.toString())
            }
            return valuesAsText.toList()
        }

    val dataAsText: List<String>
        get() {
            Log.d(TAG, "dataAsText was called.")
            val dataAsText = mutableListOf("")
            val stringBuilder = StringBuilder()
            while (this.resultSet.next()) {
                stringBuilder.clear()
                stringBuilder.append("${this.columnNames[0]}:${this.resultSet.getString(this.columnNames[0])}")
                for (elem in this.columnNames) {
                    stringBuilder.append(this.separator)
                    stringBuilder.append("${elem}:${this.resultSet.getString(elem)}")
                }
                stringBuilder.append("\n")

                dataAsText.add(stringBuilder.toString())
            }
            return dataAsText.toList()
        }
}