package devos.wouter.moviereleases.network

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private val BASE_URL = "https://api.themoviedb.org/3"
    private val API_KEY = "c1096c08ffc43207e7683927303fabe0"

    private var mOkHtppClient: OkHttpClient
    private var mRetrofit: Retrofit

    init {
        var okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor({ chain ->
            val originalRequest = chain!!.request()
            val originalHttpUrl = originalRequest.url()

            val httpUrl = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()

            val request = Request.Builder()
                    .url(httpUrl)
                    .build()

            chain.proceed(request)
        })
        okHttpClientBuilder.addInterceptor(HttpLoggingInterceptor())

        mOkHtppClient = okHttpClientBuilder.build()

        mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHtppClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return mRetrofit.create(serviceClass)
    }
}