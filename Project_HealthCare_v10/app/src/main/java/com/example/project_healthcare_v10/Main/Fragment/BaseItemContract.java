package com.example.project_healthcare_v10.Main.Fragment;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project_healthcare_v10.Model.Database.LocalDatabase;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.apache.commons.math3.geometry.euclidean.twod.Line;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface BaseItemContract {
    interface View {
        Context getContext();
        void setInputItem(String str, String hint, int indexItem, int drawable_id);
        void showMessage(String mess);
        void showDialog(String title, int icon,String mess);
        void setEditTextData(int index, String data);
        Object getItem(int index);
        LineChart[] getCharts();
        void initChart();
    }
    interface Presenter {
        void Add(Object...data);
        void Edit(Object...data);
        void Delete();
        void Evaluate();
        void EvaluateAll();
        void Save();
        void getData(RecyclerView rccView);
        LocalDatabase.Type getTableName();
        void resetList();

        BaseItem newData(LocalDateTime dateTime, Object... data);

        void fitGraph();

        LineDataSet getDataLineDataSet(String dataName,int index, int color);
        LineDataSet getRegressionLineDataSet(String dataName, int index, float percent, int color);
    }
}
