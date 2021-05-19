package com.example.project_healthcare_v10.Main.Fragment.Calories;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.Status;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.Entry;

import java.time.LocalDateTime;

public class CaloriesItem extends BaseItem {
    private static final Status[][] data = {{
            new Status(0,"Quá Nhiều Năng Lượng", " - Năng lượng tổng trong ngày thừa quá nhiều, dễ tạo ra mỡ và gây thừa cân và dẫn tới các tình trạng mỡ trong máu, béo phì," +
                    ".... nên có chế độ ăn và luyện tập hợp lí.",R.drawable.bad),
            new Status(1,"Dư Năng Lượng", " - Năng lượng dư thừa trong ngày, ngày tháng tích luỹ vẫn là mối nguy hại" +
                    " đáng lo, cần kiềm chế nguồn năng lượng nạp vào.",R.drawable.bad),
            new Status(3,"Bình Thường", " - Năng lượng tiêu thụ gần bằng năng lượng nạp vào, bạn có cơ thể cân đối.",R.drawable.good),
            new Status(4,"Mạnh Khoẻ", " - Năng lượng tiêu thụ ít hơn năng lượng nạp vào, bạn có cơ thể đang ngày càng rắn rỏi và mạnh khoẻ.",R.drawable.good),
            new Status(1,"Thiếu Năng Lượng", " - Tổng năng lượng trong ngày ở mức âm, cơ thể bạn đang thiếu thốn năng lượng," +
                    "nếu để tình trạng ở thời gian dài sẽ dẫn đến mệt mỏi, bạn cần ăn uống đầy đủ bữa và chất lượng.",R.drawable.bad),
            new Status(0,"Cực Thiếu Năng Lượng", " - Bạn nên gọi Bác Sĩ và yêu cầu hỗ trợ gấp.",R.drawable.bad),
    }};
    private static final int[][] limitLine = {{1500,500,0,-500,-1500}};

    public CaloriesItem(Object data1, Object data2, LocalDateTime time) {
        super(data1, data2, time);
    }

    @Override
    public Object getData(int index) {
        return getEntry(index).getY();
    }

    @Override
    public void processStatus() {
        Status status;
        int i;
        float variable = Float.parseFloat(getData(0).toString());

        for (i = 0; i<limitLine[0].length && variable <= limitLine[0][i]; i++) ;
        status = data[0][i].clone();
        this.setStatus(status);
    }

    @Override
    public Entry getEntry(int index) {
        float calo_in = Float.parseFloat(super.getData(0).toString());
        float calo_out = Float.parseFloat(super.getData(1).toString()) + 2000;
        return new Entry(Controller.getTimeUntilNow(getTime(),"d"), calo_in-calo_out);
    }

    @Override
    public int getIcon() {
        return R.drawable.calories;
    }

    public static String getEvaluate(int index, float data) {
        int i;
        for (i = 0;i<limitLine[0].length && data <= limitLine[index][i]; i++) ;
        return CaloriesItem.data[index][i].getEvaluate();
    }
}
