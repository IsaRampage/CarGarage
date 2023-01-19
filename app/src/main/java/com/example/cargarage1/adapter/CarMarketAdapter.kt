package com.example.cargarage1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cargarage1.data.Model.Car
import com.example.cargarage1.ui.CarMarketFragment
import com.example.cargarage1.ui.CarMarketFragmentDirections
import de.syntaxinstitut.carGarage1.R

class CarMarketAdapter() : RecyclerView.Adapter<CarMarketAdapter.ItemViewHolder>() {

    private var dataset = listOf<Car>()

    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val carMarketImage: ImageView = view.findViewById(R.id.carmarkt_item_image)
        val manufacturerHeadline: TextView = view.findViewById(
            R.id.carmarkt_item_manufacturer_headlineText)
        val carMarketCard: CardView = view.findViewById(R.id.carmarkt_item_cardView)
        val modelHeadline: TextView = view.findViewById(R.id.carmarkt_item_model_headlineText)
    }

    fun submitList(newList: List<Car>) {
        dataset = newList
        notifyDataSetChanged()
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.carmarket_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val cars = dataset[position]

        holder.carMarketImage.load(cars.carImage)
        holder.manufacturerHeadline.text = cars.manufacturer
        holder.modelHeadline.text = cars.model

        holder.carMarketCard.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(CarMarketFragmentDirections.actionCarMarketFragmentToCarMarketDetailFragment(cars))
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
