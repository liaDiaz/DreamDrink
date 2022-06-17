package edu.tec.dreamdrink.Activities.activity.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo
import edu.tec.dreamdrink.Activities.activity.mvvc.MainActivityVModel
import edu.tec.dreamdrink.databinding.FragmentCarritoBinding
import edu.tec.dreamdrink.databinding.RenglonCarritoTermoBinding

class TermoViewHolder (view: View): RecyclerView.ViewHolder(view){
    private val binding = RenglonCarritoTermoBinding.bind(view)

    fun bind(termo: DataTermo){

        binding.textView3.text = termo.tamano
       binding.textView6.text = termo.precio.toString()
    }
}