
    package edu.tec.dreamdrink.Activities

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.navigation.fragment.findNavController
    import edu.tec.dreamdrink.R
    import edu.tec.dreamdrink.databinding.FragmentIncioSesionBinding


    class incioSesionFragment : Fragment() {

        lateinit var binding: FragmentIncioSesionBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding = FragmentIncioSesionBinding.inflate(layoutInflater)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.button3.setOnClickListener {
                findNavController().navigate(R.id.action_incioSesionFragment_to_elegirVasoFragment)
            }
        }

    }