package com.example.gamis214.roomdb_example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gamis214 on 22/01/18.
 */

public interface UtilsInterfaces {
    void onFinishInsert(List<?> lst);
    void onFinishConsult(List<?> lst,String type);
    void onFinishInsertPrintData();
    void onFinishQuery(Integer i);
    void onError(Throwable e);
}
