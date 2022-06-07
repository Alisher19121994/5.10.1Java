package com.example.a5101java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<MainClass> list;

    public FeedAdapter(Context context, ArrayList<MainClass> list) {
        this.context = context;
        this.list = list;
    }

    private int TYPE_ITEM_STORY = 0;
    private int TYPE_ITEM_POST = 1;

    @Override
    public int getItemViewType(int position) {
        MainClass mainClass = list.get(position);
        if (mainClass.story.size() > 0) {
            return TYPE_ITEM_STORY;
        }
        return TYPE_ITEM_POST;
    }

    void adapter(ArrayList<Story> stories, RecyclerView recyclerView) {
        StoryAdapter storyAdapter = new StoryAdapter(context, stories);
        recyclerView.setAdapter(storyAdapter);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_STORY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story, parent, false);
            return new StoryViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new FeedsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MainClass mainClass = list.get(position);

        if (holder instanceof StoryViewHolder) {
            RecyclerView recyclerView = ((StoryViewHolder) holder).recyclerView;
            adapter(mainClass.story, recyclerView);
        }

        if (holder instanceof FeedsViewHolder) {
            ((FeedsViewHolder) holder).pro.setImageResource(mainClass.posts.profile);
            ((FeedsViewHolder) holder).photo.setImageResource(mainClass.posts.photo);
            ((FeedsViewHolder) holder).fullname.setText(mainClass.posts.fullname);
            ((FeedsViewHolder) holder).liked_comments.setText(mainClass.posts.liked_comments);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.story_recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    public class FeedsViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView pro;
        ImageView photo;
        TextView fullname;
        TextView liked_comments;

        public FeedsViewHolder(@NonNull View itemView) {
            super(itemView);
            pro = itemView.findViewById(R.id.post_profile_id);
            photo = itemView.findViewById(R.id.post_fullImage_id);
            fullname = itemView.findViewById(R.id.post_fullname_id);
            liked_comments = itemView.findViewById(R.id.post_liked_comments_id);
        }
    }
}
