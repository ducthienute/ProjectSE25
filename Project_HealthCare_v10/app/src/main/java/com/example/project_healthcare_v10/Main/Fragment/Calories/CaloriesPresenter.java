package com.example.project_healthcare_v10.Main.Fragment.Calories;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemAdapter;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemPresenter;
import com.example.project_healthcare_v10.Model.Database.LocalDatabase;
import com.example.project_healthcare_v10.R;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class CaloriesPresenter extends BaseItemPresenter {
    @Override
    public void queryData() {
        LocalDatabase db = new LocalDatabase(view.getContext(),1);
        itemAdapter = new BaseItemAdapter(view.getContext(), db.getListData(LocalDatabase.Type.CALORIES), R.drawable.calories, -1);
    }

    @Override
    public String[] getType() {
        return new String[]{"Calories Trong Ngày"};
    }

    @Override
    public String getEvaluate(int index, float y) {
        if(index == 0)
            return newData(LocalDateTime.now(),y,0).getStatus().getEvaluate();
        return newData(LocalDateTime.now(),0,y).getStatus().getEvaluate();
    }



    @Override
    public float getDataDoubt() {
        return 0.7f;
    }

    @Override
    public boolean isDataValid(Object... data) {
        return true;
    }

    @Override
    public boolean isInputValid(Object... data) {
        if (data[0].toString().length() == 0)
            return false;
        return true;
    }

    @Override
    public LocalDatabase.Type getTableName() {
        return LocalDatabase.Type.CALORIES;
    }

    @Override
    public BaseItem newData(LocalDateTime dateTime, Object... data) {
        return new CaloriesItem(data[0], data[1], dateTime);
    }
}
