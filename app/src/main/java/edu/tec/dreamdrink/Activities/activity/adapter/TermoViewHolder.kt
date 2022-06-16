package edu.tec.dreamdrink.Activities.activity.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo
import edu.tec.dreamdrink.databinding.FragmentCarritoBinding

class TermoViewHolder (view: View): RecyclerView.ViewHolder(view){
    private val binding = FragmentCarritoBinding.bind(view)
    fun bind(termo: DataTermo){
        binding.tamanoTV.text = termo.tamano
        binding.precioTV.text = "${ termo.precio }"
    }
}