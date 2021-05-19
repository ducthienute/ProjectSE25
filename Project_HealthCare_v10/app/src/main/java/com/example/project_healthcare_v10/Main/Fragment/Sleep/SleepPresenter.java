package com.example.project_healthcare_v10.Main.Fragment.Sleep;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemAdapter;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemPresenter;
import com.example.project_healthcare_v10.Main.Fragment.Sleep.SleepItem;
import com.example.project_healthcare_v10.Model.Database.LocalDatabase;
import com.example.project_healthcare_v10.R;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Random;

public class SleepPresenter extends BaseItemPresenter {

    @Override
    public LocalDatabase.Type getTableName() {
        return LocalDatabase.Type.SLEEP;
    }


    @Override
    public void queryData() {
        LocalDatabase db = new LocalDatabase(view.getContext(),1);
        itemAdapter = new BaseItemAdapter(view.getContext(), db.getListData(getTableName()), R.drawable.sleeping, R.drawable.wake_up);
    }


    @Override
    public String[] getType() {
        return new String[]{"Giấc Ngủ"};
    }

    @Override
    public String getEvaluate(int index, float y) {
        LocalDateTime lct = LocalDateTime.now();
        SleepItem temp = new SleepItem(lct.plusMinutes((long) (y*60*60)),lct,lct);
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
        String[] split_data = data[0].toString().split(" ")[0].split(":");
        int hour = Integer.parseInt(split_data[0]);
        int minute = Integer.parseInt(split_data[1]);
        split_data = data[0].toString().split(" ")[1].split("/");
        int day_of_month = Integer.parseInt(split_data[0]);
        int month = Integer.parseInt(split_data[1]);
        int year = Integer.parseInt(split_data[2]);

        LocalDateTime data1 = LocalDateTime.of(year,month,day_of_month,hour,minute);


        split_data = data[1].toString().split(" ")[0].split(":");
        hour = Integer.parseInt(split_data[0]);
        minute = Integer.parseInt(split_data[1]);
        split_data = data[1].toString().split(" ")[1].split("/");
        day_of_month = Integer.parseInt(split_data[0]);
        month = Integer.parseInt(split_data[1]);
        year = Integer.parseInt(split_data[2]);

        LocalDateTime data2 = LocalDateTime.of(year,month,day_of_month,hour,minute);

        return new SleepItem(data1,data2,data1);
    }

}
