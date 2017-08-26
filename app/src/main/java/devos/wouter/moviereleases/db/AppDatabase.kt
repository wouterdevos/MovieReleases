package devos.wouter.moviereleases.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import devos.wouter.moviereleases.model.Movie

@Database(entities = arrayOf(Movie::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
}