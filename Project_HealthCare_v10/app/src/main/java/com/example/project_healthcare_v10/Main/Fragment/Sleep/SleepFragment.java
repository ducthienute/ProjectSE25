package com.example.project_healthcare_v10.Main.Fragment.Sleep;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.Main.Fragment.Period.PeriodPresenter;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.LineData;

import java.util.Calendar;

public class SleepFragment extends BaseItemFragment {

    Calendar date;
    public void showDateTimePicker(EditText item) {
        final Calendar currentDate = Calendar.getInstance();
        date = Calendar.getInstance();
        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.set(year, month, dayOfMonth);
                new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        item.setText(hourOfDay+":"+minute + " " + dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();
            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
    }
    @Override
    protected void onCreateViewAppend() {
        setInputItem("Bắt đầu:","hh:mm dd/mm/yyyy",0, R.drawable.sleeping);
        setInputItem("Kết thúc:","hh:mm dd/mm/yyyy",1, R.drawable.wake_up);

        etxtItem[0].setFocusable(false);
        etxtItem[0].setLongClickable(false);
        etxtItem[0].setOnClickListener(v -> showDateTimePicker(etxtItem[0]));

        etxtItem[1].setFocusable(false);
        etxtItem[1].setLongClickable(false);
        etxtItem[1].setOnClickListener(v -> showDateTimePicker(etxtItem[1]));
    }

    @Override
    protected void initPresenter() {
        presenter = new SleepPresenter();
        presenter.setView(this);
        presenter.getData(rccVwData);
    }

    @Override
    public void initChart() {
        LineData lineData = new LineData();
        lineCharts[0].setVisibility(View.VISIBLE);
        lineData.addDataSet(presenter.getDataLineDataSet("Giấc Ngủ",0,R.color.orange));
        lineData.addDataSet(presenter.getRegressionLineDataSet("Tổng Thể",0,1,R.color.teal_200));
        lineData.addDataSet(presenter.getRegressionLineDataSet("Gần Đây",0,0.25f,R.color.teal_700));
        lineCharts[0].setData(lineData);
        lineCharts[0].setDescription(presenter.newDescription("h"));
    }


}
