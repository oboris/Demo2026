package ua.edu.cdu.boris.demo2026.db

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import androidx.sqlite.driver.AndroidSQLiteDriver
import ua.edu.cdu.boris.demo2026.dao.AppDao
import ua.edu.cdu.boris.demo2026.entity.AuthorEntity
import ua.edu.cdu.boris.demo2026.entity.BookEntity

@Database(entities = [AuthorEntity::class, BookEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {
        // Volatile annotation ensures that the INSTANCE variable is always up-to-date
        // and visible to all threads.
        @Volatile
        private var INSTANCE: AppDataBase? = null

        // This method provides a singleton instance of the database.
        fun getDatabase(context: Context): AppDataBase {
            // If INSTANCE is not null, return it; otherwise, create a new database instance.
            return INSTANCE ?: synchronized(this) { // Ensures only one thread creates the database
                val instance = Room.databaseBuilder<AppDataBase>(
                    context.applicationContext,
                    "app_database.db3" // The name of your database file
                )
                    // .addMigrations(MIGRATION_1_2) // For production, implement proper migrations
                    .setDriver(AndroidSQLiteDriver())
                    .build()
                INSTANCE = instance
                // Return instance
                instance
            }
        }
    }
}