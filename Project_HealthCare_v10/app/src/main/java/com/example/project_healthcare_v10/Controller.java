package com.example.project_healthcare_v10;

import android.content.Context;
import android.util.Log;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BodyInfo.BodyInfoItem;
import com.example.project_healthcare_v10.Main.Fragment.Breath.BreathItem;
import com.example.project_healthcare_v10.Main.Fragment.Calories.CaloriesItem;
import com.example.project_healthcare_v10.Main.Fragment.Heart.HeartItem;
import com.example.project_healthcare_v10.Main.Fragment.Period.PeriodItem;
import com.example.project_healthcare_v10.Main.Fragment.Phone.PhoneItem;
import com.example.project_healthcare_v10.Main.Fragment.Sleep.SleepItem;
import com.example.project_healthcare_v10.Model.Database.LocalDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Random;

public abstract class Controller {

    private static void setTempData(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("temp.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private static String getTempData(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("temp.txt");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString).append("\n");
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
            setTempData("", context);
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public static String getValueFromTemp(String key, Context context) {
        String data = getTempData(context);
        String split = key + ":";
        String[] split_data = data.split(split);
        if (split_data.length > 1)
            return split_data[1].split(";")[0];
        return "";
    }

    public static void setValueToTemp(String key, float value, Context context) {
        String data = getTempData(context);
        String split = key + ":";
        String[] split_data = data.split(split);
        if (split_data.length > 1) {
            String[] split_value = split_data[1].split(";");
            data = split_data[0] + key + ":" + value + ((split_value.length > 1) ? (";" + split_value[1]) : (";"));
        } else {
            data = data + key + ":" + value + ";";
        }
        setTempData(data, context);
    }

    public static ArrayList<BaseItem> createDataTool(LocalDatabase.Type type) {
        ArrayList<BaseItem> dataTest = new ArrayList<>();
        Random r = new Random();
        switch (type) {
            case BODY:
                for (int i = 0; i <= 100; i++) {
                    int k = (int) (-0.005 * (i - 25) * (i - 25) + 0.5 * (i - 25) + 50);
                    LocalDateTime ldt = LocalDateTime.now();
                    ldt = ldt.plusDays(-i);
                    dataTest.add(new BodyInfoItem(r.nextInt(2) + 25 + k, 170, ldt));
                }
                break;
            case HEART:
                for (int i = 0; i <= 100; i++) {
                    int k = (int) (-0.005 * (i - 25) * (i - 25) + 0.5 * (i - 25) + 50);
                    LocalDateTime ldt = LocalDateTime.now();
                    ldt = ldt.plusDays(-i);
                    dataTest.add(new HeartItem(r.nextInt(2) + 90 + k, r.nextInt(2) + 90 + k, ldt));
                }
                break;
            case CALORIES:
                for (int i = 0; i <= 365; i++) {
                    int k = (int) (-0.01 * (i - 25) * (i - 25) + 0.5 * (i - 25) + 50);
                    LocalDateTime ldt = LocalDateTime.now();
                    ldt = ldt.plusDays(-i);
                    dataTest.add(new CaloriesItem( 1000 + k, 0, ldt));
                }
                break;
            case PHONE:
                for (int i = 0; i <= 100; i++) {
                    LocalDateTime ldt = LocalDateTime.now();
                    ldt = ldt.plusDays(-i);
                    dataTest.add(new PhoneItem(r.nextInt(5) + 10, 0, ldt));
                }
                break;
            case PERIOD:
                for(int i = 0;i <= 120;i++)
                {
                    LocalDateTime ldt = LocalDateTime.now();
                    ldt = ldt.plusMonths(-i);
                    ldt = ldt.plusDays(r.nextInt(2));
                    dataTest.add(new PeriodItem(ldt));
                }
                break;
            case SLEEP:
                for(int i = 0;i <= 120;i++)
                {
                    LocalDateTime ldt = LocalDateTime.now();
                    ldt = ldt.plusDays(-i);
                    SleepItem a = new SleepItem(ldt.plusHours(-r.nextInt(10)),ldt,ldt);
                    dataTest.add(a);
                }
                break;
            case BREATH:
                for (int i = 0; i <= 100; i++) {
                    LocalDateTime ldt = LocalDateTime.now();
                    ldt = ldt.plusDays(-i);
                    dataTest.add(new BreathItem(r.nextInt(10) + 20, 0, ldt));
                }
                break;
        }

        return dataTest;
    }

    public static int getTimeUntilNow(LocalDateTime ldt, String type) {
        int divide_number = type.equals("s") ?1000:
                type.equals("m") ?60000:
                        type.equals("h") ?3600000:
                                type.equals("d") ?86400000:1;
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long time = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return (int) ((time-now)/divide_number);
    }
}
