package com.nazmul.mvvmflowkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nazmul.mvvmflowkotlin.databinding.TvshowItemBinding
import com.nazmul.mvvmflowkotlin.model.TvShow

class TvShowAdapter(private val tvShowList: List<TvShow>) : ListAdapter<TvShow,TvShowAdapter.TvShowViewHolder>(DiffUtil()){


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
        return TvShowViewHolder(itemView.root)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {

    }

    inner class TvShowViewHolder(itemView : View) : ViewHolder(itemView){

    }
}