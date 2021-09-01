package pt.pinho.caniscatalog.data.remote

import pt.pinho.caniscatalog.BuildConfig

object DogAPIConstants {
    const val BASE_URL = "https://api.thedogapi.com/v1/"
    const val API_TOKEN = BuildConfig.THE_DOG_API_KEY
    const val BREEDS_URL = "breeds/"
    const val BREEDS_ID_URL = "${BREEDS_URL}{breed_id}"
    const val BREEDS_SEARCH_URL = "${BREEDS_URL}search"
}