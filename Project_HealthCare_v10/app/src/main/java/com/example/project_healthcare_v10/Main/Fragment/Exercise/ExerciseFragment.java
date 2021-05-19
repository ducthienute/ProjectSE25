package com.example.project_healthcare_v10.Main.Fragment.Exercise;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project_healthcare_v10.API.NutritionixAPI;
import com.example.project_healthcare_v10.Controller;
import com.example.project_healthcare_v10.R;

public class ExerciseFragment extends Fragment{
    EditText etxtQuery;
    TextView txtCalo, txtData;
    Button btnSearch, btnTransport, btnDelete;
    ImageView imgVwIcon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_request_api,container,false);

        initView(view);
        initAction();
        return view;
    }

    public void initView(View view) {
        imgVwIcon = (ImageView) view.findViewById(R.id.imageViewIcon);
        etxtQuery = (EditText) view.findViewById(R.id.editTextQuery);
        txtCalo = (TextView) view.findViewById(R.id.textViewCalo);
        txtData = (TextView) view.findViewById(R.id.textViewData);
        btnSearch = (Button) view.findViewById(R.id.buttonSearch);
        btnTransport = (Button) view.findViewById(R.id.buttonTransport);
        btnDelete = (Button) view.findViewById(R.id.buttonDelete);

        imgVwIcon.setImageResource(R.drawable.exercise);
        etxtQuery.setHint("Example: 1 hour yoga");
        txtCalo.setHint("Total (kcal)");
    }

    public void initAction() {
        btnSearch.setOnClickListener(v -> {
            if(etxtQuery.getText().toString().length()>0)
                NutritionixAPI.requestExercise(txtCalo,etxtQuery);
            else Toast.makeText(getContext(),"Bạn phải điền thông tin tìm kiếm",Toast.LENGTH_SHORT).show();
        });
        btnTransport.setOnClickListener(v -> {
            try {
                String data = Controller.getValueFromTemp("Exercise",getContext());
                float temp = Float.parseFloat(txtCalo.getText().toString()) +Float.parseFloat(data.length()==0?"0":data);
                Controller.setValueToTemp("Exercise",temp,getContext());
                txtData.setText(Controller.getValueFromTemp("Exercise",getContext()));
            }
            catch (Exception e) {
                Toast.makeText(getContext(),"Chuyển Thất Bại",Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(v -> {
            Controller.setValueToTemp("Exercise",0,getContext());
            txtData.setText(Controller.getValueFromTemp("Exercise",getContext()));
        });
    }
}
