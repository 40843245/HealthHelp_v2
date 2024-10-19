package com.tibame.tip101.group_02.healthhelp_v2.viewmodel

import com.tibame.tip101.group_02.healthhelp_v2.dataclasses.Diary

object DiaryViewModel {
    val diaries = mutableListOf<Diary>()

    fun addDiary(
        name:String,
        foodName:String,
        date:String,
        time:String,
    ){
        val diary = Diary(
            name = name,
            foodName = foodName ,
            date = date,
            time = time,
        )
        diaries.add(diary)
    }
}