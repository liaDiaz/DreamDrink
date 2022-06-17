package edu.tec.dreamdrink.Activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tsuryo.swipeablerv.SwipeLeftRightCallback
import edu.tec.dreamdrink.Activities.activity.adapter.TermoAdapter
import edu.tec.dreamdrink.Activities.activity.dao.DataTermoDao
import edu.tec.dreamdrink.Activities.activity.entities.DataTermo
import edu.tec.dreamdrink.Activities.activity.entities.DataTermoFb
import edu.tec.dreamdrink.Activities.activity.mvvc.MainActivityVModel
import edu.tec.dreamdrink.Activities.activity.utils.FirebaseUtilis.firebaseAuth
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentCarritoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.properties.Delegates


class carritoFragment : Fragment() {
    lateinit var binding: FragmentCarritoBinding

    private lateinit var  termos: List<DataTermo>
    private lateinit var adapter: TermoAdapter
    private lateinit var viewModel: MainActivityVModel
    private val databaseReference = Firebase.database.getReference("termos")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCarritoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRecycler()
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_carritoFragment_to_pagoFragment)
        }

    }

    private fun initRecycler(){
        termos = mutableListOf<DataTermo>()
        adapter = TermoAdapter(termos)
        binding.termoLista.layoutManager = LinearLayoutManager(activity)
        binding.termoLista.adapter = adapter
        binding.termoLista.setListener(object :
            SwipeLeftRightCallback.Listener{
            override fun onSwipedLeft(position: Int) {
                removeTermo(position)
            }
            override fun onSwipedRight(position: Int) {
                binding.termoLista.adapter?.notifyDataSetChanged()
            }
        })
    }

    private fun removeTermo(position: Int){
        val termo = adapter.getTermos(position)
        val userReference = databaseReference.child(firebaseAuth.currentUser!!.uid.toString())
        userReference
            .child(termo.id.toString()).removeValue().addOnSuccessListener {
                Toast.makeText(activity,
                    "Borrado de la BD", Toast.LENGTH_LONG).show()
                adapter.notifyDataSetChanged()
            }.addOnFailureListener {
                Toast.makeText(activity,
                    "Falla PPPOOOOOOMMMM BD", Toast.LENGTH_LONG).show()
            }

    }
    private fun initViewModel(){
        val userReference = databaseReference.child(firebaseAuth.currentUser!!.uid.toString())
        userReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var lista = mutableListOf<DataTermo>()
                var total by Delegates.notNull<Double>()
                total = 0.0
                for (termoObject in snapshot.children){
                    val objeto = termoObject.getValue(DataTermoFb::class.java)
                    lista.add(DataTermo(objeto!!.id.toString(),objeto.tapa!!,objeto.cilindro!!,
                        objeto!!.tamano!!, objeto.precio!!, objeto.tipoBaso!!))
                    total= total+objeto.precio
                    println("este es mi total de lista: ${total}")

                }
                binding.precioTotal.text = total.toString()

                adapter.setTermos(lista)
                adapter.getTotal(total)
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }


}