package vi1ain.my.noteroomdialogtimecheck.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vi1ain.my.noteroomdialogtimecheck.App

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDB:RoomDatabase() {
   abstract val noteDao:NoteDao

   companion object{
       fun createDB(app: App):NoteDB =
           Room.databaseBuilder(app,NoteDB::class.java,"note_database.db").build()
   }
}