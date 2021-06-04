package com.example.project_healthcare_v10.Main.Fragment.Period;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.Status;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;

import java.time.LocalDateTime;

public class PeriodItem extends BaseItem {
    private static final Status[][] data = {{
            new Status(0,"Kì Kinh Quá Dài", " - Kì kinh cách nhau lớn hơn 2 tháng",R.drawable.bad),
            new Status(1,"Kì Kinh Dài", " - Kì kinh cách nhau lớn hơn 36 ngày. ",R.drawable.warn),
            new Status(3,"Kì Kinh Bình Thường", " - Kì Kinh Bình Thường",R.drawable.good),
            new Status(2,"Kì Kinh Ngắn", " - Huyết áp hơi vượt mức bình thường, cần quan sát kĩ. ",R.drawable.warn)
    }};
    private static final int[][] limitLine = {{60,36,25}};

    public PeriodItem(LocalDateTime time) {
        super(0,0,time);
    }

    @Override
    public void processStatus() {
        Status status;
        int i;
        float variable;

        for (i = 0, variable = Float.parseFloat(getData(0).toString()); i<limitLine[0].length && variable <= limitLine[0][i]; i++) ;
        status = data[0][i].clone();

        this.setStatus(status);
    }

    @Override
    public Entry getEntry(int index) {
        return new Entry(Controller.getTimeUntilNow(getTime(),"d"),Integer.parseInt(getData(index).toString()));
    }

    @Override
    public int getIcon() {
        return R.drawable.woman_blood;
    }
}
