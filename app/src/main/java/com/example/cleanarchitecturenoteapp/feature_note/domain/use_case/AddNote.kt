package com.example.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.example.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.example.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note : Note) {
        if(note.title.isEmpty()) {
            throw InvalidNoteException("Title can't be empty")
        }

        if(note.content.isEmpty()) {
            throw InvalidNoteException("Content can't be empty")
        }
        repository.insertNote(note)
    }
}