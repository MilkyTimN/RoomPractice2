package com.example.roompractice2.db.repository

import androidx.lifecycle.LiveData
import com.example.roompractice2.db.dao.NoteDao
import com.example.roompractice2.model.NoteModel

class NoteRepositoryImplement(private val noteDao: NoteDao): NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}