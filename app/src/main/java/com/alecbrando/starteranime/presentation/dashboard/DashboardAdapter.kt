package com.alecbrando.starteranime.presentation.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alecbrando.starteranime.databinding.ThumbnailBinding
import com.alecbrando.starteranime.domain.models.Anime

class DashboardAdapter(
    private var animeList: List<Anime>,
    private val navigateToDetails: (characterString: String) -> Unit
): RecyclerView.Adapter<DashboardAdapter.ThumbnailViewHolder>() {

    class ThumbnailViewHolder(
        private val binding: ThumbnailBinding,
        private val navigateToDetails: (characterString: String) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun applyItem(anime: Anime) = with(binding) {
            tvThumbnail.text = anime.attributes.title
            ivThumbnail.load(anime.attributes.posterImage.large)

            binding.root.setOnClickListener {
                navigateToDetails(anime.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        val binding = ThumbnailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ThumbnailViewHolder(binding, navigateToDetails)
    }

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        holder.applyItem(animeList[position])
    }

    override fun getItemCount() = animeList.size

    fun addItems(animeList: List<Anime>) {
        this.animeList = animeList
    }
}