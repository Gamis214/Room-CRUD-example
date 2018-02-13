package com.example.gamis214.roomdb_example;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gamis214.roomdb_example.DB.Tables.Person;

import java.util.List;

/**
 * Created by gamis214 on 18/01/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Person> lstPerson;

    public CustomAdapter(List<Person> lstPersons){
        this.lstPerson = lstPersons;
    }

    public class itemHolder extends RecyclerView.ViewHolder {

        public TextView txtName,txtLastName,txtxBirthday,txtAges;

        public itemHolder(View itemView) {
            super(itemView);
            txtName         = itemView.findViewById(R.id.txtName);
            txtLastName     = itemView.findViewById(R.id.txtLastName);
            txtxBirthday    = itemView.findViewById(R.id.txtBirthDay);
            txtAges         = itemView.findViewById(R.id.txtAges);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person,parent,false);
        return new itemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        itemHolder itemHolder = (itemHolder) holder;
        itemHolder.txtName.setText(lstPerson.get(position).getName());
        itemHolder.txtAges.setText(lstPerson.get(position).getAges());
        itemHolder.txtLastName.setText(lstPerson.get(position).getLastName());
        itemHolder.txtxBirthday.setText(lstPerson.get(position).getBirthDay());
    }

    @Override
    public int getItemCount() {
        return lstPerson.size();
    }

    public void removeAllItems(){
        lstPerson.clear();
        notifyDataSetChanged();
    }
}
