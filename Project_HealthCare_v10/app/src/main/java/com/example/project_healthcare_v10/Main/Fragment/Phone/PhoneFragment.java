package com.example.project_healthcare_v10.Main.Fragment.Phone;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class PhoneFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setItem("Time use:","hour",0, -1);
        setItem("and","minute",1, R.drawable.phone);
    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initPresenter() {

    }

}
