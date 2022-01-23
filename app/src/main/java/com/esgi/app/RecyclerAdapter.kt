package com.esgi.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RecyclerAdapter(private val products: Array<Product>, private val listener: OnListProductClickListener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.food_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(products[position].url).into(holder.itemImage)
        holder.itemNameText.text = products[position].nom
        holder.itemMarkText.text = products[position].marque
        holder.itemView.setOnClickListener{
            listener.onProductClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return products.size;
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemNameText: TextView
        var itemMarkText: TextView

        init {
            itemImage = itemView.findViewById(R.id.imageView)
            itemNameText = itemView.findViewById(R.id.title)
            itemMarkText = itemView.findViewById(R.id.subtitle)
        }
    }


}
 interface  OnListProductClickListener {
     fun onProductClicked (position: Int)
 }