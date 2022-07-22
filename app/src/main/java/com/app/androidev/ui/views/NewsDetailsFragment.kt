package com.app.androidev.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.app.androidev.app.model.newsDetails.Content
import com.app.androidev.databinding.FragmentNewsDetailsBinding
import com.app.androidev.ui.views.mvvm.NewsViewModel
import com.app.androidev.utils.base.gone
import com.app.androidev.utils.base.loadRect
import com.app.androidev.utils.base.parseDate
import com.app.androidev.utils.base.visible
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat

@AndroidEntryPoint
class NewsDetailsFragment : Fragment() {

    private var _binding: FragmentNewsDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<NewsViewModel>()

    private val args by navArgs<NewsDetailsFragmentArgs>()

    lateinit var content: Content

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNewsDetails(args.apiUrl)

        viewModel.newsDetailsUiState.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { uiState ->
                when (uiState) {
                    is NewsViewModel.NewsDetailsUiState.ShowLoading -> {
                        binding.progress.visible()
                    }
                    is NewsViewModel.NewsDetailsUiState.Error -> {
                        binding.progress.gone()
                        Toast.makeText(requireContext(), uiState.msg, Toast.LENGTH_SHORT).show()
                    }
                    is NewsViewModel.NewsDetailsUiState.SuccessNewsDetails -> {
                        this@NewsDetailsFragment.content = uiState.result
                        binding.progress.gone()
                        binding.avatar.loadRect(content.fields!!.thumbnail)
                        binding.title.text = content.webTitle
                        binding.date.parseDate(content.webPublicationDate!!)
                        binding.body.text = content.fields!!.bodyText
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}