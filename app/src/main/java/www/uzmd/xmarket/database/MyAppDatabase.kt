package www.uzmd.xmarket.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1, exportSchema = true)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun getService(): ServiceDao
    companion object {
        fun getDb(context: Context): MyAppDatabase {
            return Room.databaseBuilder(context, MyAppDatabase::class.java, "my.db").allowMainThreadQueries().build()
        }
    }
}