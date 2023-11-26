package vi1ain.my.noteroomdialogtimecheck.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vi1ain.my.noteroomdialogtimecheck.data.NoteViewModel
import vi1ain.my.noteroomdialogtimecheck.edit_screen.EditScreen
import vi1ain.my.noteroomdialogtimecheck.list_screen.NoteListScreen

@Composable
fun MyNavigation (noteViewModel: NoteViewModel = viewModel(factory = NoteViewModel.factory)){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  Route.NOTE_LIST){
        composable(Route.NOTE_LIST){NoteListScreen(navController = navController,noteViewModel = noteViewModel)}
        composable(Route.EDIT_CARD){ EditScreen(navController = navController,noteViewModel = noteViewModel) }
    }
}