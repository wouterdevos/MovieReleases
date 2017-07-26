package devos.wouter.moviereleases.db

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import devos.wouter.moviereleases.util.LiveDataTestUtil
import devos.wouter.moviereleases.util.TestUtil
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.`is`


@RunWith(AndroidJUnit4::class)
@SmallTest
class MovieDaoTest : DaoTest {

    constructor()

    @Test
    fun insertAndRead() {
        var movie = TestUtil.createMovie()

        mAppDatabase.movieDao().insertMovie(movie)
        var loaded = LiveDataTestUtil.getValue(mAppDatabase.movieDao().getMovie())
        assertThat(loaded, notNullValue())
        assertThat(loaded.id, `is`(movie.id))
        assertThat(loaded.voteAverage, `is`(movie.voteAverage))
        assertThat(loaded.title, `is`(movie.title))
        assertThat(loaded.overview, `is`(movie.overview))
        assertThat(loaded.releaseDate, `is`(movie.releaseDate))
        assertThat(loaded.posterPath, `is`(movie.posterPath))
        assertThat(loaded.backdropPath, `is`(movie.backdropPath))
    }
}