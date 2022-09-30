package com.alecbrando.starteranime.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alecbrando.starteranime.databinding.FragmentCharListBinding
import com.alecbrando.starteranime.databinding.ItemListBinding
import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.models.Data




class CharAdapter(
    private var animeList: List<Anime>,
    val navigate: (id: String) -> Unit
) : RecyclerView.Adapter<CharAdapter.AnimeListViewHolder>() {

    inner class AnimeListViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun applyAnime(anime: Anime) = with(binding) {
            tvTitle.text = anime.attributes.canonicalTitle
            imageView.load(anime.attributes.posterImage.small)

//            root.setOnClickListener{
//                navigate(anime.id)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeListViewHolder, position: Int) {
        val item = animeList[position]
        holder.applyAnime(item)
    }

    override fun getItemCount() = animeList.size

    fun addItems(animeList: List<Anime>) {
        this.animeList = animeList as MutableList<Anime>
    }
}




