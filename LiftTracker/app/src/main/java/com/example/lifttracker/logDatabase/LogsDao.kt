package com.example.lifttracker.logDatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.lifttracker.exerciseDatabase.NewExercise

@Dao
interface LogsDao {

    @Insert
    fun insert(logs: Logs)

    @Delete
    fun delete(logs: Logs?)

    @Update
    fun update(logs: Logs)

    @Query("DELETE FROM logs_table")
    fun clear()

    @Query("SELECT * FROM logs_table ORDER BY logID ASC")
    fun getAllLogs() : LiveData<List<Logs>>

    @Query("SELECT * FROM logs_table ORDER BY logID DESC LIMIT 1")
    fun getLastLog() : Logs?

    @Query("SELECT * FROM logs_table WHERE exerciseID = :exerciseID ORDER BY logID DESC LIMIT 1")
    fun getLastExerciseLog(exerciseID: Long?) : Logs?

    @Query("SELECT * FROM logs_table WHERE exerciseID = :exerciseID ORDER BY logID ASC")
    fun getLogsByID(exerciseID: Long?) : LiveData<List<Logs>>


    //remove one
    //get last
//    @Query("SELECT * FROM logs_table WHERE logID > timedate('now') ")
//    fun showRecentLogs(): LiveData<List<Logs>>

}