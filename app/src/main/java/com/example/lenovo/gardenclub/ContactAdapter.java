package com.example.lenovo.gardenclub;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Joe on 3/19/2018.
 */


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> implements Filterable {
    private ArrayList<Contacts> contacts;
    private ArrayList<Contacts> contactsFiltered;
    private Context context;
    private ValueFilter valueFilter;
    private static final String TAG = "ContactAdapter";

    ContactAdapter(@NonNull Context context, ArrayList<Contacts> contacts) {
        this.context = context;
        this.contacts = contacts;
        this.contactsFiltered = contacts;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvMbrStatus;
        private ImageView mImageView;
        private View parentView;
        private ImageView bigImageView;

        ViewHolder(@NonNull View view) {
            super(view);
            this.parentView = view;
            this.tvName = view.findViewById(R.id.nameTV);
            this.tvMbrStatus = view.findViewById(R.id.tv_mbrstatus);
            this.mImageView = view.findViewById(R.id.imageView4);
            this.bigImageView = view.findViewById(R.id.bigImageView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Contacts contact = contactsFiltered.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvMbrStatus.setText(contact.getMbrStatus());
        String pID = contact.getPhotoID();
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Contact.class);
                    intent.putExtra("user_id", contact.getUserID());
                    intent.putExtra("login_email", contact.getLoginEmail());
                context.startActivity(intent);
                ContactList.fa.finish();
            }
        });

        if (!pID.equals("null")) {
            Glide.with(context)
                    .load("http://capefeargardenclub.org/cfgcTestingJSON/images_Testing/images/" + pID + ".jpg")
                    .apply(RequestOptions.overrideOf(100, 100))
                    .into(holder.mImageView);
            Glide.with(context)
                    .load("http://capefeargardenclub.org/cfgcTestingJSON/images_Testing/images/" + pID + ".jpg")
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.bigImageView);

        } else {
            Log.d(TAG, "onBindViewHolder: photoID is 'null'");
            Glide.with(context)
                    .load(R.drawable.carolinayellowjessaminemed1)
                    .apply(RequestOptions.overrideOf(100, 100))
                    .into(holder.mImageView);
            Glide.with(context)
                    .load(R.drawable.carolinayellowjessaminemed1)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.bigImageView);
        }

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.bigImageView.setVisibility(View.VISIBLE);
            }
        });

        holder.bigImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.bigImageView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.contactsFiltered.size();
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            Contacts current;
            String charString = charSequence.toString();
            if (charString.isEmpty()) {
                contactsFiltered = contacts;
            } else {
                ArrayList<Contacts> filteredList = new ArrayList<>();
                for (int i = 0; i < contacts.size(); i++) {
                    current = contacts.get(i);
                    if ((current.getName().toUpperCase().contains(charSequence.toString().toUpperCase()))) {
                        filteredList.add(current);
                    }
                }
                contactsFiltered = filteredList;
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = contactsFiltered;
            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            try {
                contactsFiltered = (ArrayList<Contacts>) results.values;
            } catch(ClassCastException cce) {
                System.out.println(Arrays.toString(cce.getStackTrace()));
            }
            notifyDataSetChanged();
        }
    }
}
