package devos.wouter.moviereleases.network

import devos.wouter.moviereleases.model.NowPlayingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/movie/now_playing")
    fun nowPlaying(@Query("language") language: String,
                   @Query("page") page: Int,
                   @Query("region") region: String): Call<NowPlayingResponse>
}