package com.example.cargarage1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cargarage1.MainViewModel
import de.syntaxinstitut.carGarage1.databinding.FragmentRaceBinding

class RaceFragment : Fragment() {

    private lateinit var binding: FragmentRaceBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRaceBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.raceGarageNavButton.setOnClickListener {
            findNavController().navigate(
                RaceFragmentDirections.actionRaceFragmentToGarageFragment()
            )
        }

        binding.raceCarMarketNavButton.setOnClickListener {
            findNavController().navigate(
                RaceFragmentDirections.actionRaceFragmentToCarMarketFragment()
            )
        }
    }
}