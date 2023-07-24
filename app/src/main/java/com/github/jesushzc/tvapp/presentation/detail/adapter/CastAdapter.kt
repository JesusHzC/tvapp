package com.github.jesushzc.tvapp.presentation.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.jesushzc.tvapp.R
import com.github.jesushzc.tvapp.databinding.TvTalentItemBinding
import com.github.jesushzc.tvapp.domain.model.Talent

class CastAdapter(
    private val cast: List<Talent>
): RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        context = parent.context

        val layoutInflater = LayoutInflater.from(context)
        return CastViewHolder(layoutInflater.inflate(R.layout.tv_talent_item, parent, false))
    }

    override fun getItemCount(): Int = cast.size

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(cast[position])
    }

    inner class CastViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        private val binding = TvTalentItemBinding.bind(view)

        fun bind(talent: Talent) {
            binding.apply {
                tvName.text = talent.person?.name

                Glide.with(view.context)
                    .load(talent.person?.image?.medium)
                    .centerCrop()
                    .into(ivTalentPoster)
            }
        }

    }

}