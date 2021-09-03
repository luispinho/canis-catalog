package pt.pinho.caniscatalog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pt.pinho.caniscatalog.data.model.DogBreed

@Database(entities = [DogBreed::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dogBreedDao(): DogBreedDao
}