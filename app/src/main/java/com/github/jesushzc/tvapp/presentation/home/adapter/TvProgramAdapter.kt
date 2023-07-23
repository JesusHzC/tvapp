package com.github.jesushzc.tvapp.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.jesushzc.tvapp.R
import com.github.jesushzc.tvapp.databinding.TvShowItemBinding
import com.github.jesushzc.tvapp.domain.model.TvProgram

class TvProgramAdapter(
    private val tvPrograms: List<TvProgram>
): RecyclerView.Adapter<TvProgramAdapter.TvProgramViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvProgramViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        return TvProgramViewHolder(layoutInflater.inflate(R.layout.tv_show_item, parent, false))
    }

    override fun getItemCount(): Int = tvPrograms.size

    override fun onBindViewHolder(holder: TvProgramViewHolder, position: Int) {
        holder.bind(tvPrograms[position])
    }

    inner class TvProgramViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = TvShowItemBinding.bind(view)

        fun bind(show: TvProgram) {
            binding.tvShowName.text = show.show?.name
            binding.tvShowNetwork.text = show.show?.network?.name
            binding.tvShowDatetime.text = context.getString(
                R.string.date_time_string,
                show.show?.schedule?.time,
                show.show?.schedule?.days?.firstOrNull()
            )

            Glide.with(view.context)
                .load(show.show?.image?.medium)
                .centerCrop()
                .into(binding.ivShowPoster)
        }

    }
}