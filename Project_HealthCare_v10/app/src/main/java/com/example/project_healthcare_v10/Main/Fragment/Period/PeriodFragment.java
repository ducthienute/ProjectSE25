package com.example.project_healthcare_v10.Main.Fragment.Period;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.Main.Fragment.BodyInfo.BodyInfoPresenter;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.Calendar;
import java.util.Date;

public class PeriodFragment extends BaseItemFragment {

    Calendar calendar;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreateViewAppend() {
        setInputItem("Bắt đầu:","dd/mm/yyyy",0, R.drawable.woman_blood);
        etxtItem[0].setFocusable(false);
        etxtItem[0].setLongClickable(false);

        calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                etxtItem[0].setText(dayOfMonth+"/"+(month+1)+"/"+year);
                calendar.set(year,month,dayOfMonth);
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        etxtItem[0].setOnClickListener(v -> datePickerDialog.show());
    }

    @Override
    protected void initPresenter() {
        presenter = new PeriodPresenter();
        presenter.setView(this);
        presenter.getData(rccVwData);
    }

    @Override
    public void initChart() {
        LineData lineData = new LineData();
        lineCharts[0].setVisibility(View.VISIBLE);
        lineData.addDataSet(presenter.getDataLineDataSet("Khoảng Cách Kì Kinh",0,R.color.red));
        lineData.addDataSet(presenter.getRegressionLineDataSet("Tổng Thể",0,1,R.color.teal_200));
        lineData.addDataSet(presenter.getRegressionLineDataSet("Gần Đây",0,0.25f,R.color.teal_700));
        lineCharts[0].setData(lineData);
        lineCharts[0].setDescription(presenter.newDescription("ngày"));
    }


}
