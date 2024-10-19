package com.tibame.tip101.group_02.healthhelp_v2.components.iconbutton.navigationicon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.tibame.tip101.group_02.healthhelp_v2.stringresourcesingleton.StringResourceSingleton

@Composable
fun HamburgerNavigationIcon(){
    IconButton(onClick = {

    }){
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = StringResourceSingleton.HAMBURGER_ICON,
        )
    }
}