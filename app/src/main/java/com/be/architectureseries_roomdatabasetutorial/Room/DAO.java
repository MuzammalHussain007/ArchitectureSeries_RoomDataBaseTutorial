package com.be.architectureseries_roomdatabasetutorial.Room;

import androidx.annotation.RequiresPermission;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {
    @Insert
    long insertStudent(Student student);
    @Query("Select * from Student")
    List<Student> getAllRecord();

    @Query("Update Student set std_firstname=:firstname where std_id=:stdID ")
    int updateStudent(String firstname,int stdID);
    @Query("Delete from Student where std_id=:id")
    int deleteStudent(int id);

}
