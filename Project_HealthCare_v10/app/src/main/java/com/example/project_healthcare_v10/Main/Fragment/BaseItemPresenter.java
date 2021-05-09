package com.example.project_healthcare_v10.Main.Fragment;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public abstract class BaseItemPresenter implements BaseItemContract.Presenter {
    public BaseItemContract.View view;
    public BaseItemAdapter itemAdapter;

    public void setView(BaseItemContract.View view) {
        this.view = view;
    }

    public abstract boolean isDataValid(Object... data);
    public abstract BaseItem newData(Object... data);

    //Control
    @Override
    public void Save() {
        view.showMessage("Save");
    }

    @Override
    public void Add(Object... data) {
        if (String.valueOf(data[0]).length() == 0 || String.valueOf(data[1]).length() == 0) {
            view.showMessage("Add Fail, Need to input full information.");
            return;
        }

        if (!isDataValid(data[0], data[1])) {
            view.showMessage("Add Fail, Need to input right information.");
            return;
        }

        itemAdapter.data.add(0,newData(data[0],data[1]));
        itemAdapter.notifyDataSetChanged();
        view.showMessage("Add Success");
    }

    @Override
    public void Edit(Object... data) {
        if(itemAdapter.listSelect.size() == 0){
            view.showMessage("Edit Fail, Need to select an item first");
            return;
        }

        if (String.valueOf(data[0]).length() == 0 || String.valueOf(data[1]).length() == 0) {
            view.showMessage("Edit Fail, Need to input full information.");
            return;
        }

        if (!isDataValid(data[0], data[1])) {
            view.showMessage("Edit Fail, Need to input right information.");
            return;
        }

        //Use toString because of if not, it will use Address so the item will duplicate
        int index = itemAdapter.listSelect.get(itemAdapter.listSelect.size() - 1);
        itemAdapter.data.set(index,newData(data[0].toString(),data[1].toString()));
        itemAdapter.notifyDataSetChanged();
        view.showMessage("Edit Success");
    }

    @Override
    public void Delete() {
        if(itemAdapter.listSelect.size() == 0){
            view.showMessage("Delete Fail, Need to select items first");
            return;
        }

        itemAdapter.data.removeIf(n->itemAdapter.listSelect.contains(itemAdapter.data.indexOf(n)));
        itemAdapter.listSelect.clear();
        itemAdapter.notifyDataSetChanged();
        view.showMessage("Delete Success");
    }

    @Override
    public void resetList() {
        itemAdapter.listSelect.clear();
        itemAdapter.notifyDataSetChanged();
        view.clearInput();
    }
    @Override
    public void resetGraph(LineChart...lineCharts) {
        lineCharts[0].fitScreen();
        lineCharts[0].notifyDataSetChanged();
        lineCharts[0].invalidate();
        if(lineCharts.length>1) {
            lineCharts[1].fitScreen();
            lineCharts[1].notifyDataSetChanged();
            lineCharts[1].invalidate();
        }
    }

    @Override
    public LineData formatDataToLineChart(String dataName, int index, int color) {
        ArrayList<Entry> value = new ArrayList<>();
        float time = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        for (BaseItem item: itemAdapter.data) {
            float y = Integer.parseInt(index == 0 ? item.getData1().toString():item.getData2().toString());
            float x = (item.getTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()- time)/(24*60*60*1000);
            value.add(new Entry(x,y));
        }

        LineDataSet dataSet = new LineDataSet(value,dataName);
        dataSet.setFillAlpha(110);
        dataSet.setLineWidth(2f);
        dataSet.setColor(ContextCompat.getColor(view.getContext(),color));

        return new LineData(dataSet);
    }

    //Action
    @Override
    public void getData(RecyclerView rccVwMain, int data) {
        queryData();

        rccVwMain.setAdapter(itemAdapter);
        itemAdapter.setPresenter(this);
        rccVwMain.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    public abstract void queryData();
}
