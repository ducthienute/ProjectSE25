package com.example.project_healthcare_v10.Main.Fragment.Phone;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.Status;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;

import java.time.LocalDateTime;

public class PhoneItem extends BaseItem {
    private static final Status[][] data = {{
            new Status(0,"Nghiện", " - Bạn là con nghiện điện thoại nặng, nên đi cai nghiện.",R.drawable.bad),
            new Status(1,"Dùng Quá Nhiều", " - Bạn dành thời gian cho điện thoại trong ngày quá nhiều, mắt bạn có dấu hiệu khô, cơ thể stress không muốn vận động, nên dành thời gian cho các hoạt động khác hơn.",R.drawable.warn),
            new Status(2,"Dùng Nhiều", " - Dùng điện thoại nhiều có thể khiến bạn mệt mỏi về mặt tinh thần rất lớn, nên kiềm hãm.",R.drawable.warn),
            new Status(3,"Dùng Vừa Phải", " - Đây là thời đại công nghệ, việc dùng điện thoại nhiều là không thể tránh khỏi, thời gian sử dụng điện thoại của bạn nằm ở mức không quá nhiều.",R.drawable.good),
            new Status(4,"Dùng Ít", " - Bạn dùng điện thoại ít, nên bạn có nhiều thời gian để phát triển mọi mặt của bản thân hơn, cơ thể bạn không bị trì trệ. Tốt",R.drawable.good),
    }};
    private static final int[][] limitLine = {{12,8,4,2}};

    public PhoneItem(Object data1, Object data2, LocalDateTime time) {
        super(data1, data2, time);
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
        return new Entry(Controller.getTimeUntilNow(getTime(),"d"), Float.parseFloat(getData(index).toString()));
    }

    @Override
    public int getIcon() {
        return R.drawable.breath;
    }

    public static String getEvaluate(int index, float data) {
        int i;
        for (i = 0;i<limitLine[0].length && data <= limitLine[index][i]; i++) ;
        return PhoneItem.data[index][i].getEvaluate();
    }
}
