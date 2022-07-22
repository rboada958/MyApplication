package com.app.androidev.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.app.androidev.R
import com.app.androidev.app.model.news.ResultsItem
import com.app.androidev.databinding.FragmentNewsBinding
import com.app.androidev.ui.views.adapter.NewsAdapter
import com.app.androidev.ui.views.mvvm.NewsViewModel
import com.app.androidev.utils.base.gone
import com.app.androidev.utils.base.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(), NewsAdapter.OnNewsClickListener {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<NewsViewModel>()
    private val adapter by lazy {
        NewsAdapter(mutableListOf(), this)
    }

    lateinit var result: List<ResultsItem?>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNews()

        binding.recyclerNews.adapter = adapter

        viewModel.newsUiState.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { uiState ->
                when (uiState) {
                    is NewsViewModel.NewsUiState.ShowLoading -> {
                        binding.progress.visible()
                    }
                    is NewsViewModel.NewsUiState.Error -> {
                        binding.progress.gone()
                        Toast.makeText(requireContext(), uiState.msg, Toast.LENGTH_SHORT).show()
                    }
                    is NewsViewModel.NewsUiState.SuccessNews -> {
                        this@NewsFragment.result = uiState.result
                        binding.progress.gone()
                        adapter.addItems(result)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onNewsClicked(item: ResultsItem) {
        findNavController().navigate(
            R.id.newsDetailsFragment,
            bundleOf("apiUrl" to item.apiUrl)
        )
    }
}