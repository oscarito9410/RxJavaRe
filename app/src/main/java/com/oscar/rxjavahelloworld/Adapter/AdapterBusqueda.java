package com.oscar.rxjavahelloworld.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oscar.rxjavahelloworld.Model.Result;
import com.oscar.rxjavahelloworld.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by oemy9 on 29/10/2017.
 */

public class AdapterBusqueda extends RecyclerView.Adapter<AdapterBusqueda.ViewHolder> {


    private Context context;
    private ArrayList<Result>listResult;
    private LayoutInflater layoutInflater;

    public AdapterBusqueda(Context context, ArrayList<Result> listResult) {
        this.context = context;
        this.listResult = listResult;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_busqueda,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindDatos(context,listResult.get(position));
    }

    @Override
    public int getItemCount() {
        return listResult.size();
    }

    public Context getContext() {
        return context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgMeme;
        public TextView tvNombre;

        public ViewHolder(View itemView) {
            super(itemView);
            imgMeme=(ImageView)itemView.findViewById(R.id.imgMeme);
            tvNombre=(TextView)itemView.findViewById(R.id.tvNombe);
        }

        public void bindDatos(Context context,Result result){
          //  Picasso.with(context).load()

            tvNombre.setText(result.getDisplayName());

        }
    }
}
