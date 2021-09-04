package pt.pinho.caniscatalog.data.local

import androidx.paging.PagingSource
import androidx.room.*
import pt.pinho.caniscatalog.data.model.DogBreed

@Dao
interface DogBreedDao {
    @Query("SELECT * FROM dog_breed")
    suspend fun getAllBreeds(): List<DogBreed>

    @Query("SELECT * FROM dog_breed WHERE id = :breedId")
    suspend fun getById(breedId: Long): DogBreed?

    @Query("SELECT * FROM dog_breed WHERE id IN (:breedIds)")
    fun loadAllByIds(breedIds: LongArray): List<DogBreed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dogBreeds: List<DogBreed>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSingleBreed(dobBreed: DogBreed)

    @Delete
    fun delete(dogBreed: DogBreed)

    @Query("DELETE FROM dog_breed WHERE id = :query")
    suspend fun deleteByQuery(query: String)
}