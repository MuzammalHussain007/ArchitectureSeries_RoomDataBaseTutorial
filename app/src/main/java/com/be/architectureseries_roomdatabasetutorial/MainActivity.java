package com.be.architectureseries_roomdatabasetutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.be.architectureseries_roomdatabasetutorial.Room.MyDatabase;
import com.be.architectureseries_roomdatabasetutorial.Room.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText firstname, lastname, class_name ,update_first_name,update_id , delete_id;
    private Button insert , read ,update ,delete;
    private MyDatabase myDatabase;
    private long res ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection();
         myDatabase = Room.databaseBuilder(this, MyDatabase.class, "Student.db")
                .allowMainThreadQueries()
                .build();
         insert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Student student = new Student(firstname.getText().toString(),lastname.getText().toString(),class_name.getText().toString());
               res=myDatabase.dao().insertStudent(student);
               if (res!=-1)
               {
                   Toast.makeText(MainActivity.this, "Data is inserted", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(MainActivity.this, "Data is not inserted", Toast.LENGTH_SHORT).show();
               }
             }
         });

         read.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 List<Student> studentList = myDatabase.dao().getAllRecord();
                 if (studentList.size()==0)
                 {
                     Toast.makeText(MainActivity.this, "No data to show", Toast.LENGTH_SHORT).show();
                 }else
                 {
                     for (Student student : studentList)
                     {
                         Toast.makeText(MainActivity.this, ""+student.getStd_firstname()+":"+student.getStd_lastname()+":"+student.getStd_class(), Toast.LENGTH_SHORT).show();
                     }
                 }
              }
         });

         update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             int i  = myDatabase.dao().updateStudent(update_first_name.getText().toString(),Integer.parseInt(update_id.getText().toString()));
             if (i!=0)
             {
                 Toast.makeText(MainActivity.this, "Student Updated..", Toast.LENGTH_SHORT).show();
             }else
             {
                 Toast.makeText(MainActivity.this, "Student not Updated..", Toast.LENGTH_SHORT).show();
             }
             }
         });
         delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int i = myDatabase.dao().deleteStudent(Integer.parseInt(delete_id.getText().toString()));
                 if (i > 0)
                 {
                     Toast.makeText(MainActivity.this, "Record is Deleted..", Toast.LENGTH_SHORT).show();
                 }else
                 {
                     Toast.makeText(MainActivity.this, "Record is not Deleted..", Toast.LENGTH_SHORT).show();

                 }
             }
         });


    }

    private void connection() {
        firstname = findViewById(R.id.student_firstName);
        lastname = findViewById(R.id.student_lastname);
        class_name = findViewById(R.id.student_class);
        insert = findViewById(R.id.student_insert);
        read = findViewById(R.id.student_update);
        update = findViewById(R.id.student_update_);
        update_id = findViewById(R.id.student_update_id);
        update_first_name = findViewById(R.id.student_update_firstname);
        delete_id = findViewById(R.id.student_delete_id);
        delete = findViewById(R.id.student_delete_);

    }
}