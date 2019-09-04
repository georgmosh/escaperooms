package gr.aueb.softeng.project1809.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1809.R;
import gr.aueb.softeng.project1809.services.EmailAddress;
import gr.aueb.softeng.project1809.services.EmailMessage;
import gr.aueb.softeng.project1809.services.EmailProviderService;
import gr.aueb.softeng.project1809.services.EmailProviderStub;

/**
 * This class implements a Standard Configuration Escape Room Modification Activity.
 */
public class ModificationActivity extends AppCompatActivity implements UIDialogTemplate, EmailProviderService, AdapterView.OnItemSelectedListener {

    gr.aueb.softeng.project1809.services.ECustomConfiguration conf;
    final String[] newFieldValues = new String[5];
    EditText text2, text3, text4, text5, text6;
    String spinner_elem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        conf = (gr.aueb.softeng.project1809.services.ECustomConfiguration)getIntent().getSerializableExtra("EXTRA_CONFIGURATION");
        TextView text1 = (TextView)findViewById(R.id.textView1);
        String s = conf.getname();
        text1.setText(s);
        this.fillIn();
        conf.modify(this);
        ImageView image = (ImageView)findViewById(R.id.config_image);
        Drawable dr = getResources().getDrawable(conf.getSummary().getView());
        image.setBackground(dr);
        Spinner moneyspinner = findViewById(R.id.moneyspinner);
        moneyspinner.setOnItemSelectedListener(this);
        Button send = (Button)findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignNewValues();
                TextView text10 = (EditText)findViewById(R.id.editText10);
                String dest = text10.getText().toString();
                gr.aueb.softeng.project1809.services.EmailAddress to = new gr.aueb.softeng.project1809.services.EmailAddress(dest);
                conf.setModificationEnabled(ModificationActivity.this, to);
                Toast.makeText(ModificationActivity.this , "Success!" , Toast.LENGTH_LONG).show();
            }
        });
        Button reload = (Button)findViewById(R.id.button2);
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillIn();
            }
        });
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("EUR");
        categories.add("USD");
        categories.add("GBP");
        categories.add("JPY");
        categories.add("CHF");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        moneyspinner.setAdapter(dataAdapter);
    }

    public void sendEmail(EmailMessage message) {
        Log.i("Send email", "");
        String s1 = message.getTo().getAddress();
        String[] TO = {""}; TO[0] = s1;
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, message.getSubject());
        emailIntent.putExtra(Intent.EXTRA_TEXT, message.getBody());
        emailIntent.setType("message/rfc822");

        try {
            startActivity(Intent.createChooser(emailIntent, "Select your preferred Mail Service."));
            //finish();
            Log.i("Finished", " sending email...");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void fillIn() {
        text2 = (EditText)findViewById(R.id.editText2);
        text2.setText(conf.getconfiguredEscapeRoom().getPrice().getValue() + "");
        text3 = (EditText)findViewById(R.id.editText3);
        text3.setText(conf.getconfiguredEscapeRoom().getDifficulty()+"");
        text4 = (EditText)findViewById(R.id.editText4);
        text4.setText(conf.getconfiguredEscapeRoom().getDuration() + "");
        text5 = (EditText)findViewById(R.id.editText5);
        text5.setText(conf.getconfiguredEscapeRoom().getCapacity()+"");
        text6 = (EditText)findViewById(R.id.editText6);
        text6.setText("");
    }

    public void assignNewValues() {
        text2 = (EditText)findViewById(R.id.editText2);
        newFieldValues[0] = text2.getText().toString() + " " + spinner_elem;
        text3 = (EditText)findViewById(R.id.editText3);
        newFieldValues[1] = text3.getText().toString();
        text4 = (EditText)findViewById(R.id.editText4);
        newFieldValues[2] = text4.getText().toString();
        text5 = (EditText)findViewById(R.id.editText5);
        newFieldValues[3] = text5.getText().toString();
        text6 = (EditText)findViewById(R.id.editText6);
        newFieldValues[4] = text6.getText().toString();
        for(int i = 0; i < 5; i++) Log.e("VALUE "+i, newFieldValues[i]);
    }

    @Override
    public String[] getFurtherDetails() {
        return newFieldValues;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinner_elem = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}