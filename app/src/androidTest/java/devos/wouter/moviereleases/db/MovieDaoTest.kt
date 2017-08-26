package devos.wouter.moviereleases.db

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import devos.wouter.moviereleases.model.Movie
import devos.wouter.moviereleases.util.LiveDataTestUtil
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class MovieDaoTest : DaoTest {

    constructor()

    @Test
    fun insertAndReadMovie() {
        val movie = Movie(1, 5f, "title", "overview",
                "release_date", "poster_path", "backdrop_path")

        mAppDatabase.movieDao().insertMovie(movie)
        val readMovie = LiveDataTestUtil.getValue(mAppDatabase.movieDao().getMovie(movie.id))
        assertThat(readMovie, notNullValue())
        assertThat(readMovie, `is`(movie))
    }

    @Test
    fun insertAndReadMovies() {
        val movieA = Movie(1, 5f, "title_a", "overview_a",
                "release_date_a", "poster_path_a", "backdrop_path_a")
        val movieB = Movie(2, 5f, "title_b", "overview_b",
                "release_date_b", "poster_path_b", "backdrop_path_b")
        val movieC = Movie(3, 5f, "title_c", "overview_c",
                "release_date_c", "poster_path_c", "backdrop_path_c")
        val movies = arrayListOf(movieC, movieB, movieA)

        for (movie in movies) {
            mAppDatabase.movieDao().insertMovie(movie)
        }

        val readMovies = LiveDataTestUtil.getValue(mAppDatabase.movieDao().getMovies())

        assertThat(readMovies.size, `is`(movies.size))
        for (i in readMovies.indices) {
            assertThat(readMovies[i], `is`(movies[i]))
        }
    }

    @Test
    fun insertAndDeleteMovie() {
        val movie = Movie(1, 5f, "title", "overview",
                "release_date", "poster_path", "backdrop_path")

        mAppDatabase.movieDao().insertMovie(movie)
        var readMovie = LiveDataTestUtil.getValue(mAppDatabase.movieDao().getMovie(movie.id))
        assertThat(movie, `is`(readMovie))
        mAppDatabase.movieDao().deleteMovie(movie)
        readMovie = LiveDataTestUtil.getValue(mAppDatabase.movieDao().getMovie(movie.id))
        assertThat(readMovie, nullValue())
    }

    @Test
    fun insertAndUpdateMovie() {
        val movie = Movie(1, 5f, "title", "overview",
                "release_date", "poster_path", "backdrop_path")

        mAppDatabase.movieDao().insertMovie(movie)
        var readMovie = LiveDataTestUtil.getValue(mAppDatabase.movieDao().getMovie(movie.id))
        assertThat(movie, `is`(readMovie))
        readMovie.voteAverage = 8f
        mAppDatabase.movieDao().updateMovie(readMovie)
        readMovie = LiveDataTestUtil.getValue(mAppDatabase.movieDao().getMovie(movie.id))
        assertThat(movie, not(readMovie))
    }
}