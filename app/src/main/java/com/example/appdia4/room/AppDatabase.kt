//package com.example.appdia4.room
//
//import android.content.Context
//
//@Database(entities = [User::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//
//    abstract fun userDao(): UserDao
//
//    companion object {
//
//        // For Singleton instantiation
//        @Volatile private var instance: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//
//        private fun buildDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(context, AppDatabase::class.java, "user-db")
//                .allowMainThreadQueries()
//                .build()
//        }
//    }
//}