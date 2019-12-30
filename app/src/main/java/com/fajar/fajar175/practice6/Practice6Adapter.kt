package com.fajar.fajar175.practice6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fajar.fajar175.R
import com.fajar.fajar175.practice6.entity.TempatWisata
import kotlinx.android.synthetic.main.activity_practice6_item.view.*

class Practice6Adapter internal constructor(
    val context: Context
) : RecyclerView.Adapter<Practice6Adapter.TempatWisataViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var listTempatWisata = emptyList<TempatWisata>()

    inner class TempatWisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myData: TempatWisata) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(myData.gambar)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = myData.nama
                tv_item_address.text = myData.alamat
                tv_item_deskripsi.text = myData.deskripsi
            }
        }
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TempatWisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempatWisataViewHolder {
        val itemView = inflater.inflate(R.layout.activity_practice6_item, parent, false)
        return TempatWisataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TempatWisataViewHolder, position: Int) {
        holder.bind(listTempatWisata[position])
        val current = listTempatWisata[position]
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(current)
        }
    }

    internal fun setTempatWisata(listTempatWisata: List<TempatWisata>) {
        this.listTempatWisata = listTempatWisata
        notifyDataSetChanged()
    }

    override fun getItemCount() = listTempatWisata.size
}