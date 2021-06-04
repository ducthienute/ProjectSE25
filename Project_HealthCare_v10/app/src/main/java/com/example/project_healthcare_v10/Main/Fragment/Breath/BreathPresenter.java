package com.example.project_healthcare_v10.Main.Fragment.Breath;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemAdapter;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemPresenter;
import com.example.project_healthcare_v10.Main.Fragment.Breath.BreathItem;
import com.example.project_healthcare_v10.Model.Database.LocalDatabase;
import com.example.project_healthcare_v10.R;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class BreathPresenter extends BaseItemPresenter {
    @Override
    public void queryData() {
        LocalDatabase db = new LocalDatabase(view.getContext(),1);
        itemAdapter = new BaseItemAdapter(view.getContext(), db.getListData(LocalDatabase.Type.BREATH), R.drawable.breath, -1);
    }

    @Override
    public String[] getType() {
        return new String[]{"Nín Thở"};
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
        return LocalDatabase.Type.BREATH;
    }



    @Override
    public BaseItem newData(LocalDateTime dateTime, Object... data) {
        return new BreathItem(data[0], data[1], dateTime);
    }
}
