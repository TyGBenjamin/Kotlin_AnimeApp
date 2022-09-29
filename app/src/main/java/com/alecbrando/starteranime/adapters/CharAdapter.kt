package com.alecbrando.starteranime.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alecbrando.starteranime.databinding.FragmentCharListBinding
import com.alecbrando.starteranime.databinding.ItemListBinding
import com.alecbrando.starteranime.models.Anime

class CharAdapter: RecyclerView.Adapter<CharAdapter.CharViewHolder>() {
    private var data: List<Anime> = emptyList()
//    private var data: MutableList<Anime> = mutableListOf()

    class CharViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
        fun applyItems(data: Anime ){
            binding.tvTitle.text = data.attributes[1].title[0].toString()
            binding.tvStartDate.text = data.attributes[0].toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        TODO("Not yet implemented")
        val item = data[position]
        holder.applyItems(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addItems(items: List<Anime>){
        this.data = items
        notifyDataSetChanged()
    }
}