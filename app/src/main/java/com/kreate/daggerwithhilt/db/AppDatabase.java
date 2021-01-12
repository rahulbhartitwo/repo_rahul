package com.kreate.daggerwithhilt.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.kreate.daggerwithhilt.entity.room.DummyUser;
import com.kreate.daggerwithhilt.entity.room.DummyUserDao;

@Database(entities =  {DummyUser.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract DummyUserDao userDao();

}
