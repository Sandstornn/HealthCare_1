package com.example.healthcare_1;

// LiveData추가해서 추가함.
import androidx.lifecycle.LiveData;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LSHUserDao1 {
    @Insert
    void setInsertUser(LSHUser1 user);
    // 비동기적으로 해야한대서 추가.
    @Query("SELECT * FROM LSHUser1")
    LiveData<List<LSHUser1>> getAllUsers();
    @Update
    void setUpdateUser(LSHUser1 user);
    @Delete
    void setDeleteUser(LSHUser1 user);
    @Query("SELECT * FROM LSHUser1")
    List<LSHUser1> getUserAll();
    @Query("SELECT Weight FROM LSHUser1 LIMIT 1")
    double getWeight();

    @Query("SELECT Height FROM LSHUser1 LIMIT 1")
    double getHeight();
}