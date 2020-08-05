package com.example.tola.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tola.Data.PlanData;
import com.example.tola.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PlanAdapter  extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {

    private ArrayList<PlanData> mdata;
    private Context context;

    public PlanAdapter(ArrayList<PlanData> mdata,Context context) {
        this.mdata = mdata;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_plan_item,parent,false);
        PlanViewHolder holder = new PlanViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PlanViewHolder holder, final int position) {

        holder.tv_name.setText(mdata.get(position).getTitle());

        holder.tv_content.setText(mdata.get(position).getContent());
        holder.tv_date.setText(mdata.get(position).getDate());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v, position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                remove(holder.getAdapterPosition());

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null!=mdata?mdata.size():0);
    }

    public void remove(int position){
        try{
            mdata.remove(position);
            notifyItemRemoved(position);
        }catch (IndexOutOfBoundsException ex){

        }
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder {


        protected TextView tv_name;
        protected TextView tv_content;
        private TextView tv_date;

        public PlanViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tv_date=itemView.findViewById(R.id.plan_date_item);
            this.tv_name=itemView.findViewById(R.id.plan_title_item);
            this.tv_content=itemView.findViewById(R.id.plan_content_item);
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
