package com.example.cargarage1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cargarage1.MainViewModel
import de.syntaxinstitut.carGarage1.databinding.FragmentOneBinding

/**
 * Fragment 1
 */
class OneFragment : Fragment() {

    /* -------------------- Klassen Variablen -------------------- */

    private lateinit var binding: FragmentOneBinding
    private val viewModel: MainViewModel by activityViewModels()

    /* -------------------- Lifecycle -------------------- */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* -------------------- UI-Interaktionen -------------------- */

        //binding.btnFragmentOne.setOnClickListener {
       //     viewModel.navigateToFragmentTwo()
       // }

        /* -------------------- Observer -------------------- */

        // Navigation zum zweiten Fragment
        viewModel.navigateToFragmentTwo.observe(viewLifecycleOwner) {
            if (it) {
                //findNavController().navigate(
                   // OneFragmentDirections.actionOneFragmentToTwoFragment()
               // )

                viewModel.resetAllValues()
            }
        }
    }
}
