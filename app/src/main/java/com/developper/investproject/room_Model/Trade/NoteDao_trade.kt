package com.developper.investproject.room_Model.Trade

import androidx.room.*
import com.developper.investproject.room_Model.Note

@Dao

interface NoteDao_trade {
    @Insert
    fun insertNote_trade(note: Note)

    @Delete
    fun deleteNote_trade(note: Note)

    @Update
    fun updateNote_trade(note: Note)

    @Query("SELECT * FROM trade_table")
    fun getAllNotes():List<Note_trade>
}