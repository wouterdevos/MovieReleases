package devos.wouter.moviereleases.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(@PrimaryKey var id: Long,
                 @ColumnInfo(name = "vote_average") var voteAverage: Float,
                 @ColumnInfo(name = "title") var title: String,
                 @ColumnInfo(name = "overview") var overview: String,
                 @ColumnInfo(name = "release_date") var releaseDate: String,
                 @ColumnInfo(name = "poster_path") var posterPath: String,
                 @ColumnInfo(name = "backdrop_path") var backdropPath: String)
