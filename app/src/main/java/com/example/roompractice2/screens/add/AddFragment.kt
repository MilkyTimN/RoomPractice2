package com.example.roompractice2.screens.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.example.roompractice2.APP
import com.example.roompractice2.R
import com.example.roompractice2.databinding.FragmentAddBinding
import com.example.roompractice2.model.NoteModel
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }



    private fun init() {

        val viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        binding.fabSave.setOnClickListener{
            val title = binding.inputNoteTitle.text.toString()
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            val description = binding.inputNote.text.toString()
            viewModel.insert(NoteModel(title = title, description = description, date = currentDate)) {}
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                APP.navController.navigate(R.id.action_addFragment_to_startFragment)
            }
        })

    }
}