package pt.pinho.caniscatalog.repository

import dagger.hilt.android.scopes.ViewModelScoped
import pt.pinho.caniscatalog.data.remote.DogAPIService
import javax.inject.Inject

@ViewModelScoped
class DogBreedRepository @Inject constructor(private val dogAPIService: DogAPIService) {

    suspend fun getDogBreeds() = dogAPIService.getDogBreeds()

    suspend fun getDogBreedById(breedId: Long) = dogAPIService.getDogBreedById(breedId)

}