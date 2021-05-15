package com.example.project_healthcare_v10.Main.MainBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_healthcare_v10.Login.LoginActivity;
import com.example.project_healthcare_v10.Main.Menu.MenuFragment;
import com.example.project_healthcare_v10.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    TextView txtTitle;
    ImageView imgvwIcon, imgvwSetting;
    FrameLayout frameContent;
    MainPresenter presenter;
    FragmentManager fragmentManager;

    @Override
    public void onBackPressed() {
        if(txtTitle.getText().toString().equals("menu"))
            finishAffinity();
        setFrameContent("menu",(Fragment) new MenuFragment());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initPresenter();
        initAction();
    }


    //INIT
    public void initView() {
        txtTitle = (TextView) findViewById(R.id.textViewTitle);
        imgvwIcon = (ImageView) findViewById(R.id.imageViewIcon);
        imgvwSetting = (ImageView) findViewById(R.id.imageViewSetting);
        frameContent = (FrameLayout) findViewById(R.id.frameContent);

        fragmentManager = getFragmentManager();
        setFrameContent("menu",(Fragment) new MenuFragment());
    }

    public void initPresenter() {
        presenter = new MainPresenter();
        presenter.setView(this);
    }

    public void initAction() {
        imgvwIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFrameContent("MENU",(Fragment) new MenuFragment());
            }
        });

        imgvwSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettingMenu();
            }
        });
    }

    private void showSettingMenu() {
        PopupMenu popupMenu = new PopupMenu(this, imgvwSetting);
        popupMenu.getMenuInflater().inflate(R.menu.menu_personal_info, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemPersonalInfo:
                        break;
                    case R.id.itemSetting:
                        break;
                    case R.id.itemLogOut:
                        finish();
                        break;
                    case R.id.itemExit:
                        finishAffinity();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    //FRAGMENT
    public void setFrameContent(String name,Fragment fragment) {
        if(name.length()>0)
            txtTitle.setText(name);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContent, (Fragment) fragment);
        fragmentTransaction.commit();
    }
}