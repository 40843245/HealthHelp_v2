package com.tibame.tip101.group_02.healthhelp_v2.dataclasses

import com.google.gson.annotations.SerializedName

data class Diary(
    @SerializedName("name")
    val name:String,

    @SerializedName("foodName")
    val foodName: String,

    @SerializedName("data")
    val date:String,

    @SerializedName("time")
    val time:String,
)