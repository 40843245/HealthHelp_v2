package com.tibame.tip101.group_02.healthhelp_v2.components.bar.appbar.topappbar

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.tibame.tip101.group_02.healthhelp_v2.components.iconbutton.navigationicon.HamburgerNavigationIcon
import com.tibame.tip101.group_02.healthhelp_v2.gson.toJson

import com.tibame.tip101.group_02.healthhelp_v2.stringresourcesingleton.StringResourceSingleton
import com.tibame.tip101.group_02.healthhelp_v2.util.sharedata.ShareData
import com.tibame.tip101.group_02.healthhelp_v2.viewmodel.DiaryViewModel


@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DietAppTopBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
){
    val currentContext = LocalContext.current
    var diaries by remember { mutableStateOf(DiaryViewModel.diaries) }
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = StringResourceSingleton.DIET_APP_TITLE,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            HamburgerNavigationIcon()
        },

        actions = {
            IconButton(onClick = {
                val jsonString = diaries.toJson()
                ShareData(
                    currentContext,
                    data = jsonString,
                )
            }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = StringResourceSingleton.SHARE_ICON,
                )
            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        scrollBehavior = scrollBehavior,
    )
}