package com.example.myapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TASKAdapter extends RecyclerView.Adapter {
    List<TASKS> dataSource;

    public TASKAdapter(List<TASKS> dataSource) {
        this.dataSource = dataSource;
    }

    public final class TaskItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView date;
        TextView message;
        TextView priority;
        public int position;

        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            date = (TextView) itemView.findViewById(R.id.tv_date);
            message = (TextView) itemView.findViewById(R.id.tv_message);
            priority = (TextView) itemView.findViewById(R.id.tv_priority);
        }

        @Override
        public void onClick(View v) {
            // lấy vị trí
            int vtClicked = getAdapterPosition();
            // lục ở nguồn dữ liệu
            TASKS taskClicked = dataSource.get(vtClicked);
            // xử lý, ví dụ ở đây ta Toast
            Toast.makeText(v.getContext(), "Bạn vừa chọn việc " + taskClicked.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_layout, parent, false);
        TaskItemViewHolder viewHolder = new TaskItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        TaskItemViewHolder viewHolder = (TaskItemViewHolder) holder;
        viewHolder.position = position;
        TASKS task = dataSource.get(position);
        ((TaskItemViewHolder) holder).name.setText(task.getName());
        ((TaskItemViewHolder) holder).message.setText(task.getMessage());
        ((TaskItemViewHolder) holder).priority.setText(task.getPriority());
        ((TaskItemViewHolder) holder).date.setText(task.getDate());
    }
    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
