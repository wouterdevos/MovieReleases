package devos.wouter.moviereleases.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie ORDER BY release_date DESC")
    fun getMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovie() : LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(vararg movie: Movie)

    @Update
    fun updateMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)
}