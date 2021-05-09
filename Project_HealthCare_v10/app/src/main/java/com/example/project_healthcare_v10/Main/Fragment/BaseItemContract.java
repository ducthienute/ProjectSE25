package com.example.project_healthcare_v10.Main.Fragment;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;

public interface BaseItemContract {
    interface View {
        Context getContext();
        void setInputItem(String str, String hint, int indexItem, int drawable_id);
        void showMessage(String mess);
        void fillInput(int index, String data);
        void clearInput();
    }
    interface Presenter {
        void Add(Object...data);
        void Edit(Object...data);
        void Delete();
        void Evaluate();
        void EvaluateAll();
        void Save();
        void getData(RecyclerView rccView, int data);
        void resetList();
        void resetGraph(LineChart...lineCharts);
        LineData formatDataToLineChart(String dataName,int index, int color);
    }
}
