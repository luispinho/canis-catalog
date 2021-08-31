package pt.pinho.caniscatalog.data.remote

import pt.pinho.caniscatalog.BuildConfig

object DogAPIConstants {
    const val BASE_URL = "https://api.thedogapi.com/v1/"
    const val API_TOKEN = BuildConfig.THE_DOG_API_KEY
    const val BREEDS_URL = "breeds"
}