package com.example.project_healthcare_v10.Main.Fragment.Heart;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.Status;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;

import java.time.LocalDateTime;

public class HeartItem extends BaseItem {
    private static final Status[][] data = {{
            new Status(0,"Cao Huyết Áp 3", " - Huyết áp quá cao, có nguy cơ đột quỵ rất cao",R.drawable.bad),
            new Status(1,"Cao Huyết Áp 2", " - Huyết áp cao, có nguy cơ đột quỵ cao",R.drawable.bad),
            new Status(1,"Cao Huyết Áp 1", " - Huyết áp cao, có nguy cơ đột quỵ thấp",R.drawable.bad),
            new Status(2,"Tiền Cao Huyết Áp", " - Huyết áp hơi vượt mức bình thường, cần quan sát kĩ. ",R.drawable.warn),
            new Status(4,"Huyết Áp Tốt", " - Huyết áp bình thường",R.drawable.good),
            new Status(2,"Huyết Áp Thấp", " - Huyết áp thấp",R.drawable.warn)
    },{
            new Status(2,"Nhịp Tim Nhanh", " - Nhịp tim nhanh.",R.drawable.warn),
            new Status(4,"Nhịp Tim Bình Thường", " - Nhịp tim bình thường.",R.drawable.good),
            new Status(2,"Nhịp Tim Chậm", " - Nhịp tim chậm.",R.drawable.warn),
    }};
    private static final int[][] limitLine = {{180,160,140,120,90},{100,60}};

    public HeartItem(Object data1, Object data2, LocalDateTime time) {
        super(data1, data2, time);
    }

    @Override
    public void processStatus() {
        Status status;
        int i;
        float variable;

        for (i = 0, variable = Float.parseFloat(getData(0).toString()); i<limitLine[0].length && variable <= limitLine[0][i]; i++) ;
        status = data[0][i].clone();

        for (i = 0, variable = Float.parseFloat(getData(1).toString()); i<limitLine[1].length && variable <= limitLine[1][i]; i++) ;
        status.merge(data[1][i].clone());

        this.setStatus(status);
    }

    @Override
    public Entry getEntry(int index) {
        return new Entry(Controller.getTimeUntilNow(getTime(),"d"), Float.parseFloat(getData(index).toString()));
    }

    @Override
    public int getIcon() {
        return R.drawable.heart_rate;
    }

    public static String getEvaluate(int index, float data) {
        int i;
        for (i = 0;i<limitLine[0].length && data <= limitLine[index][i]; i++) ;
        return HeartItem.data[index][i].getEvaluate();
    }
}
