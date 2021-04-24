package com.example.project_healthcare_v10.Main.Fragment.Breath;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class BreathFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setItem("Breathe in:","s",0, R.drawable.air_in);
        setItem("Breathe out:","s",1, R.drawable.air_out);
    }


    @Override
    protected void initPresenter() {

    }

}
