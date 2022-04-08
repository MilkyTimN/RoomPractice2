package com.example.roompractice2.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roompractice2.REPOSITORY
import com.example.roompractice2.db.NoteDatabase
import com.example.roompractice2.db.repository.NoteRepositoryImplement
import com.example.roompractice2.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRepositoryImplement(daoNote)
    }

    fun getALlNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}