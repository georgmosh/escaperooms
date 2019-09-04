package gr.aueb.softeng.project1809.ui;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;

import java.io.Serializable;
import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1809.R;
import gr.aueb.softeng.project1809.domain.ECustomer;
import gr.aueb.softeng.project1809.domain.EEmployee;
import gr.aueb.softeng.project1809.ui.Preview_DATA;
import gr.aueb.softeng.project1809.ui.RecyclerViewAdapter;


public class RoomsPreview extends AppCompatActivity implements ItemSelectionListener<Preview_DATA> {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    String s, s1, s2;

    private ArrayList<Preview_DATA> listData = new ArrayList<Preview_DATA>();
    gr.aueb.softeng.project1809.services.ECustomConfiguration conf[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_preview);
        ActionBar actionBar = getActionBar();
        s = getIntent().getStringExtra("EXTRA_USERNAME");
        getCustomerInformation();
        if(s1 == null) getEmployeeInformation();
        TextView text1 = (TextView)findViewById(R.id.textView1);
        text1.setText("Welcome " + s1);

        initActualData();//initRandomData(); //
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(listData);
        recyclerView.setAdapter(adapter);
        adapter.setItemSelectionListener(this);
    }

    private void initActualData() {
        int amt = DAO_UI_Adapter.getESC().getDAO().findAll().size();
        conf = new gr.aueb.softeng.project1809.services.ECustomConfiguration[amt];
        for(int ID = 0; ID < amt; ID++) {
            conf[ID] = new gr.aueb.softeng.project1809.services.ECustomConfiguration();
            conf[ID] = conf[ID].submit(ID, DAO_UI_Adapter.getESC().getDAO());
            conf[ID] = conf[ID].getCurrentConfiguration();
            listData.add(new Preview_DATA(conf[ID].getSummary().getView(),conf[ID].getname(),conf[ID].getdescription()));
            listData.get(ID).setID(ID);
        }
    }

    @Override
    public void onItemSelected(Preview_DATA data) {
        Intent intent = new Intent(RoomsPreview.this, ConfigurationActivity.class);
        intent.putExtra("EXTRA_CONFIGURATION", conf[data.getID()]);
        intent.putExtra("EXTRA_USERNAME", s);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu2, menu2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_reserv: {
                Intent intent = new Intent(RoomsPreview.this, SearchActivity.class);
                intent.putExtra("EXTRA_ID", s2);
                startActivity(intent);
                break;
            } case R.id.toolbar_payments: {
                Intent intent = new Intent(RoomsPreview.this, PaymentActivity.class);
                intent.putExtra("EXTRA_ID", s2);
                startActivity(intent);
                break;
            } case R.id.toolbar_buzzer: {
                Intent intent = new Intent(RoomsPreview.this, EmployeeConnect2.class);
                startActivity(intent);
                break;
            } case R.id.toolbar_billing: {
                Intent intent = new Intent(RoomsPreview.this, EmployeeConnect3.class);
                startActivity(intent);
                break;
            } case R.id.toolbar_statistics: {
                Intent intent = new Intent(RoomsPreview.this, EmployeeConnect4.class);
                intent.putExtra("EXTRA_ID", s2);
                startActivity(intent);
                break;
            }
        }
        return false;
    }

    public void getCustomerInformation() {
        List<ECustomer> customers = DAO_UI_Adapter.getCUST().getDAO().findAll();
        for(ECustomer c: customers) {
            if(s.equals(c.getLoginData().getUsername())) {
                s1 = c.getFirstName();
                s2 = c.getID();
            }
        }
    }

    public void getEmployeeInformation() {
        List<EEmployee> employees = DAO_UI_Adapter.getEMPL().getDAO().findAll();
        for(EEmployee c: employees) {
            if(s.equals(c.getLoginData().getUsername())) {
                s1 = c.getFirstName();
                s2 = null;
            }
        }
    }

    private void initRandomData() {
        listData.add(new Preview_DATA(R.mipmap.example_image,"ESCAPE ROOM ATHENS","This is a greek escape room.This is a greek escape room.This is a greek escape room."));
        listData.add(new Preview_DATA(R.mipmap.example_image,"ESCAPE ROOM LONDON","This is an english escape room.This is an english escape room.."));
        listData.add(new Preview_DATA(R.mipmap.example_image,"ESCAPE ROOM NEW YORK","This is an american escape room.This is an american escape room.This is an american escape room." +
                "This is an american escape room.This is an american escape room."));
        listData.add(new Preview_DATA(R.mipmap.example_image,"ESCAPE ROOM PEKINO1","Made in china."));
        listData.add(new Preview_DATA(R.mipmap.example_image,"ESCAPE ROOM PEKINO2","Made in china."));
        listData.add(new Preview_DATA(R.mipmap.example_image,"ESCAPE ROOM PEKINO3","Made in china."));
        listData.add(new Preview_DATA(R.mipmap.example_image,"ESCAPE ROOM PEKINO4","Made in china."));
        listData.add(new Preview_DATA(R.mipmap.example_image,"ESCAPE ROOM PEKINO5","Made in china."));

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit?")
                .setMessage("Are you sure you want to exit app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
