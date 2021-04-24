package com.example.project_healthcare_v10.Model.Database;

public interface Database {
    Object openConnection(String connect_string);

    Object chooseDatabase(Object connection);

    Object chooseTable(Object database);

    Object query(Object connection, Object database, Object[] argv);

    void closeConnection(Object connection);
}
