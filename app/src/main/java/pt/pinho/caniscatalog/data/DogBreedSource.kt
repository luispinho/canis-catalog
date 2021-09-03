package pt.pinho.caniscatalog.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import pt.pinho.caniscatalog.data.model.DogBreed
import pt.pinho.caniscatalog.repository.DogBreedRepository

class DogBreedSource(
    private val dogBreedRepository: DogBreedRepository
) : PagingSource<Int, DogBreed>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DogBreed> {
        return try {
            val nextPage = params.key ?: 0
            val dogBreedsResponse = dogBreedRepository.getDogBreeds(nextPage)

            LoadResult.Page(
                data = dogBreedsResponse!!,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DogBreed>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPageIndex = state.pages.indexOf(state.closestPageToPosition(anchorPosition))
            state.pages.getOrNull(anchorPageIndex + 1)?.prevKey ?: state.pages.getOrNull(anchorPageIndex - 1)?.nextKey
        }
    }
}