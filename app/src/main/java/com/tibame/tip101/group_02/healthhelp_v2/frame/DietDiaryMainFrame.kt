package com.tibame.tip101.group_02.healthhelp_v2.frame

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Environment
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.tibame.tip101.group_02.healthhelp_v2.R
import com.tibame.tip101.group_02.healthhelp_v2.components.bar.appbar.topappbar.DietAppTopBar
import com.tibame.tip101.group_02.healthhelp_v2.components.card.DietDiaryCards
import com.tibame.tip101.group_02.healthhelp_v2.components.textfield.outlinedtextfield.SearchTextField
import com.tibame.tip101.group_02.healthhelp_v2.stringresourcesingleton.StringResourceSingleton
import com.tibame.tip101.group_02.healthhelp_v2.enumclass.ScreenEnum
import com.tibame.tip101.group_02.healthhelp_v2.gson.toJson
import com.tibame.tip101.group_02.healthhelp_v2.util.file.savingfile.saveEternal
import com.tibame.tip101.group_02.healthhelp_v2.viewmodel.DiaryViewModel
import java.io.File
import kotlin.io.path.Path

const val TAG = "DietDiaryMainFrame"

@SuppressLint("MutableCollectionMutableState")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DietDiaryMainFrame(
    navController: NavHostController,
){
    val currentContext = LocalContext.current

    var toastMessage by remember { mutableStateOf("") }
    var savingFileFlag by remember { mutableStateOf(false) }
    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()

    val diaries by remember { mutableStateOf(DiaryViewModel.diaries) }

    Scaffold(
        topBar = {
            DietAppTopBar(
                navController = navController,
            )
        },
        floatingActionButton = {
            Row{
                FloatingActionButton(
                    onClick = {
                        savingFileFlag = true
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.download),
                        contentDescription = StringResourceSingleton.ADD_NEW_ITEM_ICON,
                    )
                }

                FloatingActionButton(
                    onClick = {
                        navController.navigate(ScreenEnum.AddNewDietDiaryItemFrame.name)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = StringResourceSingleton.ADD_NEW_ITEM_ICON,
                    )
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(
                        verticalScrollState,
                    ).horizontalScroll(
                        horizontalScrollState,
                    ),
            ){
                SearchTextField(
                    navController = navController,
                    modifier = Modifier.fillMaxWidth(),
                )

                DietDiaryCards(
                    currentContext = currentContext,
                    cards = diaries,
                    modifier = Modifier.fillMaxWidth(),
                )

                if(toastMessage.isNotBlank()){
                    Toast.makeText(currentContext,toastMessage,Toast.LENGTH_LONG).show()
                } else if(savingFileFlag){
                    val fileName = "download.txt"
                    val jsonString = diaries.toJson()
                    val folder = File(
                        LocalContext.current.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),
                        fileName,
                    )
                    val fullFilePath = Path(folder.toPath().toString(),fileName)
                    val fullFile = fullFilePath.toFile()

                    val saveSuccessfully = saveEternal(fullFile,jsonString)

                    val currentActivity = LocalContext.current as Activity
                    val toastMessage = if(saveSuccessfully) "Data saved successfully." else "Data saved failed."

                    Toast.makeText(currentActivity,toastMessage,Toast.LENGTH_LONG).show()

                    savingFileFlag = false
                }
            }
        }
    )
}