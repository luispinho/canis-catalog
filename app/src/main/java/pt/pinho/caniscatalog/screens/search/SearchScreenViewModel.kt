package pt.pinho.caniscatalog.screens.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.repository.DogBreedRepository
import pt.pinho.caniscatalog.screens.UiState
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val dogBreedRepo: DogBreedRepository,
): ViewModel() {
    private val _uiState = MutableLiveData<UiState>(UiState.Initial)
    val uiState: LiveData<UiState>
        get() = _uiState

    private val _uiBreedList = MutableLiveData<List<DogBreed>>()
    val uiBreedList: LiveData<List<DogBreed>>
        get() = _uiBreedList

    fun getBreedsBySearch(searchQuery: String) {
        viewModelScope.launch {
            _uiState.postValue(UiState.Loading)

            val response = dogBreedRepo.getDogBreedByBreedSearch(searchQuery)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    _uiBreedList.postValue(response.body())

                    if (response.body()?.isNotEmpty() == true) {
                        _uiState.postValue(UiState.Loaded)
                    } else {
                        _uiState.postValue(UiState.NoData)
                    }

                } else {
                    _uiState.postValue(UiState.LoadingError)
                }
            }
        }
    }
}