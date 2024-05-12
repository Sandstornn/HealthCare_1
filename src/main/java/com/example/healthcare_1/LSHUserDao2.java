package com.example.healthcare_1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LSHUserDao2 {
    @Insert
    void setInsertUser(LSHUser2 user);
    @Update
    void setUpdateUser(LSHUser2 user);
    @Delete
    void setDeleteUser(LSHUser2 user);
    @Query("SELECT * FROM LSHUser2")
    List<LSHUser2> getUserAll();

    // 추가: 년/월/일을 입력해서 그 날짜의 칼로리를 추출하기
    @Query("SELECT * FROM LSHUser2 WHERE Date = :year || '-' || :month || '-' || :day")
    List<LSHUser2> getCaloriesForDate(int year, int month, int day);

}