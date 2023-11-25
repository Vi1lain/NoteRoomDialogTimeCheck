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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomdialogtimecheck.data.MyString
import vi1ain.my.noteroomdialogtimecheck.navigation.Route
import vi1ain.my.noteroomdialogtimecheck.ui.theme.LightBlue
import vi1ain.my.noteroomdialogtimecheck.ui.theme.Red
import vi1ain.my.noteroomdialogtimecheck.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CardScreen(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 5.dp, end = 5.dp).clickable { navController.navigate(Route.EDIT_CARD) }
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
                    text = "Title"
                )
                Text(
                    modifier = Modifier.padding(top = 7.dp, end = 7.dp),
                    fontSize = 12.sp,
                    color = LightBlue,
                    text = "24.11.23 - 12.00"
                )
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
                    text = "description"
                )
                IconButton(onClick = { /*TODO*/ }) {
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