package pt.pinho.caniscatalog.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppDatabaseProvider {
    @Provides
    fun provideDogBreedDao(appDatabase: AppDatabase): DogBreedDao {
        return appDatabase.dogBreedDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "dog-breed-db"
        ).build()
    }
}