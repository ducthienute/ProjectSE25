package com.example.project_healthcare_v10.Main.Fragment.Breath;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.Status;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;

import java.time.LocalDateTime;

public class BreathItem extends BaseItem {
    private static final Status[][] data = {{
            new Status(4,"Phổi khoẻ manh", " - Nín hơi hơn 30s, phổi bạn rất khoẻ mạnh.",R.drawable.good),
            new Status(3,"Bình Thường", " - Nín hơi trên 20s, bạn có một lá phổi bình thường, không có vấn đề bệnh tật đáng lo.",R.drawable.warn),
            new Status(2,"Kém", " - Bạn nín thở không được lâu, chứng tỏ chức năng tim, phổi có vấn đề, do vậy cần đặc biệt chú ý.",R.drawable.bad),
    }};
    private static final int[][] limitLine = {{30,20}};

    public BreathItem(Object data1, Object data2, LocalDateTime time) {
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
        return BreathItem.data[index][i].getEvaluate();
    }
}
