package com.google.adit.daftarmahasiswa;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.xml.parsers.SAXParser;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> students;
    private Context context;
    OnAdapterClickListener listener;


    public OnAdapterClickListener getListener() {
        return listener;
    }

    public void setListener(OnAdapterClickListener listener) {
        this.listener = listener;
    }


    public interface OnAdapterClickListener{
        void onClick(Student student);
    }

    public StudentAdapter(List<Student> students, Context context){
        this(students, context, null);
    }

    public StudentAdapter(List<Student> students, Context context, OnAdapterClickListener listener) {
        this.students = students;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Student student = students.get(i);
        View view = LayoutInflater.from(context).inflate(R.layout.student, viewGroup, false);

        return new ViewHolder(view, student);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder viewHolder, int i) {
        Student student = students.get(i);
        viewHolder.name.setText(student.getName());
        viewHolder.id.setText(student.getId());

    }

    @Override
    public int getItemCount() {
        return (students != null ? students.size() : 0);
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView name;
        TextView id;

        public ViewHolder(@NonNull View itemView, final Student student) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            id = itemView.findViewById(R.id.tv_id);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student student1 = students.get(getAdapterPosition());
                    Intent intent = new Intent(context, Detail.class);
                    intent.putExtra("name", student1.getName());
                    intent.putExtra("id", student1.getId());
                    context.startActivity(intent);

//                    listener.onClick(student.g);
                    Toast.makeText(context, student1.getId(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
