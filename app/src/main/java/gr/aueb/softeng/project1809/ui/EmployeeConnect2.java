package gr.aueb.softeng.project1809.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gr.aueb.softeng.project1809.R;

/**
 * This class implements an Employee Login Activity. v2
 */
public class EmployeeConnect2 extends AppCompatActivity {

    Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_connect2);

        mNextButton = findViewById(R.id.button_connect);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username= (EditText) findViewById(R.id.Username);
                EditText password= (EditText) findViewById(R.id.Password);
                final String username_Str= username.getText().toString();
                final String password_Str= password.getText().toString();
                gr.aueb.softeng.project1809.services.ECustomConnection conn = new  gr.aueb.softeng.project1809.services.ECustomConnection();
                conn = conn.submit(username_Str, password_Str, DAO_UI_Adapter.getEMPL().getDAO());
                if(conn.getConnectionResult()) {
                    gr.aueb.softeng.project1809.domain.Credentials creds = conn.getConnectionData();
                    Log.e("SUCCESS", creds.getUsername());
                    Toast toast = Toast.makeText(EmployeeConnect2.this, "Employee verified!",Toast.LENGTH_LONG);
                    toast.show();

                    Intent intent = new Intent(EmployeeConnect2.this, BuzzerActivity.class);
                    intent.putExtra("EXTRA_EMPLOYEENAME", creds.getUsername());
                    finish();
                    startActivity(intent);
                } else {
                    Log.e("ERROR", "Wrong credentials.");
                    Toast toast = Toast.makeText(EmployeeConnect2.this, "Wrong credentials.",Toast.LENGTH_LONG);
                    toast.show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
    }
}
