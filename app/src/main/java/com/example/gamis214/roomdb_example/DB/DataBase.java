package com.example.gamis214.roomdb_example.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.gamis214.roomdb_example.DB.DAO.QuerysDAO;
import com.example.gamis214.roomdb_example.DB.Tables.Person;

/**
 * Created by gamis214 on 18/01/18.
 */
@Database(entities = {Person.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    private static final String DB_NAME = "repoDatabase.db";
    private static volatile DataBase instance;

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static DataBase create(final Context context) {
        return Room.databaseBuilder(
                context,
                DataBase.class,
                DB_NAME).build();
    }

    public abstract QuerysDAO getQuerysDao();

}
