package com.dobrucali.kickstarterproject.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dobrucali.kickstarterproject.network.Project


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Project>?) {
    val adapter = recyclerView.adapter as ProjectAdapter
    adapter.submitList(data)
}



