package com.dobrucali.kickstarterproject.ui.main

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.content.Intent.CATEGORY_BROWSABLE
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dobrucali.kickstarterproject.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = DetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val project = DetailFragmentArgs.fromBundle(requireArguments()).selectedProject
        val viewModelFactory = DetailViewModelFactory(project, application)
        binding.viewModel =
            ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        binding.openProjectButton.setOnClickListener {
            binding.viewModel?.displayProjectOnBrowser()
        }

        binding.viewModel!!.projectUrl.observe(viewLifecycleOwner, Observer { projectUrl ->
            if (projectUrl != null) {
                val query: String = Uri.encode(projectUrl, "UTF-8")
                val browserIntent = Intent(CATEGORY_BROWSABLE, Uri.parse(Uri.decode(query)))
                browserIntent.action = ACTION_VIEW
                startActivity(browserIntent)
            }
        })

        return binding.root

    }


}