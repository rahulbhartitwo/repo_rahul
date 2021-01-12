package com.kreate.daggerwithhilt.entity.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public
interface DummyUserDao {

    @Query("SELECT * FROM DummyUser")
    List<DummyUser> getAllUser();

    @Query("SELECT * FROM DummyUser WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    DummyUser findByName(String first , String last );

    @Insert
    void insertAll(DummyUser users );

    @Delete
    void delete(DummyUser user);

}
