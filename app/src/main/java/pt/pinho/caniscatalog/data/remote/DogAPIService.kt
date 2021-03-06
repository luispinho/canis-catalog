package pt.pinho.caniscatalog.data.remote

import pt.pinho.caniscatalog.data.model.DogBreed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DogAPIService {

    @GET(DogAPIConstants.BREEDS_URL)
    suspend fun getDogBreeds(@Query("limit") limit: Int, @Query("page") page: Int) : Response<List<DogBreed>>

    @GET(DogAPIConstants.BREEDS_ID_URL)
    suspend fun getDogBreedById(@Path("breed_id") id: Long) : Response<DogBreed>

    @GET(DogAPIConstants.BREEDS_SEARCH_URL)
    suspend fun getDogBreedsByBreed(@Query("q") searchQuery: String) : Response<List<DogBreed>>
}