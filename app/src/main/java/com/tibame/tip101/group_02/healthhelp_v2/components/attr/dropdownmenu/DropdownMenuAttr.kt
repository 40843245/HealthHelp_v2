package com.tibame.tip101.group_02.healthhelp_v2.components.attr.dropdownmenu

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Modifier

data class DropdownMenuAttr(
    val onDismissRequest:()->Unit,
    val modifier: Modifier = Modifier.wrapContentSize()
)