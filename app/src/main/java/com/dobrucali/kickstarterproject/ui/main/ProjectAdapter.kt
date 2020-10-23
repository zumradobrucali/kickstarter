package com.dobrucali.kickstarterproject.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dobrucali.kickstarterproject.databinding.ItemViewBinding
import com.dobrucali.kickstarterproject.network.Project

class ProjectAdapter(private val onClickListener: OnClickListener): ListAdapter<Project, ProjectAdapter.ItemViewHolder>(DiffCallBack) {
    companion object DiffCallBack: DiffUtil.ItemCallback<Project>() {
        override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem.sNo == newItem.sNo
        }
    }
    class ItemViewHolder(private var binding: ItemViewBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(project: Project) {
            binding.projectItem = project
            binding.executePendingBindings()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val project = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(project) }
        holder.bind(project)
    }
    class OnClickListener(val clickListener: (project: Project) -> Unit) {
        fun onClick(project: Project) = clickListener(project)
    }
}

