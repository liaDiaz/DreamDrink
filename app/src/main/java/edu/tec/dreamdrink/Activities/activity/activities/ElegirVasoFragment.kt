package edu.tec.dreamdrink.Activities.activity

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentElegirVasoBinding

class elegirVasoFragment : Fragment() {


    lateinit var binding: FragmentElegirVasoBinding
    lateinit var tipoVaso:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentElegirVasoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonCafe.setOnClickListener {
            tipoVaso="Vaso"
            // Use the Kotlin extension in the fragment-ktx artifact
            setFragmentResult("requestKey", bundleOf("bundleKey" to tipoVaso))

            findNavController().navigate(R.id.action_elegirVasoFragment_to_carruselFragament3)
        }
        binding.botonCilindro.setOnClickListener {
            tipoVaso="Cilindro"
            findNavController().navigate(R.id.action_elegirVasoFragment_to_carruselFragament3)
        }
        binding.botonTrago.setOnClickListener {
            tipoVaso="Cafe"
            findNavController().navigate(R.id.action_elegirVasoFragment_to_carruselFragament3)
        }
        binding.botonVaso.setOnClickListener {
            tipoVaso="Trago"
            findNavController().navigate(R.id.action_elegirVasoFragment_to_carruselFragament3)
        }
    }

}