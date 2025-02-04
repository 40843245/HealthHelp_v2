package com.tibame.tip101.group_02.healthhelp_v2.string

import com.tibame.tip101.group_02.healthhelp_v2.dataclasses.Nutrition

fun NutritionText(
    nutritions: List<Nutrition>,
): List<String> {
    val texts: MutableList<String> = mutableListOf()
    nutritions.forEachIndexed { index, nutrition ->
        val text = "fat:${nutrition.fat}\n" +
                "carbon:${nutrition.carbon}\n" +
                "protein:${nutrition.protein}\n" +
                "fiber:${nutrition.fiber}\n" +
                "sugar:${nutrition.sugar}\n" +
                "sodium:${nutrition.sodium}\n" +
                "calories:${nutrition.calories}\n"
        texts.add(text)
    }
    return texts
}