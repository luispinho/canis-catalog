package pt.pinho.caniscatalog.repository

import android.util.Log
import dagger.hilt.android.scopes.ViewModelScoped
import pt.pinho.caniscatalog.data.local.DogBreedDao
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.data.remote.DogAPIService
import javax.inject.Inject

@ViewModelScoped
class DogBreedRepository @Inject constructor(private val dogAPIService: DogAPIService, private val dogBreedDao: DogBreedDao) {

    suspend fun getDogBreeds(pageNumber: Int): List<DogBreed>? {
        val response = dogAPIService.getDogBreeds(10, pageNumber)
        if (response.isSuccessful)
        {
            return response.body()
        }
        else
        {
            Log.v("Error", response.errorBody().toString())
            return null;
        }
    }

    suspend fun getDogBreedById(breedId: Long) = dogAPIService.getDogBreedById(breedId)

    suspend fun getDogBreedByBreedSearch(searchQuery: String) = dogAPIService.getDogBreedsByBreed(searchQuery)
}