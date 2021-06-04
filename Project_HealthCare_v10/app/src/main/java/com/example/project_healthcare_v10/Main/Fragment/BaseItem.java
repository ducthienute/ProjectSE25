package com.example.project_healthcare_v10.Main.Fragment;

import androidx.annotation.NonNull;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

public class BaseItem {
    private Object[] data;
    private LocalDateTime time;
    private Status status;

    //Constructor
    public BaseItem(Object data1, Object data2, LocalDateTime time) {
        data = new Object[2];
        this.data[0] = data1;
        this.data[1] = data2;
        this.time = time;

        processStatus();
    }

    public BaseItem(String data_str) {
    }

    //Status
    protected void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {return status; }

    //Getter Setter
    public void setData(int index, Object data) {
        this.data[index] = data;
        processStatus();
    }
    public Object getData(int index) {
        return data[index];
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
        processStatus();
    }
    public LocalDateTime getTime() {
        return time;
    }
    protected float getSpecialData() {return 0;}

    protected void processStatus() {}
    protected Entry getEntry(int index) {return new Entry(Controller.getTimeUntilNow(getTime(),"d"),getSpecialData());};
    protected int getIcon(){return R.mipmap.ic_launcher;};

    public String getEvaluate(int index){
        return status.getEvaluate().split("\n")[index];
    }

    @NonNull
    @Override
    public String toString() {
        return "'" + data[0].toString()+"','"+data[1].toString()+"','"+getTime().toString()+"'";
    }
}
