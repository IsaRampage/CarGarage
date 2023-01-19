package com.example.cargarage1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cargarage1.MainViewModel
import com.example.cargarage1.adapter.CarMarketAdapter
import de.syntaxinstitut.carGarage1.databinding.FragmentCarmarketBinding


/**
 * Fragment 2
 */
class CarMarketFragment : Fragment() {

    /* -------------------- Klassen Variablen -------------------- */

    private lateinit var binding: FragmentCarmarketBinding
    private val viewModel: MainViewModel by activityViewModels()

    /* -------------------- Lifecycle -------------------- */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarmarketBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val carMarketAdapter = CarMarketAdapter()
        binding.carMarketRecycler.adapter = carMarketAdapter

        viewModel.loadCars()

        viewModel.cars.observe(viewLifecycleOwner){
            carMarketAdapter.submitList(it)
        }

        binding.carmarketGarageNavButton.setOnClickListener {
            findNavController().navigate(
                CarMarketFragmentDirections.actionCarMarketFragmentToGarageFragment()
            )
        }

        binding.carmarketRaceNavButton.setOnClickListener {
            findNavController().navigate(
                CarMarketFragmentDirections.actionCarMarketFragmentToRaceFragment()
            )
        }
    }

}
