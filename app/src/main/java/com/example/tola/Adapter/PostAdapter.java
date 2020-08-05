package com.example.tola.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tola.Data.PostData;
import com.example.tola.R;

import java.util.ArrayList;

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    ArrayList<PostData> mdata;
    private Context context;

    public PostAdapter(ArrayList<PostData> mdata, Context context) {
        this.mdata = mdata;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_post_item,parent,false);
        PostViewHolder holder = new PostViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, final int position) {

        holder.tv_title.setText(mdata.get(position).getTitle());
        holder.tv_date.setText(mdata.get(position).getDate());
        holder.tv_content.setText(mdata.get(position).getContent());
        holder.tv_user.setText(mdata.get(position).getUser());
        holder.iv_imageView.setImageURI(Uri.parse(mdata.get(position).getPostImage()));
        holder.iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null!=mdata?mdata.size():0);
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private TextView tv_user;
        private TextView tv_date;
        private ImageView iv_menu;
        private ImageView iv_imageView;

        private TextView tv_content;




        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title=itemView.findViewById(R.id.tv_post_title);
            tv_user=itemView.findViewById(R.id.tv_post_user);
            tv_content=itemView.findViewById(R.id.tv_post_content);
            iv_menu=itemView.findViewById(R.id.iv_post_menu);
            iv_imageView=itemView.findViewById(R.id.iv_post_image);
            tv_date=itemView.findViewById(R.id.tv_post_date);

        }
    }

    public void showPopup(View v, final int position) {
        PopupMenu popup = new PopupMenu(context, v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.modify:





                        return true;
                    case R.id.delete:


                        mdata.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, mdata.size());
                        return true;
                    default:
                        return false;
                }
            }
        });
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.recyler_item, popup.getMenu());
        popup.show();
    }
}
