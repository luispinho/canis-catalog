package pt.pinho.caniscatalog.repository

import android.util.Log
import dagger.hilt.android.scopes.ViewModelScoped
import pt.pinho.caniscatalog.data.local.DogBreedDao
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.data.remote.DogAPIService
import javax.inject.Inject

@ViewModelScoped
class DogBreedRepository @Inject constructor(private val dogAPIService: DogAPIService, private val dogBreedDao: DogBreedDao) {

    suspend fun getDogBreeds(pageNumber: Int): List<DogBreed> {
        try {
            val response = dogAPIService.getDogBreeds(10, pageNumber)

            if (response.isSuccessful) {
                response.body()?.let {
                    dogBreedDao.insertAll(it)
                    return it
                }
            }
        }
        catch (error: Error)
        {
            error.printStackTrace()
        }

        return emptyList()
    }

    suspend fun getDogBreedById(breedId: Long): DogBreed? {
        val localBreed = dogBreedDao.getById(breedId)

        if (localBreed == null) {
            val response = dogAPIService.getDogBreedById(breedId)

            if (response.isSuccessful) {
                response.body()?.let {
                    dogBreedDao.insertSingleBreed(it)
                }
            }
        }

        return dogBreedDao.getById(breedId)
    }

    suspend fun getDogBreedByBreedSearch(searchQuery: String): List<DogBreed>? {
        try {
            val response = dogAPIService.getDogBreedsByBreed(searchQuery)

            if (response.isSuccessful)
            {
                response.body()?.let {
                    return it
                }
            }
        }
        catch (error: Error) {
            error.printStackTrace()
            return null
        }

        return emptyList()
    }
}