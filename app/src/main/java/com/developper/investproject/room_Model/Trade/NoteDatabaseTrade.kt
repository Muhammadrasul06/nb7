
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.developper.investproject.room_Model.Trade.NoteDao_trade
import com.developper.investproject.room_Model.Trade.Note_trade

@Database(entities = [Note_trade::class], version = 1)

abstract class NoteDatabaseTrade : RoomDatabase() {
    abstract fun noteDoa_trade(): NoteDao_trade

    object DatabaseBuilderTrade {
        private var INSTANCE: NoteDatabaseTrade? = null
        fun getDatabaseTrade(context: Context): NoteDatabaseTrade {
            if (INSTANCE == null){
                synchronized(NoteDatabaseTrade::class.java){
                    INSTANCE= buildDatabseTrade(context)
                }
            }
            return INSTANCE!!
        }
        private fun buildDatabseTrade(context: Context)=
            Room.databaseBuilder(context.applicationContext,NoteDatabaseTrade::class.java,"note_baza_trade")
                .fallbackToDestructiveMigration()
                .build()
    }
}
