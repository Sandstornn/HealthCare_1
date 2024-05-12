package com.example.healthcare_1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {LSHUser2.class},version=2)
public abstract class LSHUserDataBase2 extends RoomDatabase {
    public abstract LSHUserDao2 lshuserDao2();
}
