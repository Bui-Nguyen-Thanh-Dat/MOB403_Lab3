package com.example.lab3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
public class ContactAdapter extends BaseAdapter {
    Context context;
    ArrayList<Contact> contactList;
    public ContactAdapter(Context context, ArrayList<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }
    @Override
    public int getCount() {
        return contactList.size();
    }
    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    public static class ViewHolder {
        TextView tvName, tvEmail, tvMobile;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.list_item, null);
            viewHolder.tvName = (TextView) view.findViewById(R.id.name);
            viewHolder.tvEmail = (TextView) view.findViewById(R.id.email);
            viewHolder.tvMobile = (TextView) view.findViewById(R.id.mobile);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
        Contact contact = contactList.get(i);
        viewHolder.tvName.setText(contact.getName());
        viewHolder.tvEmail.setText(contact.getEmail());
        viewHolder.tvMobile.setText(contact.getMobile());
        return view;
    }
}
