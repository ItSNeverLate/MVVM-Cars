package com.sevenpeakssoftware.mehdi.ui.main.articles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevenpeakssoftware.mehdi.R
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.databinding.FragmentArticlesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesFragment : Fragment(R.layout.fragment_articles), ArticlesAdapter.OnClickListener {

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
        articlesAdapter = ArticlesAdapter(this@ArticlesFragment)

        binding.apply {
            recyclerView.apply {
                adapter = articlesAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }
    }

    private fun subscribe() {
        viewModel.articlesFlow.observe(viewLifecycleOwner) { articles ->
            articlesAdapter.submitList(articles)
        }

//        viewModel.tasks.observe(viewLifecycleOwner, Observer {
//            tasksAdapter.submitList(it)
//        })

//        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//            viewModel.tasksEvent.collect { event ->
//                when (event) {
//                    is TasksViewModel.TasksEvent.ShowUndoTaskDeleted -> {
//                        Snackbar.make(requireView(), "Task deleted!", Snackbar.LENGTH_LONG)
//                            .setAction("Undo") {
//                                viewModel.onDeleteUndoClick(event.task)
//                            }
//                            .show()
//                    }
//                    is TasksViewModel.TasksEvent.NavigateToAddTask -> {
//                        val action =
//                            TasksFragmentDirections.actionTasksFragmentToAddEditTaskFragment(
//                                null,
//                                "Add Task"
//                            )
//                        findNavController().navigate(action)
//                    }
//                    is TasksViewModel.TasksEvent.NavigateToEditTask -> {
//                        val action =
//                            TasksFragmentDirections.actionTasksFragmentToAddEditTaskFragment(
//                                event.task,
//                                "Edit Task"
//                            )
//                        findNavController().navigate(action)
//                    }
//                    is TasksViewModel.TasksEvent.ShowTaskSavedConfirmationMessage -> {
//                        Snackbar.make(requireView(), event.msg, Snackbar.LENGTH_SHORT).show()
//                    }
//                    TasksViewModel.TasksEvent.NavigateToDeleteCompletedTasksScreen -> {
//                        val action =
//                            TasksFragmentDirections.actionGlobalDeletedCompletedTasksDialogFragment()
//                        findNavController().navigate(action)
//                    }
//                }.exhaustive
//            }
//        }
    }

    override fun onItemClick(article: ArticleEntity) {
    }
}