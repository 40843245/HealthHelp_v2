package com.tibame.tip101.group_02.healthhelp_v2.components.textfield.outlinedtextfield

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.rememberTimePickerState
import java.util.Calendar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import com.tibame.tip101.group_02.healthhelp_v2.util.datetime.TimeUtil
import com.tibame.tip101.group_02.healthhelp_v2.components.picker.timepicker.TimePickerModal
import com.tibame.tip101.group_02.healthhelp_v2.stringresourcesingleton.StringResourceSingleton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeTextField(
    modifier: Modifier = Modifier,
    mutableStateValue : MutableState<String>,
    onValueChange: ((String)-> Unit) = {},
) {
    val state = rememberTimePickerState()
    var shouldShowTimePicker by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .onFocusChanged { focusState ->
                if (focusState.isFocused) {
                    shouldShowTimePicker = true
                }
            },
        value = mutableStateValue.value,
        onValueChange = onValueChange,
        label = { Text(StringResourceSingleton.DIARY_DIET_TIME_LABEL) },
        readOnly = true,
        trailingIcon = {
            IconButton(
                onClick = {
                    mutableStateValue.value = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = StringResourceSingleton.CLEAR_ICON,
                )
            }
        },
    )

    if (shouldShowTimePicker) {
        TimePickerModal.DialUseStateModal(
            onDismiss = { shouldShowTimePicker = false },
            onConfirm = {
                val cal = Calendar.getInstance()
                cal.set(Calendar.HOUR_OF_DAY, state.hour)
                cal.set(Calendar.MINUTE, state.minute)
                cal.isLenient = false
                mutableStateValue.value  = TimeUtil.convertMillisToTime(cal.timeInMillis)
                shouldShowTimePicker = false
            },
        )
    }
}