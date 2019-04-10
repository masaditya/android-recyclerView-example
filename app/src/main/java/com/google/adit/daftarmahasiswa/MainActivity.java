package com.google.adit.daftarmahasiswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.OnAdapterClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_students);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Adit", "123"));
        students.add(new Student("Ada", "634"));
        students.add(new Student("Adit", "324546"));
        students.add(new Student("Adit", "123"));
        students.add(new Student("Ada", "634"));
        students.add(new Student("Adit", "324546"));
        students.add(new Student("Adit", "123"));
        students.add(new Student("Ada", "634"));
        students.add(new Student("Adit", "324546"));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        StudentAdapter studentAdapter = new StudentAdapter(students, this);
        studentAdapter.setListener(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    @Override
    public void onClick(Student student) {
        Toast.makeText(this, student.getId(), Toast.LENGTH_SHORT).show();
    }
}
