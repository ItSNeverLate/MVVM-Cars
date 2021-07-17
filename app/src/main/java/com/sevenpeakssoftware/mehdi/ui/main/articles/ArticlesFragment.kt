package com.sevenpeakssoftware.mehdi.ui.main.articles

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevenpeakssoftware.mehdi.R
import com.sevenpeakssoftware.mehdi.databinding.FragmentArticlesBinding
import com.sevenpeakssoftware.mehdi.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesFragment : Fragment(R.layout.fragment_articles)
{

    private val viewModel: ArticlesViewModel by viewModels()
    private lateinit var binding: FragmentArticlesBinding
    private lateinit var articlesAdapter: ArticlesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentArticlesBinding.bind(view)

        init()
        subscribe()
    }

    private fun init() {
        articlesAdapter = ArticlesAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = articlesAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }
    }

    private fun subscribe() {
        binding.apply {

            viewModel.articles.observe(viewLifecycleOwner) { result ->
                articlesAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage
            }
        }

    }
}