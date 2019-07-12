package com.sudowodo.cechack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class patientAdapter extends BaseAdapter {

    private Activity activity;
    private List<patientDetails> listPatient;

    public patientAdapter(Activity activity, List<patientDetails> listPatient) {
        this.activity = activity;
        this.listPatient = listPatient;
    }


    @Override
    public int getCount() {
        return listPatient.size();
    }

    @Override
    public Object getItem(int i) {
        return listPatient.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        viewHolderNew holder;
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.patient_view, null);

            holder = new viewHolderNew();
            holder.Name = convertView.findViewById(R.id.name);
            holder.Age = convertView.findViewById(R.id.age);
            holder.NurseID = convertView.findViewById(R.id.nurse);
            holder.diseaseType = convertView.findViewById(R.id.diseaseType);
            holder.imageView = convertView.findViewById(R.id.imageViewPatient);

            convertView.setTag(holder);
        }else{
            holder = (viewHolderNew)convertView.getTag();
        }

        holder.Name.setText(listPatient.get(position).getName());
        holder.Age.setText(listPatient.get(position).getAge());
        holder.NurseID.setText(listPatient.get(position).getNurseID());
        holder.diseaseType.setText(listPatient.get(position).getDiseaseType());
        holder.imageView.setImageResource(R.drawable.profileplaceholder);
        return convertView;
    }

        class viewHolderNew{
            TextView Name;
            TextView Age;
            TextView NurseID;
            TextView diseaseType;
            ImageView imageView;

        }
}