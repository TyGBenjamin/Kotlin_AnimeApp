package com.alecbrando.starteranime.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alecbrando.starteranime.databinding.FragmentCharListBinding
import com.alecbrando.starteranime.databinding.ItemListBinding
import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.models.Data

class CharAdapter: RecyclerView.Adapter<CharAdapter.CharViewHolder>() {
    //    private var data: List<Anime> = emptyList()
    private var data: List<Anime> = mutableListOf()

    class CharViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
        fun applyItems(data: Data){
            binding.tvTitle.text = data.data[2].attributes.title.toString()
            binding.tvStartDate.text = data.data[2].attributes.startDate.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        TODO("Not yet implemented")
        val item = data[position]
        holder.applyItems(git add .item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addItems(items: List<Anime>){
        this.data = items
        notifyDataSetChanged()
    }
}