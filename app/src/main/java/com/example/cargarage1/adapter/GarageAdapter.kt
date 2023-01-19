package com.example.cargarage1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cargarage1.data.Model.Car
import de.syntaxinstitut.carGarage1.R

class GarageAdapter() : RecyclerView.Adapter<GarageAdapter.ItemViewHolder>() {

    private var dataset = listOf<Car>()

    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val carImage: ImageView = view.findViewById(R.id.garage_detail_image)
        val carManufacturer: TextView = view.findViewById(R.id.garage_detail_manufacture_text_text)
        val carManufacturerText: TextView = view.findViewById(R.id.garage_detail_manufacture_text)
        val carModel: TextView = view.findViewById(R.id.garage_detail_model_text_text)
        val carModelText: TextView = view.findViewById(R.id.garage_detail_model_text)
        val carPerformance: TextView = view.findViewById(R.id.garage_detail_performance_text_text)
        val carPerformanceText: TextView = view.findViewById(R.id.garage_detail_performance_text)
        val carConsumption: TextView = view.findViewById(R.id.garage_detail_consumption_text_text)
        val carConsumptionText: TextView = view.findViewById(R.id.garage_detail_consumption_text)
        val raceBonus: TextView = view.findViewById(R.id.garage_detail_racebonus_text_text)
        val raceBonusText: TextView= view.findViewById(R.id.garage_detail_racebonus_text)
        val deleteButton: Button = view.findViewById(R.id.garage_detail_delete_button)
        val garageCardView: CardView = view.findViewById(R.id.garage_detail_cardView)
    }

    fun submitList(newList: List<Car>) {
        dataset = newList
        notifyDataSetChanged()
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.garage_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val cars = dataset[position]

        holder.carImage.load(cars.carImage)
        holder.carManufacturer.text = cars.manufacturer
        holder.carModel.text = cars.model
        holder.carPerformance.text = cars.performance
        holder.carConsumption.text = cars.consumption
        holder.raceBonus.text = cars.raceBonus
        holder.garageCardView
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}