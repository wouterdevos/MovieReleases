package devos.wouter.moviereleases.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import devos.wouter.moviereleases.db.AppDatabase
import devos.wouter.moviereleases.model.Movie

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var mAppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "AppDatabase")
    var mMoviesLiveData: LiveData<List<Movie>>? = null
}