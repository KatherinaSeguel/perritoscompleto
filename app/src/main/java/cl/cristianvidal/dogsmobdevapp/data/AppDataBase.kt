package cl.cristianvidal.dogsmobdevapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.cristianvidal.dogsmobdevapp.breedImagesList.data.BreedImages
import cl.cristianvidal.dogsmobdevapp.breedList.data.Breed
import cl.cristianvidal.dogsmobdevapp.breedList.data.BreedDao

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
@Database(entities = [Breed::class, BreedImages::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun BreedDao(): BreedDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }


        private fun buildDatabase(context: Context): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, "DogsMobDev-db")
                .addCallback(object : RoomDatabase.Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
//                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
//                        WorkManager.getInstance(context).enqueue(request)}
                }).build()
        }
    }


}