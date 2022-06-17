package edu.tec.dreamdrink.Activities.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentCarruselFragamentBinding
import edu.tec.dreamdrink.databinding.FragmentElegirVasoBinding


class elegirVasoFragment : Fragment() {

    lateinit var binding: FragmentElegirVasoBinding
    lateinit var  tipoVaso: String
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
        tipoVaso = ""
        super.onViewCreated(view, savedInstanceState)
        binding.botonCafe.setOnClickListener {
            tipoVaso = "Vaso"

            val action =elegirVasoFragmentDirections.actionElegirVasoFragmentToCarruselFragament3(tipoVaso)
            findNavController().navigate(action)



        }
        binding.botonCilindro.setOnClickListener {
            tipoVaso = "Cilindro"

        }
        binding.botonTrago.setOnClickListener {
            tipoVaso = "Cafe"

        }
        binding.botonVaso.setOnClickListener {
            tipoVaso = "Trago"

        }
    }

}