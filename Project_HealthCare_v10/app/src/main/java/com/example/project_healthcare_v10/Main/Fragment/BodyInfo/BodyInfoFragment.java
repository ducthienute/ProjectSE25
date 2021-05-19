package com.example.project_healthcare_v10.Main.Fragment.BodyInfo;

import android.view.View;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.Main.Fragment.Heart.HeartPresenter;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.LineData;

public class BodyInfoFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setInputItem("Cân Nặng:","kg",0, R.drawable.weight_scale);
        setInputItem("Chiều Cao:","cm",1, R.drawable.height_ruler);
    }

    @Override
    protected void initPresenter() {
        presenter = new BodyInfoPresenter();
        presenter.setView(this);
        presenter.getData(rccVwData);
    }

    @Override
    public void initChart() {
        int[] color = {R.color.black,R.color.purple_200};
        for(int i =0 ;i<presenter.getType().length;i++) {
            lineCharts[i].setVisibility(View.VISIBLE);
            LineData lineData = new LineData();
            lineData.addDataSet(presenter.getDataLineDataSet(presenter.getType()[i], i, color[i]));
            lineData.addDataSet(presenter.getRegressionLineDataSet("Tổng Thể", i, 1, R.color.teal_200));
            lineData.addDataSet(presenter.getRegressionLineDataSet("Gần Đây", i, 0.25f, R.color.teal_700));
            lineCharts[i].setData(lineData);
            lineCharts[0].setDescription(presenter.newDescription("BMI"));
        }
    }
}
