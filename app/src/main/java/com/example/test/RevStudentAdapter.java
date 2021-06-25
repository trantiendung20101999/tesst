package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.model.Student;

import java.util.List;

public class RevStudentAdapter  extends RecyclerView.Adapter<RevStudentAdapter.StudentHolder> {

    List<Student> listStudent;

    public List<Student> getListStudent() {
        return listStudent;
    }

    public RevStudentAdapter(List<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public void setListStudent(List<Student> listStudent) {
        this.listStudent = listStudent;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rev_stu,parent,false);
        return new StudentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        Student student = listStudent.get(position);
                if(student!=null)
                {
                    holder.txtFullname.setText(student.getFullName());
                    holder.txtYear.setText(student.getYear());
                    holder.txtAddress.setText(student.getAddress());
                    holder.txtTerm.setText(student.getTerm());
                }
    }

    @Override
    public int getItemCount() {
        if ( listStudent!=null)
        {
            return listStudent.size();
        }
        else
            return 0;
    }

    class StudentHolder extends RecyclerView.ViewHolder{

        TextView txtFullname , txtYear,txtAddress,txtTerm;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            txtFullname = itemView.findViewById(R.id.txtName);
            txtYear = itemView.findViewById(R.id.txtYear);
            txtAddress = itemView.findViewById(R.id.txtPlace);
            txtTerm = itemView.findViewById(R.id.txtTerm);
        }
    }
}
