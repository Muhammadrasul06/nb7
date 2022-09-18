package com.example.room

import androidx.room.*
import com.developper.investproject.room_Model.Note

@Dao
interface NoteDao {
    @Insert
      fun insertNote(note: Note)

    @Delete
      fun deleteNote(note: Note)

    @Update
      fun updateNote(note: Note)

    @Query("SELECT * FROM note_table")
     fun getAllNotes(): List<Note>
}