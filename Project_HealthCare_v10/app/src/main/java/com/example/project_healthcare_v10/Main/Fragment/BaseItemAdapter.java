package com.example.project_healthcare_v10.Main.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;


import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BaseItemAdapter extends RecyclerView.Adapter<BaseItemAdapter.ItemHolder> {
    private Context context;
    public ArrayList<BaseItem> data;
    public ArrayList<Integer> listSelect;
    private int resId_img1, resId_img2;
    private BaseItemPresenter presenter;

    public BaseItemAdapter(Context context, ArrayList<BaseItem> data, int rsId_img1, int rsId_img2) {
        this.context = context;
        this.data = data;
        this.resId_img1 = rsId_img1;
        this.resId_img2 = rsId_img2;
        listSelect = new ArrayList<>();
    }

    public SimpleRegression getDataRegression(int index, float percent)
    {
        SimpleRegression regression = new SimpleRegression(true);
        for (int i = 0, block = (int) (data.size() * percent); i <block; i++) {
            Entry itemEntry = data.get(i).getEntry(index);
            regression.addData(itemEntry.getX(),itemEntry.getY());
        }
        return regression;
    }

    public void setPresenter(BaseItemPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_item, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        BaseItem item = data.get(position);
        holder.setPosition(position);
        holder.setData1(item.getData(0));
        holder.setData2(item.getData(1));
        holder.setTime(item.getTime());
        holder.setStatus(item.getStatus());
        holder.setChecked(listSelect.contains(position));

        if (listSelect.size() > 0 && position == listSelect.get(listSelect.size() - 1))
            holder.setSelect();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private void focusSelect() {
        int indexPosition = listSelect.size() - 1;
        if (indexPosition >= 0) {
            int position = listSelect.get(indexPosition);
            presenter.view.setEditTextData(0, String.valueOf(data.get(position).getData(0)));
            presenter.view.setEditTextData(1, String.valueOf(data.get(position).getData(1)));
            notifyItemChanged(position);
        }
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        int position;
        RelativeLayout rlItem;
        TextView txtVwData1, txtVwData2, txtVwTime, txtVwStatus;
        ImageView imgVwStatus, imgVwData1, imgVwData2;
        CheckBox ckbSelect;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            rlItem = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutItem);

            txtVwData1 = (TextView) itemView.findViewById(R.id.textViewItem1);
            txtVwData2 = (TextView) itemView.findViewById(R.id.textViewItem2);
            txtVwTime = (TextView) itemView.findViewById(R.id.textViewTime);
            txtVwStatus = (TextView) itemView.findViewById(R.id.textViewStatus);

            imgVwStatus = (ImageView) itemView.findViewById(R.id.imageViewStatus);
            imgVwData1 = (ImageView) itemView.findViewById(R.id.imageViewIcon1);
            imgVwData2 = (ImageView) itemView.findViewById(R.id.imageViewIcon2);

            ckbSelect = (CheckBox) itemView.findViewById(R.id.checkBoxSelect);


            if(resId_img1 == -1)
            {
                txtVwData1.setVisibility(View.GONE);
                imgVwData1.setVisibility(View.GONE);
            }
            else
                imgVwData1.setImageResource(resId_img1);

            if(resId_img2 == -1)
            {
                txtVwData2.setVisibility(View.GONE);
                imgVwData2.setVisibility(View.GONE);
            }
            else
                imgVwData2.setImageResource(resId_img2);


            // init view first but not have the position,
            // onCreateViewHolder - > onBindItemHolder (position here)
            itemView.setOnClickListener(v -> {
                int indexPosition = listSelect.indexOf(position);

                if (indexPosition != -1) {
                    ckbSelect.setChecked(false);
                    listSelect.remove(indexPosition);
                    notifyItemChanged(position);
                    presenter.view.setEditTextData(0,"");
                    presenter.view.setEditTextData(1,"");
                } else {
                    ckbSelect.setChecked(true);
                    listSelect.add(position);
                    int indexOldPosition = listSelect.size() - 2;
                    if (indexOldPosition >= 0)
                        notifyItemChanged(listSelect.get(indexOldPosition));
                }
                focusSelect();
            });
        }

        public void setSelect() {
            rlItem.setBackgroundResource(R.color.teal_200);
        }

        public void setChecked(boolean checked) {
            ckbSelect.setChecked(checked);
        }

        public void setData1(Object data) {
            txtVwData1.setText(String.valueOf(data));
        }

        public void setData2(Object data) {
            txtVwData2.setText(String.valueOf(data));
        }

        public void setTime(LocalDateTime date) {
            txtVwTime.setText(date.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yy")));
        }

        public void setBackgroundColor(int resId) {
            rlItem.setBackgroundResource(resId);
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @SuppressLint("SetTextI18n")
        public void setStatus(Status status) {
            txtVwStatus.setText(status.getEvaluate());
            txtVwStatus.setTextColor(ContextCompat.getColor(context, status.getTextColorId()));
            imgVwStatus.setImageResource(status.getImgId());
            rlItem.setBackgroundResource(status.getBgColorId());
        }
    }
}
