package edu.tec.dreamdrink.Activities.activity.mvvc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.tec.dreamdrink.Activities.activity.dao.DataTermoDao
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainActivityVModel (private val dataTermoDao: DataTermoDao) : ViewModel(){
    var liveDataD: MutableLiveData<Double>
    init {

        liveDataD= MutableLiveData()
    }

    fun getLiveData1Observer(): MutableLiveData<Double>
    {
        return liveDataD
    }

    fun sumaGastos(dataTermo: DataTermoDao){
        CoroutineScope(Dispatchers.IO).launch{
            liveDataD.postValue((dataTermo.sumarPrecio())).toString()
        }

    }
}