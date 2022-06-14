package edu.tec.dreamdrink.Activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentPagoBinding


class pagoFragment : Fragment() {
    lateinit var binding: FragmentPagoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPagoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonPago.setOnClickListener {
            findNavController().navigate(R.id.action_pagoFragment_to_elegirVasoFragment)
        }
    }

}