package com.example.project_healthcare_v10.Model.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BodyInfo.BodyInfoItem;
import com.example.project_healthcare_v10.Main.Fragment.Breath.BreathItem;
import com.example.project_healthcare_v10.Main.Fragment.Calories.CaloriesItem;
import com.example.project_healthcare_v10.Main.Fragment.Heart.HeartItem;
import com.example.project_healthcare_v10.Main.Fragment.Period.PeriodItem;
import com.example.project_healthcare_v10.Main.Fragment.Phone.PhoneItem;
import com.example.project_healthcare_v10.Main.Fragment.Sleep.SleepItem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LocalDatabase extends SQLiteOpenHelper {
    public static String DatabaseName = "HealthCare.db";

    public enum Type{HEART,BREATH,CALORIES,SLEEP,PHONE,BODY,PERIOD};
    public LocalDatabase(@Nullable Context context, int version) {
        super(context, DatabaseName, null, version);
    }

    public void init(){
        this.setData("CREATE TABLE IF NOT EXISTS Item(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Data1 TEXT," +
                "Data2 TEXT," +
                "Time TEXT," +
                "Type TEXT)");
    }

    public void saveListData(ArrayList<BaseItem> listData, Type queryType) {
        setData("DELETE FROM Item WHERE Type='"+queryType.toString()+"'");
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO Item VALUES ");

        String type = queryType.toString();
        for (BaseItem item: listData) {
            sqlBuilder.append("(null,").append(item).append(",'").append(type).append("'),");
        }
        String sql = sqlBuilder.toString();
        if(listData.size()>0)
            sql = sql.substring(0,sql.length()-1);
        sql+=";";

        setData(sql);
    }

    public void deleteData() {
        setData("DELETE FROM Item");
    }

    public ArrayList<BaseItem> getListData(Type queryType) {
        ArrayList<BaseItem> listResult = new ArrayList<>();
        Cursor cursor = getData("SELECT * FROM Item WHERE Type='"+queryType.toString()+"'");
        if(cursor.moveToFirst())
            for(;!cursor.isAfterLast();cursor.moveToNext())
            {
                String data1 = cursor.getString(1);
                String data2 = cursor.getString(2);
                String time = cursor.getString(3);
                listResult.add(typeConstructor(queryType,data1,data2,time));
            }
        return listResult;
    }

    private BaseItem typeConstructor(Type queryType, String...data) {
        return queryType == Type.BODY ? new BodyInfoItem(data[0],data[1],LocalDateTime.parse(data[2])):
                queryType == Type.HEART ? new HeartItem(data[0],data[1],LocalDateTime.parse(data[2])):
                        queryType == Type.CALORIES ? new CaloriesItem(data[0],data[1],LocalDateTime.parse(data[2])):
                                queryType == Type.BREATH ? new BreathItem(data[0],data[1],LocalDateTime.parse(data[2])):
                                        queryType == Type.SLEEP ? new SleepItem(data[0],data[1],LocalDateTime.parse(data[2])):
                                                queryType == Type.PERIOD ? new PeriodItem(LocalDateTime.parse(data[2])):
                                                        new PhoneItem(data[0],data[1],LocalDateTime.parse(data[2]));
    }

    //Base method
    private void setData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    private Cursor getData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
