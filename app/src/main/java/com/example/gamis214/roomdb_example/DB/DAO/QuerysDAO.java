package com.example.gamis214.roomdb_example.DB.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.gamis214.roomdb_example.DB.Tables.Person;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by gamis214 on 18/01/18.
 */
@Dao
public interface QuerysDAO {

    @Query("SELECT * FROM Person")
    Maybe<List<Person>> getAllPerson();

    @Query("SELECT * FROM Person WHERE id = :idPerson")
    Maybe<Person> getPersonById(int idPerson);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Person person);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<Person> lstPerson);

}
