package gr.aueb.softeng.project1809.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import gr.aueb.softeng.project1809.R;
import gr.aueb.softeng.project1809.services.EmailAddress;
import gr.aueb.softeng.project1809.services.EmailMessage;
import gr.aueb.softeng.project1809.services.EmailProviderService;

/**
 * This class implements a Reservation Summarizing Activity.
 */
public class ReservationSummary extends AppCompatActivity implements EmailProviderService {

    gr.aueb.softeng.project1809.services.ECustomConfiguration conf;
    gr.aueb.softeng.project1809.services.ECustomReservation reserv;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_summary);
        ActionBar actionBar = getActionBar();
        conf = (gr.aueb.softeng.project1809.services.ECustomConfiguration)getIntent().getSerializableExtra("EXTRA_CONFIGURATION");
        reserv = (gr.aueb.softeng.project1809.services.ECustomReservation)getIntent().getSerializableExtra("EXTRA_RESERVATION");
        Log.e("INVOK_RESERVATION", reserv.getReservation().toString());
        s1 = getIntent().getStringExtra("EXTRA_USERNAME");
        TextView text1 = (TextView)findViewById(R.id.textView1);
        String s = conf.getname();
        text1.setText(s);
        ImageView image = (ImageView)findViewById(R.id.config_image);
        Drawable dr = getResources().getDrawable(conf.getSummary().getView());
        image.setBackground(dr);
        TextView text2 = (TextView)findViewById(R.id.textView);
        String s2 = reserv.getReport();
        text2.setText(s2);
        Button send = (Button)findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text3 = (EditText)findViewById(R.id.editText2);
                String mail = text3.getText().toString();
                reserv = reserv.confirm(DAO_UI_Adapter.getRES().getDAO(), ReservationSummary.this, new EmailAddress(mail));
                Toast.makeText(ReservationSummary.this , "Success!" , Toast.LENGTH_LONG).show();
            }
        });
        Button reload = (Button)findViewById(R.id.button2);
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationSummary.this, ReservationActivity.class);
                intent.putExtra("EXTRA_CONFIGURATION", conf);
                intent.putExtra("EXTRA_USERNAME", s1);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_contact: {
                Intent intent = new Intent(ReservationSummary.this, ContactActivity.class);
                intent.putExtra("EXTRA_CONFIGURATION", conf);
                intent.putExtra("EXTRA_RESERVATION", reserv);
                startActivity(intent);
                break;
            }
        }
        return false;
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
}
