package com.example.project_healthcare_v10.Main.Fragment.Exercise;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class ExerciseFragment extends BaseItemFragment {
    @Override
    protected void onCreateViewAppend() {
        setItem("Exercise:","find exercise",0, R.drawable.exercise);
    }


    @Override
    protected void initPresenter() {

    }
}
