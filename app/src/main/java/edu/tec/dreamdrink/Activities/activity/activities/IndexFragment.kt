package edu.tec.dreamdrink.Activities.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseUser
import edu.tec.dreamdrink.Activities.activity.utils.FirebaseUtilis
import edu.tec.dreamdrink.Activities.activity.utils.FirebaseUtilis.firebaseAuth
import edu.tec.dreamdrink.Activities.activity.utils.FirebaseUtilis.firebaseUser
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentIndexBinding


class indexFragment : Fragment() {

    lateinit var binding: FragmentIndexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIndexBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            val email = binding.editTextTextEmailAddresslogin.text.toString().trim()
            val password = binding.editTextTextPasswordlogin.text.toString().trim()



            if (!(email.isNullOrEmpty() && password.isNullOrEmpty())) {
                firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener { respuesta->
                        if(respuesta.isSuccessful){
                            findNavController().navigate(R.id.action_indexFragment_to_elegirVasoFragment)
                        }else{
                            Toast.makeText(activity, "Error del login", Toast.LENGTH_LONG).show()

                        }
                    }

            }else{
                Toast.makeText(activity, "email or password incorrect", Toast.LENGTH_LONG).show()
            }
        }

        binding.registerLinkButton.setOnClickListener {
            findNavController().navigate(R.id.action_indexFragment_to_registerFragment)
        }
    }


    //metodo de ciclo de vida porque son los metodos que se ejecutan onStart()
    override fun onStart() {
        super.onStart()
        val usuario : FirebaseUser? = firebaseAuth.currentUser
        usuario?.let {
            findNavController().navigate(R.id.action_indexFragment_to_elegirVasoFragment)
        }


    }



}
