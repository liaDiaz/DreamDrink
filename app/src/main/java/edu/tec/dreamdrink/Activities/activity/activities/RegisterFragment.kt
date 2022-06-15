package edu.tec.dreamdrink.Activities.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import edu.tec.dreamdrink.Activities.activity.utils.FirebaseUtilis.firebaseAuth
import edu.tec.dreamdrink.R
import edu.tec.dreamdrink.databinding.FragmentRegisterBinding


class registerFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonConCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_indexFragment)
            Log.v("boton cuenta", "entro")
        }

        binding.loginButton.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()
            val passwordSecond = binding.editTextTextPassword2.text.toString().trim()
            if (password == passwordSecond) {
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { respuesta->
                    if(respuesta.isSuccessful){
                        findNavController().navigate(R.id.action_registerFragment_to_indexFragment)
                    }else{
                        Toast.makeText(activity, "Error del registro", Toast.LENGTH_LONG).show()

                    }
                }

            }else{
                Toast.makeText(activity, "passwords are not the same", Toast.LENGTH_LONG).show()
            }

        }


    }

}