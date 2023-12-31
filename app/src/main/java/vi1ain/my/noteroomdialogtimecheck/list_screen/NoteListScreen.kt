package vi1ain.my.noteroomdialogtimecheck.list_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomdialogtimecheck.data.MyString
import vi1ain.my.noteroomdialogtimecheck.card_screen.CardScreen
import vi1ain.my.noteroomdialogtimecheck.data.NoteViewModel
import vi1ain.my.noteroomdialogtimecheck.dialog.DialogController
import vi1ain.my.noteroomdialogtimecheck.ui.theme.LightGreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun NoteListScreen(navController: NavHostController, noteViewModel: NoteViewModel) {
    val noteList = noteViewModel.noteList.collectAsState(initial = emptyList())

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }



    if (noteViewModel.dialogState) {
        DialogController(
            noteViewModel = noteViewModel,
            onDismissRequest = { noteViewModel.dialogState = false },
            dismissButton = { noteViewModel.dialogState = false },
            confirmButton = {
                noteViewModel.insertNote()
                noteViewModel.dialogState = false
            }
        )
    }
    Scaffold(snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }, floatingActionButton = {
        ExtendedFloatingActionButton(onClick = {
            noteViewModel.dialogState = true

        }) {
            Icon(Icons.Default.Add, contentDescription = MyString.ADD)
            Text(MyString.ADD)
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(LightGreen), contentPadding = PaddingValues(bottom = 80.dp),
            content = {
                items(noteList.value) { noteItem ->
                    CardScreen(
                        scope = scope,
                        snackbarHostState = snackbarHostState,
                        navController = navController,
                        noteItem = noteItem,
                        noteViewModel = noteViewModel,
                        onClick = { item ->
                            noteViewModel.noteCheckItem = item
                            noteViewModel.titleState = item.title
                            noteViewModel.descriptionState = item.description
                        }
                    )
                }
            })
    }
}