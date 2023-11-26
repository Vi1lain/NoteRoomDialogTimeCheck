package vi1ain.my.noteroomdialogtimecheck.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import vi1ain.my.noteroomdialogtimecheck.data.MyString
import vi1ain.my.noteroomdialogtimecheck.data.NoteViewModel
import vi1ain.my.noteroomdialogtimecheck.ui.theme.LightGreen
import vi1ain.my.noteroomdialogtimecheck.ui.theme.Silver
import vi1ain.my.noteroomdialogtimecheck.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogController(
    noteViewModel: NoteViewModel,
    onDismissRequest:()->Unit,
    dismissButton:()->Unit,
    confirmButton:()->Unit,

                     ) {

    AlertDialog(containerColor = LightGreen,
        title = {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = MyString.NEW_ITEM)
                TextField(
                    colors = TextFieldDefaults.textFieldColors(containerColor = White),
                    label = { Text(color = Silver, text = MyString.TITLE) },
                    value = noteViewModel.titleState,
                    onValueChange = {text -> noteViewModel.titleState = text})
                TextField(
                    colors = TextFieldDefaults.textFieldColors(containerColor = White),
                    label = { Text(color = Silver, text = MyString.DESCRIPTION) },
                    value = noteViewModel.descriptionState,
                    onValueChange = {text -> noteViewModel.descriptionState = text})
            }
        },
        onDismissRequest = { onDismissRequest() },
        dismissButton = {
            TextButton(onClick = { dismissButton()}) {
                Text(text = "Закрыть")
            }
        },
        confirmButton = {
            TextButton(onClick = { confirmButton() }) {
                Text(text = "Добавить")
            }
        }
    )
}