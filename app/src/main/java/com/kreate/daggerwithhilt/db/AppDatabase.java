package com.kreate.daggerwithhilt.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.kreate.daggerwithhilt.entity.room.DummyUser;
import com.kreate.daggerwithhilt.entity.room.DummyUserDao;
import com.kreate.daggerwithhilt.entity.room.UserRegistration;

@Database(entities =  {UserRegistration.class, DummyUser.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract DummyUserDao userDao();

}
