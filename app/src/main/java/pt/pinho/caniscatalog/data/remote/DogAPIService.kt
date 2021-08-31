package pt.pinho.caniscatalog.data.remote

import pt.pinho.caniscatalog.data.model.DogBreed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DogAPIService {

    @GET(DogAPIConstants.BREEDS_URL)
    suspend fun getDogBreeds() : Response<List<DogBreed>>

    @GET(DogAPIConstants.BREEDS_ID_URL)
    suspend fun getDogBreedById(@Path("breed_id") id: Long) : Response<DogBreed>

    @GET(DogAPIConstants.BREEDS_SEARCH_URL)
    suspend fun getDogBreedsByBreed(@Path("search_query") searchQuery: String) : Response<List<DogBreed>>
}