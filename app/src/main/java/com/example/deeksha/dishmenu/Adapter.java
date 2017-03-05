package com.example.deeksha.dishmenu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Deeksha on 3/5/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyView> {

    private List<dishes> dishList;

    public Adapter(List<dishes> disheList) {
        this.dishList = disheList;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom, parent, false);

        return new MyView(itemView);

    }

    @Override
    public void onBindViewHolder(MyView holder, int position) {
        dishes dish=dishList.get(position);
        holder.Name.setText(dish.Name);
        holder.Price.setText(dish.Price);
    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }

    public class MyView extends RecyclerView.ViewHolder{

        public TextView Name,Price;

        public MyView(View view){

            super(view);
            Name = (TextView) view.findViewById(R.id.customText1);
            Price = (TextView) view.findViewById(R.id.customText2);

        }

    }



}
