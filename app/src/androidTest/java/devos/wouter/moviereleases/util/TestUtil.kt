package devos.wouter.moviereleases.util

import devos.wouter.moviereleases.db.Movie

object TestUtil {

    fun createMovie(): Movie {
        return Movie(315635, 7.4f, "Spider-Man: Homecoming", "Overview",
                "2017-07-14", "/ApYhuwBWzl29Oxe9JJsgL7qILbD.jpg", "/fn4n6uOYcB6Uh89nbNPoU2w80RV.jpg")
    }
}