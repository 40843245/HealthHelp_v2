package com.tibame.tip101.group_02.healthhelp_v2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.tibame.tip101.group_02.healthhelp_v2.frame.MyResultSetFrame
import com.tibame.tip101.group_02.healthhelp_v2.screen.MainScreen
import com.tibame.tip101.group_02.healthhelp_v2.stringresourcesingleton.StringResourceSingleton
import com.tibame.tip101.group_02.healthhelp_v2.ui.theme.HealthHelp_v2Theme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthHelp_v2Theme {
                Main()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Main(){
    Init()
    MainScreen()
    //MyResultSetFrame()
}

@Composable
fun Init(){
    StringResourceSingleton.initResources()
}