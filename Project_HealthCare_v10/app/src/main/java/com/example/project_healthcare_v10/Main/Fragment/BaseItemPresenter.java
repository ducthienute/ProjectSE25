package com.example.project_healthcare_v10.Main.Fragment;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.Model.Database.LocalDatabase;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class BaseItemPresenter implements BaseItemContract.Presenter {
    public BaseItemContract.View view;
    public BaseItemAdapter itemAdapter;

    public void setView(BaseItemContract.View view) {
        this.view = view;
    }

    public abstract boolean isDataValid(Object... data);
    public abstract boolean isInputValid(Object... data);

    public abstract BaseItem newData(LocalDateTime dateTime, Object... data);

    //QueryData
    public abstract void queryData();
    public void formatData() {};
    @Override
    public void getData(RecyclerView rccVwMain) {
        queryData();
        formatData();

        rccVwMain.setAdapter(itemAdapter);
        itemAdapter.setPresenter(this);
        rccVwMain.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    //Control
    @Override
    public void Save() {
        LocalDatabase db = new LocalDatabase(view.getContext(),1);
        db.saveListData(itemAdapter.data, getTableName());
        view.showMessage("Save");
    }

    @Override
    public void Add(Object... data) {
        if (!isInputValid(data[0], data[1])) {
            view.showMessage("Thêm thất bại, phải điền đầy đủ thông tin.");
            return;
        }

        if (!isDataValid(data[0], data[1])) {
            view.showMessage("Thêm thất bại, phải điền thông tin hợp lí.");
            return;
        }

        itemAdapter.data.add(0, newData(LocalDateTime.now(), data[0], data[1]));
        formatData();
        itemAdapter.notifyDataSetChanged();
        view.showMessage("Thêm thành công.");
    }

    @Override
    public void Edit(Object... data) {
        if (itemAdapter.listSelect.size() == 0) {
            view.showMessage("Sửa thất bại, phải chọn dữ liệu cần sửa trước.");
            return;
        }

        if (String.valueOf(data[0]).length() == 0 || String.valueOf(data[1]).length() == 0) {
            view.showMessage("Sửa thất bại, phải điền đầy đủ thông tin.");
            return;
        }

        if (!isDataValid(data[0], data[1])) {
            view.showMessage("Sửa lỗi, phải điền thông tin đúng hợp lí.");
            return;
        }

        //Use toString because of if not, it will use Address so the item will duplicate
        int index = itemAdapter.listSelect.get(itemAdapter.listSelect.size() - 1);
        itemAdapter.data.set(index, newData(LocalDateTime.now(), data[0], data[1]));
        formatData();
        itemAdapter.notifyDataSetChanged();
        view.showMessage("Sửa thành công.");
    }

    @Override
    public void Delete() {
        if (itemAdapter.listSelect.size() == 0) {
            view.showMessage("Xoá thất bại, cần chọn tập dữ liệu cần xoá");
            return;
        }

        itemAdapter.data.removeIf(n -> itemAdapter.listSelect.contains(itemAdapter.data.indexOf(n)));
        itemAdapter.listSelect.clear();
        itemAdapter.notifyDataSetChanged();
        view.showMessage("Xoá thành công");
    }

    @Override
    public void resetList() {
        itemAdapter.listSelect.clear();
        itemAdapter.notifyDataSetChanged();
        view.setEditTextData(0,"");
        view.setEditTextData(1,"");
    }

    @Override
    public void Evaluate() {
        int lastSelectIndex = itemAdapter.listSelect.size() - 1;
        if(lastSelectIndex < 0)
        {
            view.showMessage("Bạn phải chọn dữ liệu để đánh giá.");
            return;
        }
        BaseItem item = (BaseItem) itemAdapter.data.get(itemAdapter.listSelect.get(lastSelectIndex));
        view.showDialog("Đánh Giá Dựa Trên Thông Số Dữ Liệu",item.getIcon(),item.getStatus().getDescription());
    }

    public String evaluateDegrees(int deg) {
        return " " + ((deg >= 60)?"tăng nhanh": (deg >= 30)?"tăng": (deg > 0)?"tăng chậm":
                (deg==0)? "như cũ":
                        (deg >= -30)?"giảm chậm": (deg >= -60)?"giảm": "giảm nhanh");
    }

    public abstract String[] getType();
    public abstract String getEvaluate(int index, float y);
    public abstract float getDataDoubt();

    @Override
    public void EvaluateAll() {
        StringBuilder evaluate = new StringBuilder();
        String[] Type = getType();
        for(int i = 0;i < view.getCharts().length && view.getCharts()[i].getVisibility() == View.VISIBLE;i++) {
            SimpleRegression data;
            // Tổng thể data
            data = itemAdapter.getDataRegression(i, 1);
            if (data.getRSquare() > getDataDoubt()) {
                evaluate.append("\n****").append(Type[i].toUpperCase()).append("****");
                evaluate.append("\n**Tổng thể:");
                int degree = (int) Math.toDegrees(Math.atan(data.getSlope()));

                int x = Controller.getTimeUntilNow(itemAdapter.data.get(itemAdapter.data.size() - 1).getTime(),"d");
                float y = (float) (x * data.getSlope() + data.getIntercept());
                evaluate.append("\n -Thời điểm bắt đầu: ").append(getEvaluate(i, y));
                evaluate.append("\n -Chiều hướng tổng thể: ").append(Type[i]).append(evaluateDegrees(degree));
            }
            // Gần Đây
            data = itemAdapter.getDataRegression(i, 0.25f);
            if (data.getRSquare() > getDataDoubt()) {
                evaluate.append("\n**Gần đây:");
                int degree = (int) Math.toDegrees(Math.atan(data.getSlope()));
                int x = Controller.getTimeUntilNow(itemAdapter.data.get(0).getTime(),"d");
                float y = (float) (x * data.getSlope() + data.getIntercept());
                evaluate.append("\n -Thời điểm hiện tại: ").append(getEvaluate(i,y));
                evaluate.append("\n -Chiều hướng gần đây: ").append(Type[i]).append(evaluateDegrees(degree));
            }
        }
        String mess = evaluate.toString();
        if(mess.length() == 0)
            mess = "Dữ Liệu Chưa Đủ Để Đánh Giá.";
        view.showDialog("Đánh Giá Tổng Thể",R.drawable.heart_rate,evaluate.toString());
    }

    // Graph
    @Override
    public LineDataSet getDataLineDataSet(String dataName, int index, int color) {
        ArrayList<Entry> value = new ArrayList<>();
        for (BaseItem item : itemAdapter.data) {
            value.add(item.getEntry(index));
        }

        value.sort((o1, o2) ->  Float.compare(o1.getX(), o2.getX()));

        LineDataSet dataSet = new LineDataSet(value, dataName);
        dataSet.setFillAlpha(110);
        dataSet.setLineWidth(2f);
        dataSet.setColor(ContextCompat.getColor(view.getContext(), color));
        dataSet.setDrawCircles(false);

        return dataSet;
    }

    @Override
    public LineDataSet getRegressionLineDataSet(String dataName, int index, float percent, int color) {
        SimpleRegression regression = itemAdapter.getDataRegression(index,percent);
        if(regression.getRSquare() < getDataDoubt())
            return new LineDataSet(null,dataName + "[?]");

        ArrayList<Entry> listEntry = new ArrayList<>();
        double a = regression.getSlope();
        double b = regression.getIntercept();

        int size = itemAdapter.data.size() - 1;
        //Start point

        float x = itemAdapter.data.get((int) (size*percent)).getEntry(index).getX();
        listEntry.add(new Entry(x, (float) (x * a + b)));
        //End Point
        x = itemAdapter.data.get(0).getEntry(index).getX();
        listEntry.add(new Entry(x, (float) (x * a + b)));

        LineDataSet dataSet = new LineDataSet(listEntry, dataName);
        dataSet.setFillAlpha(110);
        dataSet.setLineWidth(3f);
        dataSet.setColor(ContextCompat.getColor(view.getContext(), color));
        dataSet.setDrawCircles(false);

        return dataSet;
    }

    @Override
    public void fitGraph() {
        LineChart[] lineCharts = view.getCharts();
        for (LineChart lineChart:lineCharts)
            lineChart.fitScreen();
    }

    public Description newDescription(String text) {
        Description a = new Description();
        a.setText(text);
        return a;
    }
}
