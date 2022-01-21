package mehdiparsaei.simonsvoss.assignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import mehdiparsaei.simonsvoss.assignment.data.local.dao.BuildingDao
import mehdiparsaei.simonsvoss.assignment.data.local.dao.LockDao
import mehdiparsaei.simonsvoss.assignment.domain.model.Building
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock

@Database(entities = [Lock::class, Building::class], version = 1)
abstract class AppDB : RoomDatabase() {

    companion object {
        const val DB_NAME = "app_db"
    }

    abstract fun lockDao(): LockDao
    abstract fun buildingDao(): BuildingDao
}