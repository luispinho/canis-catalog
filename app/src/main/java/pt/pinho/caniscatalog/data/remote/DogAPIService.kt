package pt.pinho.caniscatalog.data.remote

import pt.pinho.caniscatalog.data.model.DogBreed
import retrofit2.Response
import retrofit2.http.GET

interface DogAPIService {

    @GET(DogAPIConstants.BREEDS_URL)
    suspend fun getDogBreeds() : Response<List<DogBreed>>
}