package com.example.project_healthcare_v10.Main.Fragment.Calories;

import android.view.View;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.LineData;

public class CaloriesFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setInputItem("Nạp Vào:","kcal",0, R.drawable.hamburger);
        setInputItem("Đốt Cháy:","kcal",1, R.drawable.exercise);

        etxtItem[0].setText(Controller.getValueFromTemp("Food",getContext()));
        etxtItem[1].setText(Controller.getValueFromTemp("Exercise",getContext()));

        imgbtnAdd.setOnFocusChangeListener((v,isFocus) -> {if(!isFocus) saveTempData();});
        imgbtnDelete.setOnFocusChangeListener((v,isFocus) -> {if(!isFocus) saveTempData();});;
        etxtItem[0].setOnFocusChangeListener((v,isFocus) -> {if(!isFocus) saveTempData();});;
        etxtItem[1].setOnFocusChangeListener((v,isFocus) -> {if(!isFocus) saveTempData();});
    }

    private void saveTempData() {
        String dataFood = etxtItem[0].getText().toString();
        String dataExercise = etxtItem[1].getText().toString();
        Controller.setValueToTemp("Food",(dataFood.length()==0)?0:Float.parseFloat(dataFood),getContext());
        Controller.setValueToTemp("Exercise",(dataExercise.length()==0)?0:Float.parseFloat(dataExercise),getContext());
    }

    @Override
    protected void initPresenter() {
        presenter = new CaloriesPresenter();
        presenter.setView(this);
        presenter.getData(rccVwData);
    }

    @Override
    public void initChart() {
        int[] color = {R.color.red, R.color.purple_700};
        lineCharts[0].setVisibility(View.VISIBLE);
        LineData lineData = new LineData();
        lineData.addDataSet(presenter.getDataLineDataSet(presenter.getType()[0], 0, color[0]));
        lineData.addDataSet(presenter.getRegressionLineDataSet("Tổng Thể", 0, 1, R.color.teal_200));
        lineData.addDataSet(presenter.getRegressionLineDataSet("Gần Đây", 0, 0.25f, R.color.teal_700));
        lineCharts[0].setData(lineData);
        lineCharts[0].setDescription(presenter.newDescription("kcal"));
    }
}
