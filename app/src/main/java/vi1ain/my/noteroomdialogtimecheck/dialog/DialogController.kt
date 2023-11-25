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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import vi1ain.my.noteroomdialogtimecheck.data.MyString
import vi1ain.my.noteroomdialogtimecheck.ui.theme.LightGreen
import vi1ain.my.noteroomdialogtimecheck.ui.theme.Silver
import vi1ain.my.noteroomdialogtimecheck.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DialogController() {
    AlertDialog(containerColor = LightGreen,
        title = {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = MyString.NEW_ITEM)
                TextField(
                    colors = TextFieldDefaults.textFieldColors(containerColor = White),
                    label = { Text(color = Silver, text = MyString.TITLE) },
                    value = "",
                    onValueChange = {})
                TextField(
                    colors = TextFieldDefaults.textFieldColors(containerColor = White),
                    label = { Text(color = Silver, text = MyString.DESCRIPTION) },
                    value = "",
                    onValueChange = {})
            }
        },
        onDismissRequest = { /*TODO*/ },
        dismissButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Закрыть")
            }
        },
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Добавить")
            }
        }
    )
}