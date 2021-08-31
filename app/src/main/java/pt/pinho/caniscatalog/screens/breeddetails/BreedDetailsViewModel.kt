package pt.pinho.caniscatalog.screens.breeddetails

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.repository.DogBreedRepository
import pt.pinho.caniscatalog.screens.UiState
import javax.inject.Inject

@HiltViewModel
class BreedDetailsViewModel @Inject constructor(
    private val dogBreedRepo: DogBreedRepository,
): ViewModel() {
    private val _uiState = MutableLiveData<UiState>(UiState.NoData)
    val uiState: LiveData<UiState>
        get() = _uiState

    private val _uiBreed = MutableLiveData<DogBreed>(null)
    val uiBreed: LiveData<DogBreed>
        get() = _uiBreed

    fun getDogBreedById(breedId: Long)
    {
        viewModelScope.launch {
            _uiState.postValue(UiState.Loading)
            val response = dogBreedRepo.getDogBreedById(breedId);
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    if (response.body() != null)
                    {
                        response.body()?.let {
                            _uiBreed.postValue(it)
                            _uiState.postValue(UiState.Loaded)
                        }
                    }
                    else
                    {
                        _uiState.postValue(UiState.NoData)
                    }
                } else {
                    //onError("Error : ${response.message()} ")
                }
            }
        }
    }
}