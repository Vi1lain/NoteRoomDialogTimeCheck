package vi1ain.my.noteroomdialogtimecheck

import android.app.Application
import vi1ain.my.noteroomdialogtimecheck.data.NoteDB

class App:Application() {
    val noteDatabase by lazy {
        NoteDB.createDB(this)
    }
}