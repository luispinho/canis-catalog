package pt.pinho.caniscatalog.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader("x-api-key", DogAPIConstants.API_TOKEN)

        return chain.proceed(requestBuilder.build())
    }
}