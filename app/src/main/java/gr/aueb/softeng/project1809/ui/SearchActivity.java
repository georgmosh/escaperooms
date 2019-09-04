package gr.aueb.softeng.project1809.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import gr.aueb.softeng.project1809.R;
import gr.aueb.softeng.project1809.domain.ECustomer;
import gr.aueb.softeng.project1809.domain.EReservation;
import gr.aueb.softeng.project1809.services.ECustomConfigurationItem;
import gr.aueb.softeng.project1809.services.ECustomReservationItem;
import gr.aueb.softeng.project1809.services.EmailActualProvider;
import gr.aueb.softeng.project1809.services.EmailMessage;
import gr.aueb.softeng.project1809.services.EmailProviderService;

/**
 * This class implements an Escape Room Search Activity.
 */
public class SearchActivity extends AppCompatActivity implements EmailProviderService {

    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        s = getIntent().getStringExtra("EXTRA_ID");
        EditText ID = (EditText)findViewById(R.id.editText2);
        ID.setText(s);
        Button search = (Button)findViewById(R.id.button3);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchDataBase();
                TextView header = (TextView)findViewById(R.id.textView8);
                header.setVisibility(View.VISIBLE);
                TextView text = (TextView) findViewById(R.id.textView7);
                text.setVisibility(View.VISIBLE);
                Button share = (Button)findViewById(R.id.button4);
                share.setVisibility(View.VISIBLE);
            }
        });
        Button share = (Button)findViewById(R.id.button4);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView res = (TextView)findViewById(R.id.textView7);
                String myResRep = res.getText().toString();
                EmailMessage message = new EmailMessage("My Escape Room Reservations!", myResRep);
                sendEmail(message);
            }
        });
        TextView t7 = (TextView) findViewById(R.id.textView7);
        t7.setMovementMethod(new ScrollingMovementMethod());
    }

    public void searchDataBase() {
        TextView res = (TextView)findViewById(R.id.textView7);
        EditText text = (EditText)findViewById(R.id.editText2);
        s = text.getText().toString();
        String rec = "";
        List<ECustomer> customers = DAO_UI_Adapter.getCUST().getDAO().findAll();
        for(ECustomer c: customers) {
            if(s.equals(c.getID())) {
                List<EReservation> rel = c.getReservations();
                if(rel != null) {
                    for (EReservation r : rel) {
                        ECustomReservationItem item = new ECustomReservationItem(r);
                        rec = rec + "• " + item.getReservationInformation() + "\n";
                    }
                    res.setText(rec);
                    break;
                }
            }
        }
        if(rec.equals("")) res.setText("No reservations found!");
    }

    public void sendEmail(EmailMessage message) {
        Log.i("Send email", "");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
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
