package com.appcade.mvvmnoteapp.feature_note.domain.use_case

import com.appcade.mvvmnoteapp.feature_note.domain.model.Note
import com.appcade.mvvmnoteapp.feature_note.domain.repository.NoteRepository
import com.appcade.mvvmnoteapp.feature_note.domain.util.NoteOrder
import com.appcade.mvvmnoteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(noteOrder: NoteOrder=NoteOrder.Data(OrderType.Descending)):Flow<List<Note>>{
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Data ->  notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Data ->  notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }

                }
            }
        }
    }
}