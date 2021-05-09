package com.example.project_healthcare_v10.Main.Fragment.BodyInfo;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class BodyInfoFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setInputItem("Weight:","kg",0, R.drawable.weight_scale);
        setInputItem("Height:","cm",1, R.drawable.height_ruler);
    }

    @Override
    protected void initPresenter() {

    }

}
