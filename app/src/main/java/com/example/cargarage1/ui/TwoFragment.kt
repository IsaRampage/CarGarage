package com.example.cargarage1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cargarage1.MainViewModel
import de.syntaxinstitut.carGarage1.databinding.FragmentTwoBinding

/**
 * Fragment 2
 */
class TwoFragment : Fragment() {

    /* -------------------- Klassen Variablen -------------------- */

    private lateinit var binding: FragmentTwoBinding
    private val viewModel: MainViewModel by activityViewModels()

    /* -------------------- Lifecycle -------------------- */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater)

        return binding.root
    }
}
