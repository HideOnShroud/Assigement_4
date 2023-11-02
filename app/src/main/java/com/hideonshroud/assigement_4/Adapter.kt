package com.hideonshroud.assigement_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(var items:List<Data>) : RecyclerView.Adapter<Adapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView : TextView = itemView.findViewById(R.id.nameTextView)
        val descTextView : TextView = itemView.findViewById(R.id.descTextView)
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
    }

    var onItemClick : ((Data) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return DataViewHolder(view)
     }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

            holder.nameTextView.text = items[position].userName
            holder.descTextView.text = items[position].description
            Glide.with(holder.itemView)
                .load(items[position].image)
                .into(holder.imageView);

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(items[position])
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}