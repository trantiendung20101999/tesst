package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.test.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edFullname , edYear , edAddress;
    Spinner spinner ;
    Button addStu;
    RecyclerView rev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        String[] term = {"nam nhat","nam hai","nam ba","nam tu"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,term
        );
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        SqliteStudentHelper sqliteStudentHelper = new SqliteStudentHelper(this);
        List<Student> listStu = sqliteStudentHelper.getAllStudent();
        RevStudentAdapter studentAdapter = new RevStudentAdapter(listStu);
        rev.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rev.setAdapter(studentAdapter);

        addStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= edFullname.getText().toString();
                String year = edYear.getText().toString();
                String address = edAddress.getText().toString();
                String term = spinner.getSelectedItem().toString();
                Student student = new Student(name,year,address,term);
                sqliteStudentHelper.addStudent(student);
                List<Student> listStuAfterAdd = sqliteStudentHelper.getAllStudent();
                studentAdapter.setListStudent(listStuAfterAdd);

            }
        });

    }
    public void init()
    {
        edFullname = findViewById(R.id.edName);
        edAddress = findViewById(R.id.edPlace);
        edYear = findViewById(R.id.edYear);

        spinner = findViewById(R.id.spinner);
        addStu = findViewById(R.id.btnAdd);
        rev = findViewById(R.id.rev);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem item = menu.findItem(R.id.addClass);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent  intent = new Intent(getApplicationContext(),AddSubActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}

