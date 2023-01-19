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
import de.syntaxinstitut.carGarage1.databinding.FragmentDetailCarmarketBinding

class CarMarketDetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailCarmarketBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCarmarketBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.carmarketDetailBackButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}
