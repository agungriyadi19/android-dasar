package com.example.submissiondasar

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListThingsAdapter(private val listThings: ArrayList<Things>) : RecyclerView.Adapter<ListThingsAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_things, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (country, capital, photo, language, currency, description) = listThings[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto) // imageView mana yang akan diterapkan
        holder.tvCountry.text = country
        holder.tvCapital.text = capital
        holder.tvCurrency.text = currency
        holder.tvLanguage.text = language
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_COUNTRY, country)
            intentDetail.putExtra(DetailActivity.EXTRA_PHOTO, photo)
            intentDetail.putExtra(DetailActivity.EXTRA_CAPITAL, capital)
            intentDetail.putExtra(DetailActivity.EXTRA_LANGUAGE, language)
            intentDetail.putExtra(DetailActivity.EXTRA_CURRENCY, currency)
            intentDetail.putExtra(DetailActivity.EXTRA_DESCRIPTION, description)
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listThings.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvCountry: TextView = itemView.findViewById(R.id.tv_country)
        val tvCapital: TextView = itemView.findViewById(R.id.tv_capital)
        val tvCurrency: TextView = itemView.findViewById(R.id.tv_currency)
        val tvLanguage: TextView = itemView.findViewById(R.id.tv_language)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Things)
    }

}