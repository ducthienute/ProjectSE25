package com.example.project_healthcare_v10.Main.Fragment.Food;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class FoodFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setInputItem("Food:","find food", 0, R.drawable.vegetable);
    }


    @Override
    protected void initPresenter() {

    }
}
