package vi1ain.my.noteroomdialogtimecheck.edit_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomdialogtimecheck.data.MyString
import vi1ain.my.noteroomdialogtimecheck.ui.theme.Black
import vi1ain.my.noteroomdialogtimecheck.ui.theme.HardGreen
import vi1ain.my.noteroomdialogtimecheck.ui.theme.LightGreen
import vi1ain.my.noteroomdialogtimecheck.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun EditScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(LightGreen)) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp), shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(LightGreen)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    TextField(
                        label = { Text(text = MyString.TITLE, fontSize = 12.sp) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = HardGreen
                        ), singleLine = true,
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.weight(1f),
                        value = "",
                        onValueChange = {})
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            tint = HardGreen,
                            imageVector = Icons.Default.Edit,
                            contentDescription = MyString.EDIT
                        )
                    }
                }
                TextField(
                    label = { Text(text = MyString.DESCRIPTION, fontSize = 12.sp) },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,

                        ), textStyle = TextStyle(
                        fontSize = 14.sp,
                        color = Black
                    ),
                    modifier = Modifier.fillMaxSize(),
                    value = "",
                    onValueChange = {}
                )
            }
        }
    }
}