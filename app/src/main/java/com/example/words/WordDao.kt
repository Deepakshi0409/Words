package com.example.words

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word Asc")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun insert(word :Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}