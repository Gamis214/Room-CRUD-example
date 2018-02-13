package com.example.gamis214.roomdb_example;

import android.app.Activity;
import android.widget.Toast;

import com.example.gamis214.roomdb_example.DB.DataBase;
import com.example.gamis214.roomdb_example.DB.Tables.Person;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gamis214 on 22/01/18.
 */

public class UiUtils {

    public static final String CONSULT = "consult";
    public static final String INSERT  = "insert";

    public static void getAllPersonsDB(final Activity activity, final UtilsInterfaces interfaces, final String type){
        DataBase.getInstance(activity).getQuerysDao().getAllPerson()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<Person>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Person> people) {
                        switch (type){
                            case CONSULT:
                                interfaces.onFinishConsult(people,type);
                                break;
                            case INSERT:
                                interfaces.onFinishInsert(people);
                                break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        interfaces.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void insertUsers(final List<Person> lstPerson, final Activity activity, final UtilsInterfaces interfaces){
        Single.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                DataBase.getInstance(activity).getQuerysDao().insertList(lstPerson);
                return 0;
            }}) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        interfaces.onFinishInsertPrintData();
                    }

                    @Override
                    public void onError(Throwable e) {
                        interfaces.onError(e);
                    }
                });
    }

    public static void deleteAllUsers(final Activity activity, final UtilsInterfaces interfaces){
        Single.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                DataBase.getInstance(activity).getQuerysDao().deleteAllData();
                return 0;
            }}).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        interfaces.onFinishQuery(integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        interfaces.onError(e);
                    }
                });
    }

}
