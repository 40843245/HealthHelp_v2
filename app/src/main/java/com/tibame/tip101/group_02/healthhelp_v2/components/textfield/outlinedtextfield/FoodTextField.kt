package com.tibame.tip101.group_02.healthhelp_v2.components.textfield.outlinedtextfield

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.tibame.tip101.group_02.healthhelp_v2.components.dropdown.dropmenu.MyExposedDropDownMenu
import com.tibame.tip101.group_02.healthhelp_v2.stringresourcesingleton.StringResourceSingleton

@Composable
fun FoodTextField(
    modifier: Modifier = Modifier,
    mutableStateValue : MutableState<String>,
    onValueChange: (String)-> Unit,
){
    val options = listOf("Apple","Banana")
    MyExposedDropDownMenu(
        mutableStateValue = mutableStateValue,
        options = options,
        label = {Text(StringResourceSingleton.DIARY_DIET_FOOD_LABEL)},
        onValueChangedEvent = onValueChange,
        modifier = modifier,
    )
}