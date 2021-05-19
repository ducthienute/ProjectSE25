package com.example.project_healthcare_v10.Main.Fragment.Phone;

import android.view.View;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.Main.Fragment.Breath.BreathPresenter;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.LineData;

public class PhoneFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setInputItem("1 Ngày Dùng:","h",0, R.drawable.phone);
    }

    @Override
    protected void initPresenter() {
        presenter = new PhonePresenter();
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
        lineCharts[0].setDescription(presenter.newDescription("h"));
    }
}
