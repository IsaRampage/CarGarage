package com.example.cargarage1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.cargarage1.MainViewModel
import com.example.cargarage1.adapter.GarageAdapter
import de.syntaxinstitut.carGarage1.databinding.FragmentGarageBinding

/**
 * Fragment 1
 */
class GarageFragment : Fragment() {

    /* -------------------- Klassen Variablen -------------------- */

    private lateinit var binding: FragmentGarageBinding
    private val viewModel: MainViewModel by activityViewModels()

    /* -------------------- Lifecycle -------------------- */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGarageBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val garageAdapter = GarageAdapter()
        binding.garageRecycler.adapter = garageAdapter

        viewModel.loadCars()

        binding.raceNavButton.setOnClickListener {
            findNavController().navigate(
                GarageFragmentDirections.actionGarageFragmentToRaceFragment()
            )
        }

        binding.carMarketNavButton.setOnClickListener {
            findNavController().navigate(
                GarageFragmentDirections.actionGarageFragmentToCarMarketFragment()
            )
        }
    }
}

