package vi1ain.my.noteroomdialogtimecheck.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch
import vi1ain.my.noteroomdialogtimecheck.App

class NoteViewModel(val noteDB: NoteDB) : ViewModel() {
    val noteList = noteDB.noteDao.getAllNOtes()
    var noteCheckItem: NoteEntity? = null

    var titleState by mutableStateOf("")
    var descriptionState by mutableStateOf("")
    var dialogState by mutableStateOf(false)
    var time = "25.11.23-23.10"

    fun insertNote() = viewModelScope.launch {
        if (titleState.isNotEmpty()) {
            val noteItem = noteCheckItem?.copy(title = titleState, description = descriptionState)
                ?: NoteEntity(
                    title = titleState,
                    description = descriptionState,
                    time = time,
                    isCheck = noteCheckItem?.isCheck ?: false
                )
        }
    }

    fun deleteNote(noteEntity: NoteEntity) =
        viewModelScope.launch { noteDB.noteDao.deleteNote(noteEntity = noteEntity) }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val noteDatabase = (checkNotNull(extras[APPLICATION_KEY]) as App).noteDatabase
                return NoteViewModel(noteDatabase) as T
            }
        }
    }
}