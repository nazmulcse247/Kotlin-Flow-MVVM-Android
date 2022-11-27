package com.nazmul.mvvmflowkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.nazmul.mvvmflowkotlin.databinding.TvshowItemBinding
import com.nazmul.mvvmflowkotlin.model.TvShow
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


class TvShowAdapter(val context: Context) : PagingDataAdapter<TvShow,TvShowAdapter.TvShowViewHolder>(DiffUtil()){


    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<TvShow>(){
        override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
            return oldItem == newItem
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemView = TvshowItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return TvShowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShowItem = getItem(position)
        holder.tvshowItemBinding.tvTitle.text = tvShowItem?.name


        Glide.with(context)
            .load(tvShowItem?.image_thumbnail_path)
            .transition(DrawableTransitionOptions.withCrossFade(2000))
            .into(holder.tvshowItemBinding.ivPoster)
    }


    inner class TvShowViewHolder(val tvshowItemBinding : TvshowItemBinding) : ViewHolder(tvshowItemBinding.root)


}