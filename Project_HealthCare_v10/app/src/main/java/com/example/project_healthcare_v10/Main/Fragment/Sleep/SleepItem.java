package com.example.project_healthcare_v10.Main.Fragment.Sleep;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.Status;
import com.example.project_healthcare_v10.Model.Database.LocalDatabase;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class SleepItem extends BaseItem {
    private static final Status[][] data = {{
            new Status(1,"Ngủ Li Bì", " - Ngủ quá nhiều, bạn dễ cảm thấy mệt mỏi trong giờ bình thường, nên gọi bác sĩ tư vấn",R.drawable.bad),
            new Status(2,"Giấc Ngủ Dài", " - Giấc ngủ dài, nhưng cũng tốt sau khi trải qua 1 khoảng thời gian mệt mỏi ",R.drawable.warn),
            new Status(3,"Ngủ Đủ Giấc", " - Giấc ngủ có chất lượng tốt",R.drawable.good),
            new Status(2,"Thiếu Ngủ", " - Bạn cần ngủ thêm để đảm bảo cơ thể không trở nên mệt mỏi, thiếu thốn năng lượng.",R.drawable.good),
    }};
    private static final int[][] limitLine = {{16,10,6}};

    public SleepItem(Object data1, Object data2, LocalDateTime time) {
        super(data1, data2, time);
    }

    @Override
    public Object getData(int index) {
        LocalDateTime ldt = (LocalDateTime)super.getData(index);
        return ldt.getHour()+":"+ldt.getMinute() +" " +ldt.getDayOfMonth()+"/"+ldt.getMonthValue();
    }

    @Override
    public void processStatus() {
        Status status;
        int i;
        float variable;

        for (i = 0, variable = getEntry(0).getY(); i<limitLine[0].length && variable <= limitLine[0][i]; i++) ;
        status = data[0][i].clone();

        this.setStatus(status);
    }

    @Override
    public Entry getEntry(int index) {
        long i = Controller.getTimeUntilNow(LocalDateTime.parse(super.getData(1).toString()),"d")-
                Controller.getTimeUntilNow(LocalDateTime.parse(super.getData(0).toString()),"d");
        return new Entry(Controller.getTimeUntilNow(getTime(),"d"),i);
    }

    @Override
    public int getIcon() {
        return R.drawable.sleep;
    }
}
