package com.kreate.daggerwithhilt.entity.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DummyUser {
    @PrimaryKey
    int uid;
    @ColumnInfo(name = "first_name")
    String firstName;
    @ColumnInfo(name = "last_name")
    String lastname;
}
