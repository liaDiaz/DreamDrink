package edu.tec.dreamdrink.Activities.activity.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.tec.dreamdrink.Activities.activity.dao.DataTermoDao
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo


@Database(entities = [DataTermo::class], version = 1)
abstract class TermoDB:RoomDatabase() {

    abstract fun dataTermoDao(): DataTermoDao

}