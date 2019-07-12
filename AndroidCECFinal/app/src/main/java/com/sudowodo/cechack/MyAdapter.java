package com.sudowodo.cechack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Activity activity;
    private List<patient> listPatient;

    public MyAdapter(Activity activity, List<patient> listPatient){
        this.activity = activity;
        this.listPatient=listPatient;
    }

    @Override
    public int getCount() {
        return listPatient.size();
    }

    @Override
    public Object getItem(int position) {
        return listPatient.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.my_text_view, null);

            holder = new ViewHolder();
            holder.textOne = convertView.findViewById(R.id.textOne);
            holder.textTwo = convertView.findViewById(R.id.textTwo);
            holder.imageOne = convertView.findViewById(R.id.imageOne);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.textOne.setText(listPatient.get(position).getTextOne());
        holder.textTwo.setText(listPatient.get(position).getTextTwo());
        holder.imageOne.setImageResource(R.drawable.profileplaceholder);
        return convertView;
    }
    class ViewHolder{
        TextView textOne;
        TextView textTwo;
        ImageView imageOne;
    }

}
