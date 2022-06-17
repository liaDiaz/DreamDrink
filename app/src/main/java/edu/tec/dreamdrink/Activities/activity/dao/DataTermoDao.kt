package edu.tec.dreamdrink.Activities.activity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo
import kotlinx.coroutines.flow.Flow


@Dao
interface DataTermoDao{
    @Query("SELECT * from DataTermo")
    fun getAllTermos(): Flow<List<DataTermo>>

    //"SELECT SUM(monto) from Gasto"
    @Query("select sum(precio) from DataTermo")
    suspend fun sumarPrecio():Double
    @Insert
    suspend fun insertTermo(dataTermo: DataTermo)
}
