package com.tibame.tip101.group_02.healthhelp_v2.components.picker.datepickerinputstate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * MyDatePickerDialog
 *
 * a class than can pop up a date picker
 */

class MyDatePickerDialogInputState(
    private val buttonText:String,
    private val modifier: Modifier = Modifier.height(40.dp).fillMaxWidth(),
    private val onDateSelected: (String) -> Unit,
){
    @Composable
    fun popUp(){
        var showDatePicker by remember { mutableStateOf(false) }
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Button(
                modifier = Modifier.fillMaxSize(),
                onClick = { showDatePicker = true }
            ) {
                Text(text = buttonText)
            }
        }

        if (showDatePicker) {
            MyDatePickerDialogInputStateUtil.popUp(
                onDateSelected = onDateSelected,
                onDismiss = { showDatePicker = false }
            )
        }
    }
}