package com.example.project_healthcare_v10.Main.Fragment.Period;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemAdapter;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemPresenter;
import com.example.project_healthcare_v10.Model.Database.LocalDatabase;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.LineDataSet;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;

public class PeriodPresenter extends BaseItemPresenter {

    @Override
    public void queryData() {
        LocalDatabase db = new LocalDatabase(view.getContext(),1);
        itemAdapter = new BaseItemAdapter(view.getContext(), db.getListData(LocalDatabase.Type.PERIOD), R.drawable.woman_blood, -1);
    }

    @Override
    public LocalDatabase.Type getTableName() {
        return LocalDatabase.Type.PERIOD;
    }




    @Override
    public String[] getType() {
        return new String[]{"Khoảng Cách Kì Kinh"};
    }

    @Override
    public String getEvaluate(int index, float y) {
        PeriodItem temp = new PeriodItem(LocalDateTime.now());
        temp.setData(index,y);
        return temp.getEvaluate(index);
    }

    @Override
    public float getDataDoubt() {
        return 0;
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
    public BaseItem newData(LocalDateTime dateTime, Object... data) {
        String[] split_data = data[0].toString().split("/");
        int day_of_month = Integer.parseInt(split_data[0]);
        int month = Integer.parseInt(split_data[1]);
        int year = Integer.parseInt(split_data[2]);

        return new PeriodItem(LocalDateTime.of(year,month,day_of_month,0,0,0));
    }
    @Override
    public void formatData() {
        itemAdapter.data.sort((o1,o2)->Integer.compare(Controller.getTimeUntilNow(o2.getTime(),"s"),Controller.getTimeUntilNow(o1.getTime(),"s")));
        int block = itemAdapter.data.size()-1;
        for(int i = 0 ;i< block;i++)
        {
            BaseItem item = itemAdapter.data.get(i);
            item.setData(0, Controller.getTimeUntilNow(item.getTime(),"d")-
                    Controller.getTimeUntilNow(itemAdapter.data.get(i+1).getTime(),"d"));
        }
        BaseItem item = itemAdapter.data.get(block);
        item.setData(0,30);
    }

}
