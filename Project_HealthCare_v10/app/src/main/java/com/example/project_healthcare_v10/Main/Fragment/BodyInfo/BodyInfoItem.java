package com.example.project_healthcare_v10.Main.Fragment.BodyInfo;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.Status;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;

import java.time.LocalDateTime;

public class BodyInfoItem extends BaseItem {
    private static final Status[][] data = {{
            new Status(0,"Béo Phì Độ III ", " - Những căn bệnh liên quan đến tim mạch như nhồi máu cơ tim, trụy tim,… sẽ thực sự xuất hiện ở cấp độ này. Cần liên hệ bác sĩ nhanh để tìm ra phương pháp khắc phục.",R.drawable.bad),
            new Status(1,"Béo Phì Độ II", " - Nguy cơ hình thành các bệnh liên quan tới tim mạch, huyết áp cao, tiểu đường đối với những người bệnh này là rất lớn. Cần có một chế độ sinh hoạt khắt khe để kiềm chế lại.",R.drawable.bad),
            new Status(1,"Béo Phì Độ I", " - Đã có các triệu chứng nguy hiểm, cần phải kiểm soát cân nặng, có chế độ sinh hoạt tốt để ổn định sức khoé.",R.drawable.bad),
            new Status(2,"Thừa Cân", " - Cần ăn uống lành mạnh, tránh đồ nhiều dầu mỡ để giữ cơ thể khoẻ mạnh hơn. ",R.drawable.warn),
            new Status(3,"Bình Thường", " - Cơ thể lành mạnh, phát triển tốt.",R.drawable.good),
            new Status(2,"Gầy Độ I", " - Cơ thể thiếu cân, người yếu, cần ăn uống đủ bữa, thêm các bữa xế, sử dụng các thực phẩm giúp tăng cân an toàn.",R.drawable.warn),
            new Status(1,"Gầy Độ II", " - Gầy độ 2",R.drawable.bad),
            new Status(0,"Gầy Độ III", " - Gầy độ 3",R.drawable.bad),
    }};
    private static final float[][] limitLine = {{40f,35f,30f,25f,18.5f,17f,16f}};

    public BodyInfoItem(Object data1, Object data2, LocalDateTime time) {
        super(data1, data2, time);
    }

    @Override
    public void processStatus() {
        Status status;
        int i;
        float variable;

        for (i = 0, variable = (float) getData(2); i<limitLine[0].length && variable <= limitLine[0][i]; i++) ;
        status = data[0][i].clone();

        this.setStatus(status);
    }

    public Object getData(int index) {
        if(index == 2)
            return getBMI(Float.parseFloat(getData(0).toString()),Float.parseFloat(getData(1).toString()));
        return Float.parseFloat(super.getData(index).toString());
    }

    @Override
    public Entry getEntry(int index) {
        float w = Float.parseFloat(getData(0).toString());
        float h = Float.parseFloat(getData(1).toString());
        return new Entry(Controller.getTimeUntilNow(getTime(),"d"),getBMI(w,h));
    }

    @Override
    public int getIcon() {
        return R.drawable.man;
    }

    public static float getBMI(float w, float h) {
        return (float) (w/Math.pow(h/100,2));
    }

    public static String getEvaluate(float data) {
        int i;
        for (i = 0;i<limitLine[0].length && data <= limitLine[0][i]; i++) ;
        return BodyInfoItem.data[0][i].getEvaluate();
    }
}
