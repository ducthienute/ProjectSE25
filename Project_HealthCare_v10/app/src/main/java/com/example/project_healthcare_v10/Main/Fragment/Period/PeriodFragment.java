package com.example.project_healthcare_v10.Main.Fragment.Period;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class PeriodFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setInputItem("Period start:","date",0, R.drawable.woman_blood);
        setInputItem("Period end:","date",1, R.drawable.blood_end);
    }

    @Override
    protected void initPresenter() {

    }

}
