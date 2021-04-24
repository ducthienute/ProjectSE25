package com.example.project_healthcare_v10.Model;

import com.example.project_healthcare_v10.Model.Database.Database;

public class MongoDB implements Database {
    @Override
    public Object openConnection(String connect_string) {
        return null;
    }

    @Override
    public Object chooseDatabase(Object connection) {
        return null;
    }

    @Override
    public Object chooseTable(Object database) {
        return null;
    }

    @Override
    public Object query(Object connection, Object database, Object[] argv) {
        return null;
    }

    @Override
    public void closeConnection(Object connection) {

    }
}
