package pt.pinho.caniscatalog.data.local

import androidx.room.*
import pt.pinho.caniscatalog.data.model.DogBreed

@Dao
interface DogBreedDao {
    @Query("SELECT * FROM dog_breed")
    fun getAll(): List<DogBreed>

    @Query("SELECT * FROM dog_breed WHERE id = :breedId")
    fun getById(breedId: Long): List<DogBreed>

    @Query("SELECT * FROM dog_breed WHERE id IN (:breedIds)")
    fun loadAllByIds(breedIds: LongArray): List<DogBreed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dogBreeds: List<DogBreed>)

    @Delete
    fun delete(dogBreed: DogBreed)

    @Query("DELETE FROM dog_breed WHERE id = :query")
    suspend fun deleteByQuery(query: String)
}