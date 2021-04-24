package com.example.project_healthcare_v10.Main.Fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_healthcare_v10.R;

public abstract class BaseItemFragment extends Fragment implements View.OnClickListener, BaseItemContract.View {

    public BaseItemPresenter presenter;
    public ImageButton imgbtnAdd, imgbtnEdit, imgbtnDelete, imgbtnEval, imgbtnSync, imgbtnGraph;
    public EditText[] etxtItem;
    public LinearLayout[] llItem;
    public TextView[] txtItem;
    public FrameLayout frameList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_item, container, false);

        initView(view);
        initAction();
        initPresenter();
        onCreateViewAppend();
        // Inflate the layout for this fragment
        return view;
    }

    protected abstract void onCreateViewAppend();

    //INIT
    private void initView(View view) {
        etxtItem = new EditText[2];
        llItem = new LinearLayout[2];
        txtItem = new TextView[2];

        imgbtnAdd = (ImageButton) view.findViewById(R.id.imageButtonAdd);
        imgbtnEdit = (ImageButton) view.findViewById(R.id.imageButtonEdit);
        imgbtnDelete = (ImageButton) view.findViewById(R.id.imageButtonDelete);
        imgbtnEval = (ImageButton) view.findViewById(R.id.imageButtonEvaluate);
        imgbtnSync = (ImageButton) view.findViewById(R.id.imageButtonSync);
        imgbtnGraph = (ImageButton) view.findViewById(R.id.imageButtonGraph);

        llItem[0] = (LinearLayout) view.findViewById(R.id.linearLayoutItem1);
        llItem[1] = (LinearLayout) view.findViewById(R.id.linearLayoutItem2);

        txtItem[0] = (TextView) view.findViewById(R.id.textViewItem1);
        txtItem[1] = (TextView) view.findViewById(R.id.textViewItem2);

        etxtItem[0] = (EditText) view.findViewById(R.id.editTextItem1);
        etxtItem[1] = (EditText) view.findViewById(R.id.editTextItem2);
        //etxtItem[2] = (EditText) view.findViewById(R.id.editTextItem2);
        //etxtItem[3] = (EditText) view.findViewById(R.id.editTextItem3);
        //etxtItem[4] = (EditText) view.findViewById(R.id.editTextItem4);
        //etxtItem[5] = (EditText) view.findViewById(R.id.editTextItem5);

        frameList = (FrameLayout) view.findViewById(R.id.frameList);
    }

    private void initAction() {
        imgbtnAdd.setOnClickListener(this);
        imgbtnEdit.setOnClickListener(this);
        imgbtnDelete.setOnClickListener(this);
        imgbtnEval.setOnClickListener(this);
        imgbtnSync.setOnClickListener(this);
        imgbtnGraph.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButtonAdd: presenter.Add();
                break;
            case R.id.imageButtonEdit: presenter.Edit();
                break;
            case R.id.imageButtonDelete: presenter.Delete();
                break;
            case R.id.imageButtonEvaluate: presenter.Evaluate();
                break;
            case R.id.imageButtonSync: presenter.Sync();
                break;
            case R.id.imageButtonGraph: presenter.Graph();
                break;
        }
    }

    protected abstract void initPresenter();

    @Override
    public void setItem(String str, String hint, int indexItem, int drawable_id) {
        llItem[indexItem].setVisibility(View.VISIBLE);
        txtItem[indexItem].setText(str);
        etxtItem[indexItem].setHint(hint);
        if(drawable_id==-1)
            return;
        float desity = getResources().getDisplayMetrics().density;
        Drawable drawable = getResources().getDrawable(drawable_id);
        drawable.setBounds(0,0,(int)Math.round(desity*30),(int)Math.round(desity*30));
        etxtItem[indexItem].setCompoundDrawables(null,null,drawable,null);
    }

    //Action
    public void showMessage(String mess) {
        Toast.makeText(this.getContext(),mess,Toast.LENGTH_SHORT).show();
    }
}