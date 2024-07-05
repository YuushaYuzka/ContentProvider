package com.example.content_provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

public class ContactsCursorAdapter extends CursorAdapter {

    public ContactsCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(
                R.layout.kontak_list, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        @SuppressLint("Range") String contactName = cursor.getString(
                cursor.getColumnIndex(dbholder.CONTACT_NAME));
        @SuppressLint("Range") String contactPhone = cursor.getString(
                cursor.getColumnIndex(dbholder.CONTACT_PHONE));

        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView phoneTextView = view.findViewById(R.id.phoneTextView);

        nameTextView.setText(contactName);
        phoneTextView.setText(contactPhone);
    }
}
