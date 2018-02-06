package com.example.gamis214.roomdb_example;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gamis214.roomdb_example.DB.Tables.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UtilsInterfaces{

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private List<Person> lstperson = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar         = findViewById(R.id.toolbar);
        recyclerView    = findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getAllUserFromDB();
    }

    private void populateListPerson(){
        lstperson.add(new Person("Gama","adez","19-12","10"));
        lstperson.add(new Person("Pepe","bdez","19-12","20"));
        lstperson.add(new Person("Jose","cdez","19-12","30"));
        lstperson.add(new Person("Fco","ddez","19-12","40"));
        lstperson.add(new Person("Toño","edez","19-12","50"));
        lstperson.add(new Person("Chole","fdez","19-12","60"));
        lstperson.add(new Person("Omar","gdez","19-12","70"));
        lstperson.add(new Person("Martin","hdez","19-12","80"));
        lstperson.add(new Person("Gallardo","idez","19-12","90"));
        lstperson.add(new Person("Jose","jdez","19-12","10"));
        UiUtils.insertUsers(lstperson,this,this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnInsertar:
                Toast.makeText(this, "a", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnActulizar:
                Toast.makeText(this, "b", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnBorrar:
                Toast.makeText(this, "c", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnBorrarTodo:
                Toast.makeText(this, "d", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }


    @Override
    @SuppressWarnings("unchecked")
    public void onFinish(Object obj) {
        if(obj instanceof Throwable){
            Throwable e = (Throwable) obj;
            e.printStackTrace();
        }else if (obj instanceof ArrayList<?>){
            List<Person> lstPerson = (List<Person>) obj;
            if(lstPerson.size() > 0)
                populateRecyclerView(lstPerson);
            else
                populateListPerson();
        } else if(obj instanceof Integer){
            getAllUserFromDB();
        }
    }

    private void populateRecyclerView(List<Person> lstPerson) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new CustomAdapter(lstPerson));
    }

    public void getAllUserFromDB(){
        UiUtils.getAllPersonsDB(this,this);
    }
}
