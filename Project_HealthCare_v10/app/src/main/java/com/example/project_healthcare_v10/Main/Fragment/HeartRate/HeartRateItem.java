package com.example.project_healthcare_v10.Main.Fragment.HeartRate;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;

import java.time.LocalDateTime;

public class HeartRateItem extends BaseItem {
    public HeartRateItem(Object data1, Object data2, LocalDateTime time) {
        super(data1, data2, time);
    }

    @Override
    public int getStatus() {
        int heartRate = Integer.parseInt(getData1().toString());
        return heartRate%5;
    }
}
