package edu.tec.dreamdrink.Activities.activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentCarruselFragamentBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselOnScrollListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResult
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo


class carruselFragament : Fragment() {
    lateinit var binding: FragmentCarruselFragamentBinding
    private val list= mutableListOf<CarouselItem>()
    lateinit var tapa: String
    lateinit var cilindro: String
    lateinit var tamano: String

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


        // Scroll listener caroussel 1
        carousel.onScrollListener = object : CarouselOnScrollListener {
            override fun onScrollStateChanged(
                recyclerView: RecyclerView,
                newState: Int,
                position: Int,
                carouselItem: CarouselItem?
            ) {
                Log.v(position.toString(),"posision")
                Log.v(carouselItem.toString(),"item carrusel")
                tapa = carouselItem?.imageDrawable.toString()

            }
        }

        // Scroll listener caroussel 2
        carousel1.onScrollListener = object : CarouselOnScrollListener {
            override fun onScrollStateChanged(
                recyclerView: RecyclerView,
                newState: Int,
                position: Int,
                carouselItem: CarouselItem?
            ) {
                Log.v(position.toString(),"posision")
                Log.v(carouselItem.toString(),"item carrusel")
                cilindro = carouselItem?.imageDrawable.toString()
            }
        }

            fun tamanoSelecionado(): String{
                binding.botonTamanoSmall.setOnClickListener {
                    tamano = "pequeño"

                }
                binding.botonTamanoMedium.setOnClickListener {
                    tamano = "mediano"
                }
                binding.botonTamanoLarge.setOnClickListener {
                    tamano = "largo"
                }
                return tamano
            }

        binding.botonConfirmar.setOnClickListener {
            findNavController().navigate(R.id.action_carruselFragament_to_carritoFragment)
            val termo = DataTermo("",tapa,cilindro,tamanoSelecionado())



        }




    }


}