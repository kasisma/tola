package com.example.tola.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tola.Data.FamilyData;
import com.example.tola.R;

import java.util.ArrayList;

public class FamilyAdapter  extends RecyclerView.Adapter<FamilyAdapter.FamilyViewHolder>{

    private ArrayList<FamilyData> mdata;
    private Context context;

    public FamilyAdapter(ArrayList<FamilyData> mdata) {
        this.mdata = mdata;
    }
    @NonNull
    @Override
    public FamilyAdapter.FamilyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_family_item,parent,false);
        FamilyViewHolder  holder = new FamilyViewHolder(view);

        context=parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FamilyAdapter.FamilyViewHolder holder, int position) {

        holder.tv_name.setText(mdata.get(position).getName());
        holder.tv_phon.setText(mdata.get(position).getPhonNumber());
        holder.tv_image.setImageResource(mdata.get(position).getFamilyImage());


        holder.iv_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"01024663933"));
                context.startActivity(intent);

            }
        });

        holder.iv_modyfy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



    }

    @Override
    public int getItemCount() {
        return (null!=mdata?mdata.size():0);
    }

    public class FamilyViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_name;
        protected TextView tv_phon;
        protected ImageView tv_image;
        private ImageView iv_modyfy;
        private ImageView iv_call;



        public FamilyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tv_image=itemView.findViewById(R.id.iv_family_image);
            this.tv_name=itemView.findViewById(R.id.tv_family_name);
            this.tv_phon=itemView.findViewById(R.id.tv_phon_number);
            this.iv_modyfy=itemView.findViewById(R.id.family_menu_item);
            this.iv_call=itemView.findViewById(R.id.call);

        }
    }
}
