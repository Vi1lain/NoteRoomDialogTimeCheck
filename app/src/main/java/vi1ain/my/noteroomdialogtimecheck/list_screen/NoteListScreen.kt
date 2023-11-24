package vi1ain.my.noteroomdialogtimecheck.list_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomdialogtimecheck.data.MyString
import vi1ain.my.noteroomdialogtimecheck.card_screen.CardScreen
import vi1ain.my.noteroomdialogtimecheck.ui.theme.LightGreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun NoteListScreen(navController: NavHostController) {
    Scaffold(floatingActionButton = {
        ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.Add, contentDescription = MyString.ADD)
            Text(MyString.ADD)
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(LightGreen), contentPadding = PaddingValues(bottom = 80.dp),
            content = { items(30) { index -> CardScreen(navController) } })
    }
}