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
import vi1ain.my.noteroomdialogtimecheck.utils.getCurrentTime

@Suppress("UNCHECKED_CAST")
class NoteViewModel(val noteDB: NoteDB) : ViewModel() {
    val noteList = noteDB.noteDao.getAllNOtes()
    var noteCheckItem: NoteEntity? = null

    var titleState by mutableStateOf("")
    var descriptionState by mutableStateOf("")
    var dialogState by mutableStateOf(false)


    fun insertNote() = viewModelScope.launch {
        if (titleState.isNotEmpty()) {
            val noteItem = noteCheckItem?.copy(title = titleState, description = descriptionState)
                ?: NoteEntity(
                    title = titleState,
                    description = descriptionState,
                    time = noteCheckItem?.time?:getCurrentTime(),
                    isCheck = noteCheckItem?.isCheck ?: false
                )
            noteDB.noteDao.insertNote(noteItem)

        }
        noteCheckItem = null
        titleState = ""
        descriptionState = ""

    }

    fun deleteNote(noteEntity: NoteEntity) =
        viewModelScope.launch { noteDB.noteDao.deleteNote(noteEntity = noteEntity) }

    fun checkedNote(noteEntity: NoteEntity) =
        viewModelScope.launch { noteDB.noteDao.insertNote(noteEntity = noteEntity) }

    fun snackBarItem(noteCheckItem:NoteEntity) = viewModelScope.launch {
        noteDB.noteDao.insertNote(noteEntity = noteCheckItem)
    }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val noteDatabase = (checkNotNull(extras[APPLICATION_KEY]) as App).noteDatabase
                return NoteViewModel(noteDatabase) as T
            }
        }
    }
}