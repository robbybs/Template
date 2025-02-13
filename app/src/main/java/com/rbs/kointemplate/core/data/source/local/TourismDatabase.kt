package com.rbs.kointemplate.core.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rbs.kointemplate.core.data.source.local.model.TourismEntity

@Database(entities = [TourismEntity::class], version = 1, exportSchema = false)
abstract class TourismDatabase: RoomDatabase() {
    abstract fun tourismDao(): TourismDao
}