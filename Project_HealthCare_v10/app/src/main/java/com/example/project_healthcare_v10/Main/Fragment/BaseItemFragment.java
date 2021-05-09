package com.example.project_healthcare_v10.Main.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.charts.LineChart;

public abstract class BaseItemFragment extends Fragment
        implements View.OnClickListener, BaseItemContract.View {

    public BaseItemPresenter presenter;
    public ImageButton imgbtnAdd, imgbtnEdit, imgbtnDelete, imgbtnEval, imgbtnSave,
            imgbtnChangeShowtype, imgbtnReload, imgbtnEvalAll;
    public EditText[] etxtItem;
    public LinearLayout[] llItem;
    public TextView[] txtItem;
    public RelativeLayout layoutList;
    public LinearLayout layoutGraph;
    public LineChart[] lineCharts;
    public RecyclerView rccVwData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_item, container, false);

        initView(view);
        initAction();
        initPresenter();
        onCreateViewAppend();
        // Inflate the layout fo
        // r this fragment
        return view;
    }


    //INIT
    private void initView(View view) {
        etxtItem = new EditText[2];
        llItem = new LinearLayout[2];
        txtItem = new TextView[2];
        lineCharts = new LineChart[2];

        //Content
        imgbtnChangeShowtype = (ImageButton) view.findViewById(R.id.imageButtonChangeShowType);
        // ++++ List
        layoutList = (RelativeLayout) view.findViewById(R.id.layoutList);

        imgbtnAdd = (ImageButton) view.findViewById(R.id.imageButtonAdd);
        imgbtnEdit = (ImageButton) view.findViewById(R.id.imageButtonEdit);
        imgbtnDelete = (ImageButton) view.findViewById(R.id.imageButtonDelete);
        imgbtnEval = (ImageButton) view.findViewById(R.id.imageButtonEvaluate);

        llItem[0] = (LinearLayout) view.findViewById(R.id.layoutItem_1);
        llItem[1] = (LinearLayout) view.findViewById(R.id.layoutItem_2);

        txtItem[0] = (TextView) view.findViewById(R.id.textViewItem_1);
        txtItem[1] = (TextView) view.findViewById(R.id.textViewItem_2);

        etxtItem[0] = (EditText) view.findViewById(R.id.editTextItem_1);
        etxtItem[1] = (EditText) view.findViewById(R.id.editTextItem_2);

        // ++++ Graph
        layoutGraph = (LinearLayout) view.findViewById(R.id.layoutGraph);
        imgbtnSave = (ImageButton) view.findViewById(R.id.imageButtonSave);
        imgbtnReload = (ImageButton) view.findViewById(R.id.imageButtonReload);
        imgbtnEvalAll = (ImageButton) view.findViewById(R.id.imageButtonEvaluateAll);

        lineCharts[0] = (LineChart) view.findViewById(R.id.lineChart1);
        lineCharts[1] = (LineChart) view.findViewById(R.id.lineChart2);

        rccVwData = (RecyclerView) view.findViewById(R.id.recyclerViewList);
    }

    public void initChart(int index) {
        //lineChart[index].setOnChartGestureListener(this);
        //lineChart[index].setOnChartValueSelectedListener(this);

        lineCharts[index].setDragEnabled(true);
        lineCharts[index].setScaleEnabled(true);
    }

    private void initAction() {
        imgbtnAdd.setOnClickListener(this);
        imgbtnEdit.setOnClickListener(this);
        imgbtnDelete.setOnClickListener(this);
        imgbtnEval.setOnClickListener(this);
        imgbtnSave.setOnClickListener(this);
        imgbtnChangeShowtype.setOnClickListener(this);
        imgbtnReload.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButtonAdd: presenter.Add(etxtItem[0].getText(), etxtItem[1].getText());
                break;
            case R.id.imageButtonEdit: presenter.Edit(etxtItem[0].getText(), etxtItem[1].getText());
                break;
            case R.id.imageButtonDelete: presenter.Delete();
                break;
            case R.id.imageButtonEvaluate: presenter.Evaluate();
                break;
            case R.id.imageButtonSave: presenter.Save();
                break;
            case R.id.imageButtonEvaluateAll: presenter.EvaluateAll();
                break;
            case R.id.imageButtonChangeShowType:
                if(layoutList.getVisibility() == View.VISIBLE)
                {
                    layoutList.setVisibility(View.GONE);
                    layoutGraph.setVisibility(View.VISIBLE);
                    imgbtnChangeShowtype.setImageResource(R.drawable.note);
                }
                else
                {
                    layoutList.setVisibility(View.VISIBLE);
                    layoutGraph.setVisibility(View.GONE);
                    imgbtnChangeShowtype.setImageResource(R.drawable.graph);
                }
                imgbtnChangeShowtype.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case R.id.imageButtonReload:
                if(layoutList.getVisibility() == View.VISIBLE)
                    presenter.resetList();
                else
                    presenter.resetGraph(lineCharts);
                break;
        }
    }

    protected abstract void initPresenter();

    protected abstract void onCreateViewAppend();

    //Action
    @Override
    public void showMessage(String mess) {
        Toast.makeText(this.getContext(),mess,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void setInputItem(String str, String hint, int indexItem, int drawable_id) {
        llItem[indexItem].setVisibility(View.VISIBLE);
        txtItem[indexItem].setText(str);
        etxtItem[indexItem].setHint(hint);
        if(drawable_id==-1)
            return;
        float desity = getResources().getDisplayMetrics().density;
        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = getResources().getDrawable(drawable_id);
        drawable.setBounds(0,0,(int)Math.round(desity*30),(int)Math.round(desity*30));
        etxtItem[indexItem].setCompoundDrawables(null,null,drawable,null);
    }

    @Override
    public void fillInput(int indexItem, String data) {
        etxtItem[indexItem].setText(data);
    }

    @Override
    public void clearInput() {
        etxtItem[0].setText("");
        etxtItem[1].setText("");
    }


}