package com.example.project_healthcare_v10.Main.Fragment;

import com.example.project_healthcare_v10.R;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public abstract class BaseItem {
    private Object data1, data2;
    private LocalDateTime time;

    public BaseItem(Object data1, Object data2, LocalDateTime time) {
        this.data1 = data1;
        this.data2 = data2;
        this.time = time;
    }

    public abstract int getStatus();
    public Object getData1() {
        return data1;
    }

    public void setData1(Object data1) {
        this.data1 = data1;
    }

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
