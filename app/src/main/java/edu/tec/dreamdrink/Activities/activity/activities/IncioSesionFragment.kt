
    package edu.tec.dreamdrink.Activities.activity

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.compose.material.MaterialTheme
    import androidx.compose.ui.platform.ViewCompositionStrategy
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.navigation.fragment.findNavController
    import edu.tec.dreamdrink.Activities.activity.activities.InicioSesionDescription
    import edu.tec.dreamdrink.R
    import edu.tec.dreamdrink.databinding.FragmentIncioSesionBinding

    class incioSesionFragment : Fragment() {
        private var _binding: FragmentIncioSesionBinding? = null
        // This property is only valid between onCreateView and onDestroyView.
        private val binding get() = _binding!!

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentIncioSesionBinding.inflate(inflater, container, false)
            val view = binding.root
            // Inflate the layout for this fragment
            binding.composeView.apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    MaterialTheme {
                        InicioSesionDescription()
                    }
            }
            return binding.root
        }
        }

       override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
//            binding.button3.setOnClickListener {
//                findNavController().navigate(R.id.action_incioSesionFragment_to_indexFragment)
//            }
           }
    }