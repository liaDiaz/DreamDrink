package edu.tec.dreamdrink.Activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentCarruselFragamentBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class carruselFragament : Fragment() {
    lateinit var binding: FragmentCarruselFragamentBinding
    private val list= mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCarruselFragamentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val carousel: ImageCarousel = view.findViewById(R.id.carousel)
        list.add(CarouselItem(R.drawable.cilindro))
        list.add(CarouselItem(R.drawable.vasochupon))
        carousel.addData(list)
        carousel.registerLifecycle(viewLifecycleOwner)

        val carousel1: ImageCarousel = view.findViewById(R.id.carousel1)
        list.add(CarouselItem(R.drawable.cilindro))
        list.add(CarouselItem(R.drawable.vasochupon))
        carousel1.addData(list)
        carousel1.registerLifecycle(viewLifecycleOwner)



        super.onViewCreated(view, savedInstanceState)
        binding.botonCarrusel.setOnClickListener {
            findNavController().navigate(R.id.action_carruselFragament_to_selecionartamanoFragment)


        }
    }
}