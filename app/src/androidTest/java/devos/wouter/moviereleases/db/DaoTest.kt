package devos.wouter.moviereleases.db

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import org.junit.After
import org.junit.Before

abstract class DaoTest {

    lateinit var mAppDatabase: AppDatabase

    @Before
    fun initDatabase() {
        mAppDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase::class.java).build()
    }

    @After
    fun closeDatabase() {
        mAppDatabase.close()
    }
}