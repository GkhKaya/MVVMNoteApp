package com.appcade.mvvmnoteapp.presentation.notes

import com.appcade.mvvmnoteapp.feature_note.domain.model.Note
import com.appcade.mvvmnoteapp.feature_note.domain.util.NoteOrder
import com.appcade.mvvmnoteapp.feature_note.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
