package edu.tec.dreamdrink.Activities.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo
import edu.tec.dreamdrink.R
import java.util.*

class TermoAdapter(private var termos: List<DataTermo>) : RecyclerView.Adapter<TermoViewHolder>() {

    fun getTermos(position: Int) : DataTermo{
        return termos[position]
    }
    fun setTermos(termos: List<DataTermo>){
        this.termos = termos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TermoViewHolder(layoutInflater.inflate(R.layout.renglon_carrito_termo, parent, false))
    }

    override fun getItemCount(): Int = termos.size


    override fun onBindViewHolder(holder: TermoViewHolder, position: Int) {
        val item = termos[position]
        holder.bind(item)
    }
}