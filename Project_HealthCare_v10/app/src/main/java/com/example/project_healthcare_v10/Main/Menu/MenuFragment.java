package com.example.project_healthcare_v10.Main.Menu;

import android.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.Main.Fragment.BodyInfo.BodyInfoFragment;
import com.example.project_healthcare_v10.Main.Fragment.Breath.BreathFragment;
import com.example.project_healthcare_v10.Main.Fragment.Calories.CaloriesFragment;
import com.example.project_healthcare_v10.Main.Fragment.HeartRate.HeartRateFragment;
import com.example.project_healthcare_v10.Main.Fragment.Phone.PhoneFragment;
import com.example.project_healthcare_v10.Main.Fragment.Sleep.SleepFragment;
import com.example.project_healthcare_v10.Main.MainBar.MainActivity;
import com.example.project_healthcare_v10.R;


public class MenuFragment extends Fragment implements MenuContract.View {

    private MenuPresenter presenter;
    ImageButton imgbtnNews, imgbtnHeartRate, imgbtnBodyInfo;
    ImageButton imgbtnExercise, imgbtnCalor, imgbtnBreath;
    ImageButton imgbtnFood, imgbtnSleep, imgbtnDoctor;
    ImageButton imgbtnPhone, imgbtnWatch, imgbtnPeriod;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        // Inflate the layout for this fragment
        initView(view);
        initAction();
        initPresenter(view);

        return view;
    }

    //INIT
    private void initView(View view) {
        imgbtnNews = (ImageButton) view.findViewById(R.id.imageButtonNews);
        imgbtnHeartRate = (ImageButton) view.findViewById(R.id.imageButtonHeartRate);
        imgbtnBodyInfo = (ImageButton) view.findViewById(R.id.imageButtonBodyInfo);

        imgbtnExercise = (ImageButton) view.findViewById(R.id.imageButtonExercise);
        imgbtnCalor = (ImageButton) view.findViewById(R.id.imageButtonCalories);
        imgbtnBreath = (ImageButton) view.findViewById(R.id.imageButtonBreath);

        imgbtnFood = (ImageButton) view.findViewById(R.id.imageButtonFood);
        imgbtnSleep = (ImageButton) view.findViewById(R.id.imageButtonSleep);
        imgbtnDoctor = (ImageButton) view.findViewById(R.id.imageButtonDoctorContact);

        imgbtnPhone = (ImageButton) view.findViewById(R.id.imageButtonPhoneControl);
        imgbtnWatch = (ImageButton) view.findViewById(R.id.imageButtonSmartWatchConnect);
        imgbtnPeriod = (ImageButton) view.findViewById(R.id.imageButtonPeriod);
    }

    private void initPresenter(View view) {
        presenter = new MenuPresenter();
        presenter.setView(this);
    }

    private void initAction() {
        imgbtnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "testing", Toast.LENGTH_SHORT).show();
            }
        });
        imgbtnHeartRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setFrameContent("your heart",(Fragment) new HeartRateFragment());
            }
        });
        imgbtnBodyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setFrameContent("body info",(Fragment) new BodyInfoFragment());
            }
        });
        // ===================================================================================
        imgbtnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "testing", Toast.LENGTH_SHORT).show();
            }
        });
        imgbtnCalor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setFrameContent("control calories",(Fragment) new CaloriesFragment());
            }
        });
        imgbtnBreath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setFrameContent("control breathe",(Fragment) new BreathFragment());
            }
        });
        // ===================================================================================
        imgbtnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "testing", Toast.LENGTH_SHORT).show();
            }
        });
        imgbtnSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setFrameContent("control sleep time",(Fragment) new SleepFragment());
            }
        });
        imgbtnDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "testing", Toast.LENGTH_SHORT).show();
            }
        });
        // ===================================================================================
        imgbtnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setFrameContent("control phone",(Fragment) new PhoneFragment());
            }
        });
        imgbtnWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "testing", Toast.LENGTH_SHORT).show();
            }
        });
        imgbtnPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setFrameContent("control period",(Fragment) new PhoneFragment());
            }
        });
        // ===================================================================================
    }

}
