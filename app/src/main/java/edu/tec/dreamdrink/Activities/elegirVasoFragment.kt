package edu.tec.dreamdrink.Activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentElegirVasoBinding


class elegirVasoFragment : Fragment() {

    lateinit var binding: FragmentElegirVasoBinding
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
            findNavController().navigate(R.id.action_elegirVasoFragment_to_carruselFragament3)
        }
        binding.botonCilindro.setOnClickListener {
            findNavController().navigate(R.id.action_elegirVasoFragment_to_carruselFragament3)
        }
        binding.botonTrago.setOnClickListener {
            findNavController().navigate(R.id.action_elegirVasoFragment_to_carruselFragament3)
        }
        binding.botonVaso.setOnClickListener {
            findNavController().navigate(R.id.action_elegirVasoFragment_to_carruselFragament3)
        }
    }

}