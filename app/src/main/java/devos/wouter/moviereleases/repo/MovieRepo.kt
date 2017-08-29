package devos.wouter.moviereleases.repo

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import devos.wouter.moviereleases.db.MovieDao
import devos.wouter.moviereleases.model.Movie

class MovieRepo(val movieDao: MovieDao) {

//    fun getMovies(androidViewModel: AndroidViewModel): LiveData<List<Movie>> {
//        movieDao.getMovies().observe(androidViewModel., movies -> {
//
//        })
//    }
}