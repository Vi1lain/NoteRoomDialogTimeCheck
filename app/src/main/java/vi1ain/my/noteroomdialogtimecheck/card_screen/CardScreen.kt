package vi1ain.my.noteroomdialogtimecheck.card_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import vi1ain.my.noteroomdialogtimecheck.data.MyString
import vi1ain.my.noteroomdialogtimecheck.data.NoteEntity
import vi1ain.my.noteroomdialogtimecheck.data.NoteViewModel
import vi1ain.my.noteroomdialogtimecheck.navigation.Route
import vi1ain.my.noteroomdialogtimecheck.ui.theme.LightBlue
import vi1ain.my.noteroomdialogtimecheck.ui.theme.Red
import vi1ain.my.noteroomdialogtimecheck.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CardScreen(
    navController: NavHostController,
    noteItem: NoteEntity,
    noteViewModel: NoteViewModel,
    onClick: (NoteEntity) -> Unit,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 5.dp, end = 5.dp)
            .clickable {
                onClick(noteItem)
                navController.navigate(Route.EDIT_CARD) }
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            Row(Modifier.fillMaxWidth()) {

                Text(
                    modifier = Modifier
                        .padding(top = 7.dp, start = 7.dp)
                        .weight(1f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    text = noteItem.title
                )
                Text(
                    modifier = Modifier.padding(top = 7.dp, end = 7.dp),
                    fontSize = 12.sp,
                    color = LightBlue,
                    text = noteItem.time
                )
                Checkbox(checked = noteItem.isCheck, onCheckedChange = {check -> noteItem.isCheck
                noteViewModel.checkedNote(noteItem.copy(isCheck =check ))})
            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(top = 3.dp, start = 7.dp, bottom = 7.dp)
                        .weight(1f),
                    fontSize = 14.sp,
                    maxLines = 2,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis,
                    text = noteItem.description
                )
                IconButton(onClick = {
                    scope.launch { val result = snackbarHostState
                        .showSnackbar(
                            message = MyString.SNAKBAR_MESSAGE,
                            actionLabel = MyString.RE_ITEM,
                            duration = SnackbarDuration.Short
                        )
                        if (result == SnackbarResult.ActionPerformed) {
                            noteViewModel.snackBarItem(noteItem)
                        }
                    }
                    noteViewModel.deleteNote(noteItem)
                }) {
                    Icon(
                        tint = Red,
                        imageVector = Icons.Default.Delete,
                        contentDescription = MyString.DELETE
                    )
                }
            }

        }
    }

}