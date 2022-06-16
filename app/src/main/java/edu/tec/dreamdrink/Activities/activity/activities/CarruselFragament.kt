package edu.tec.dreamdrink.Activities.activity

import android.content.Intent
import android.graphics.Color
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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResult
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo
import edu.tec.dreamdrink.Activities.activity.entities.DataTermoFb
import edu.tec.dreamdrink.Activities.activity.utils.FirebaseUtilis.firebaseAuth


class carruselFragament : Fragment() {
    lateinit var binding: FragmentCarruselFragamentBinding
    private val list= mutableListOf<CarouselItem>()
    lateinit var tapa: String
    lateinit var cilindro: String
    lateinit var  resultadoTamano: String


    private val databaseReference = Firebase.database.getReference("termos")

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
        fabAgregaDatos()
        resultadoTamano= tamanoSelecionado()

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





    }
    fun tamanoSelecionado(): String{
        var tamano = ""
        binding.botonTamanoSmall.setOnClickListener {
            binding.botonTamanoSmall.setBackgroundColor(Color.BLUE)
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

    fun fabAgregaDatos(){

        binding.botonConfirmar.setOnClickListener {

            activity?.let {

                //esto es para el gasto se guarde para el usuario
                val userReference = databaseReference.child(firebaseAuth.currentUser!!.uid.toString())

                val id = userReference.push().key!!
                val dataTermoFb = DataTermoFb(id,tapa, cilindro, resultadoTamano)
                userReference.child(id).setValue(dataTermoFb)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "Agregado", Toast.LENGTH_LONG).show()
                    }.addOnFailureListener {
                        Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show()
                    }

            }
        }

    }





}