package gr.aueb.softeng.project1809.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import gr.aueb.softeng.project1809.R;

/**
 * This class implements an Escape Room Configuration Activity.
 */
public class ConfigurationActivity extends AppCompatActivity {

    gr.aueb.softeng.project1809.services.ECustomConfiguration conf;

    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        conf = (gr.aueb.softeng.project1809.services.ECustomConfiguration)getIntent().getSerializableExtra("EXTRA_CONFIGURATION");
        conf = conf.expand();
        String s = conf.getname();
        s1 = getIntent().getStringExtra("EXTRA_USERNAME");
        TextView text1 = (TextView)findViewById(R.id.textView1);
        TextView text2 = (TextView)findViewById(R.id.textViewDet);
        Button modif = (Button)findViewById(R.id.button);
        Button reserv = (Button)findViewById(R.id.button2);
        text1.setText(s);
        ImageView image = (ImageView)findViewById(R.id.config_image);
        Drawable dr = getResources().getDrawable(conf.getSummary().getView());
        image.setBackground(dr);
        String d = conf.getSummary().toString();
        Log.e("EXPANSION", d);
        Log.e("TEXTVIEW", (text2 != null)+"");
        text2.setText(d);
        Log.e("BUTTON", (modif != null)+"");

        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigurationActivity.this, ModificationActivity.class);
                intent.putExtra("EXTRA_CONFIGURATION", conf);
                startActivity(intent);
            }
        });

        reserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfigurationActivity.this, ReservationActivity.class);
                intent.putExtra("EXTRA_CONFIGURATION", conf);
                intent.putExtra("EXTRA_USERNAME", s1);
                startActivity(intent);
            }
        });
    }
}
