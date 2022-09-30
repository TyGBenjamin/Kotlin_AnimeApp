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
    val navigate: (id: String) -> Unit
) : RecyclerView.Adapter<CharAdapter.AnimeListViewHolder>() {
    private lateinit var animeList: List<Anime>

    inner class AnimeListViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun applyAnime(anime: Anime) = with(binding) {
            imageView.load(anime.attributes.posterImage[0].toString())
            tvTitle.text = anime.attributes.title.toString()
            root.setOnClickListener{
                navigate(anime.id)
            }
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
        this.animeList = animeList
    }
}


//class CharAdapter() : RecyclerView.Adapter<CharAdapter.CharListViewHolder>() {
//    private lateinit var data: List<Anime>
//
//    inner class CharListViewHolder(
//        private val binding: ItemListBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//        fun applyAnime(anime: Anime) = with(binding) {
//            imageView.load(anime.attributes.posterImage[0].toString())
//            tvTitle.text = anime.attributes.title.toString()
//            tvStartDate.text = anime.attributes.startDate
//            tvRating.text = anime.attributes.averageRating.toString()
//            tvPopularity.text = anime.attributes.popularity.toString()
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharListViewHolder {
//        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return CharListViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: CharListViewHolder, position: Int) {
//        val item = data[position]
//        holder.applyAnime(item)
//    }
//
//    override fun getItemCount() = this.data.size
//
//    fun addItems(items: List<Anime>) {
//        this.data = items
//    }
//}


