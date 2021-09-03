package pt.pinho.caniscatalog.screens.homescreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.pinho.caniscatalog.data.DogBreedSource
import pt.pinho.caniscatalog.data.local.DogBreedDao
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.repository.DogBreedRepository
import pt.pinho.caniscatalog.screens.UiState
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val dogBreedRepo: DogBreedRepository,
): ViewModel() {
    val breeds = Pager(PagingConfig(pageSize = 20)) {
        DogBreedSource(dogBreedRepo)
    }.flow.cachedIn(viewModelScope)
}