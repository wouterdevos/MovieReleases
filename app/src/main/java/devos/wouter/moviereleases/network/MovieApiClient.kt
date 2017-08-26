package devos.wouter.moviereleases.network

import devos.wouter.moviereleases.model.NowPlayingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieApiClient {

    private val LANGUAGE = "en-US"

    fun nowPlaying(page: Int, region: String) {
        val movieApiService = ServiceGenerator.createService(MovieApiService::class.java)
        val call = movieApiService.nowPlaying(LANGUAGE, page, region)
        call.enqueue(object : Callback<NowPlayingResponse?> {
            override fun onResponse(call: Call<NowPlayingResponse?>?, response: Response<NowPlayingResponse?>?) {

            }

            override fun onFailure(call: Call<NowPlayingResponse?>?, t: Throwable?) {

            }
        })
    }
}