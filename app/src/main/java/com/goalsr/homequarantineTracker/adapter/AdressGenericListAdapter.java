package com.goalsr.homequarantineTracker.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.goalsr.homequarantineTracker.R;
import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistricDB;
import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistricDB;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Ram
 */

public class AdressGenericListAdapter extends RecyclerView.Adapter<AdressGenericListAdapter.HorizontalViewHolder> implements Filterable {

    public Context mContext;
    ArrayList<ResStaticMasterDistricDB> list;
    ArrayList<ResStaticMasterDistricDB> listmain;

    private String type="";



    private int intColor;
    private OnClickMainView listener;


    public AdressGenericListAdapter(Context mContext, ArrayList<ResStaticMasterDistricDB> list) {
        this.mContext = mContext;
        this.list = list;
        this.listmain = list;
    }

    public void setType(String type){
        this.type=type;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_district, parent, false);
        return new HorizontalViewHolder(view);
    }

    public void addall(ArrayList<ResStaticMasterDistricDB> getVendors) {
        this.list = getVendors;
        this.listmain = getVendors;
        notifyDataSetChanged();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, final int position) {



        if (type.equalsIgnoreCase("dist")){
            holder.txtname.setText("" + list.get(position).getDist_name());
        }else if (type.equalsIgnoreCase("town")){
            holder.txtname.setText("" + list.get(position).getTown_name());
        }else if (type.equalsIgnoreCase("ward")){
            holder.txtname.setText("" + list.get(position).getWord_name());
        }


        holder.llMainFamilly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickMain(position, list.get(position));
            }
        });



    }


    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtname)
        TextView txtname;
        @BindView(R.id.txtrelation)
        TextView txtrelation;
        @BindView(R.id.ll_main_familly)
        LinearLayout llMainFamilly;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnclickListener(OnClickMainView listener) {
        this.listener = listener;
    }

    public interface OnClickMainView {
        void onClickMain(int position, ResStaticMasterDistricDB requestbodyVendor);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    list = listmain;
                } else {
                    ArrayList<ResStaticMasterDistricDB> filteredList = new ArrayList<>();
                    for (ResStaticMasterDistricDB row : listmain) {

                        if (row.getDist_name().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);

                        }
                    }

                    list = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                list = (ArrayList<ResStaticMasterDistricDB>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
