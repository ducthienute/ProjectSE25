package com.example.project_healthcare_v10.Main.Fragment.BodyInfo;

import android.view.View;
import android.widget.EditText;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class BodyInfoFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setItem("Weight:","kg",0, R.drawable.weight_scale);
        setItem("Height:","cm",1, R.drawable.height_ruler);
    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initPresenter() {

    }

}
