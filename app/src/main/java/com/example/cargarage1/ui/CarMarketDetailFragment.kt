package com.example.cargarage1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.cargarage1.MainViewModel
import com.example.cargarage1.adapter.CarMarketAdapter
import com.example.cargarage1.data.Model.Car
import de.syntaxinstitut.carGarage1.R
import de.syntaxinstitut.carGarage1.databinding.FragmentCarmarketBinding
import de.syntaxinstitut.carGarage1.databinding.FragmentDetailCarmarketBinding

class CarMarketDetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailCarmarketBinding
    private val viewModel: MainViewModel by activityViewModels()
    private var idCar: Int = 0
    private var manufacturer: String = ""
    private var model: String =""
    private var performance: String =""
    private var consumption: String = ""
    private var raceBonus: String = ""
    private var carImage: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            idCar = it.getInt("id")
          //  manufacturer = it.getString("manufacturer").toString()
            //model = it.getString("model").toString()
            //performance = it.getString("performance").toString()
            //consumption = it.getString("consumption").toString()
            //raceBonus = it.getString("racebonus").toString()
            carImage = it.getString("image").toString()
        }
    }

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

        var car = viewModel.cars.value?.find { it.id == idCar }!!

        binding.carmarktDetailManufactureTextText.text = car.manufacturer
        binding.carmarktDetailModelTextText.text = car.model
        binding.carmarktDetailPerformanceTextText.text = car.performance
        binding.carmarktDetailConsumptionTextText.text = car.consumption
        binding.carmarktDetailRacebonusTextText.text = car.raceBonus
        binding.carmarktDetailImage.load(carImage)
        binding.carmarktCarNameDetail.text = car.model

        binding.carmarketDetailBackButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.carmarketDetailSaveButton.setOnClickListener {
        viewModel.updateCar(car)
        }
    }
}
