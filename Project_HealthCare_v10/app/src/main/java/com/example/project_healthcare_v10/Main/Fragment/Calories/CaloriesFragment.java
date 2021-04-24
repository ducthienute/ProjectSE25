package com.example.project_healthcare_v10.Main.Fragment.Calories;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class CaloriesFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setItem("Calo in:","kcal",0, R.drawable.hamburger);
        setItem("Calo burn:","kcal",1, R.drawable.calo);
    }


    @Override
    protected void initPresenter() {

    }

}
