package com.example.facebookpost.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookpost.R;
import com.example.facebookpost.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter  extends RecyclerView.Adapter<PostsAdapter.MyViewHandler>{

    private List<PostModel> posts = new ArrayList<>();
    @NonNull
    @Override
    public PostsAdapter.MyViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        MyViewHandler myViewHandler = new MyViewHandler(v);
        return myViewHandler;
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.MyViewHandler holder, int position) {

        holder.title.setText(posts.get(position).getTitle());
        holder.body.setText(posts.get(position).getBody());
        holder.user_id.setText(posts.get(position).getUserId()+"");

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setList(List<PostModel> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }


    public class MyViewHandler extends RecyclerView.ViewHolder

    {

        TextView body,user_id,title;
        public MyViewHandler(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            user_id = itemView.findViewById(R.id.user_id);

        }
    }
}
