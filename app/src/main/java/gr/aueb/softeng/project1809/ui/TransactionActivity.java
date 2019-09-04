package gr.aueb.softeng.project1809.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import gr.aueb.softeng.project1809.R;
import gr.aueb.softeng.project1809.dao.WebBankingAPI;
import gr.aueb.softeng.project1809.dao.WebBankingStubAPI;
import gr.aueb.softeng.project1809.services.CardStubReaderService;
import gr.aueb.softeng.project1809.services.CreditCard;
import gr.aueb.softeng.project1809.services.ECustomTransaction;

/**
 * This class implements a Transaction Activity.
 */
public class TransactionActivity extends AppCompatActivity {

    gr.aueb.softeng.project1809.services.ECustomPayment payment;
    Button confirm, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        payment = (gr.aueb.softeng.project1809.services.ECustomPayment)getIntent().getSerializableExtra("EXTRA_PAYMENT");

        EditText api = (EditText)findViewById(R.id.editText10);
        api.setEnabled(false);
        EditText value = (EditText)findViewById(R.id.editText2);
        String val = payment.getReservation().getEscapeRoom().getPrice().getValue() + "";
        value.setText(val);
        value.setEnabled(false);
        TextView currency = (TextView)findViewById(R.id.textView11);
        String cur = payment.getReservation().getEscapeRoom().getPrice().getCurrency() + "";
        currency.setText(cur);
        confirm = (Button)findViewById(R.id.button);
        confirm.setEnabled(false);
        submit = (Button)findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText code = (EditText)findViewById(R.id.editText3);
                String cardCode = code.getText().toString();
                EditText name = (EditText)findViewById(R.id.editText4);
                String cardName = name.getText().toString();
                EditText date = (EditText)findViewById(R.id.editText5);
                String strExpDate = date.getText().toString();
                String[] tokExpDate = strExpDate.split("/");
                int arg1 = Integer.parseInt(tokExpDate[2]);
                int arg2 = Integer.parseInt(tokExpDate[1]);
                int arg3 = Integer.parseInt(tokExpDate[0]);
                Date cardExpDate = new Date(arg1, arg2, arg3);
                CreditCard card = new CreditCard(cardCode, cardName, cardExpDate);
                payment.getTransaction().getCurrentPayment(new WebBankingStubAPI(), new CardStubReaderService(), card);
                submit.setEnabled(false);
                confirm.setEnabled(true);
                String report = payment.getTransaction().getReport();
                EditText message = (EditText)findViewById(R.id.editText6);
                message.setText(report);
                message.setMovementMethod(new ScrollingMovementMethod());
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ECustomTransaction transaction;
                transaction = payment.getTransaction().setPaymentDetails(DAO_UI_Adapter.getPAY().getDAO());
                String yeap = transaction.getNotification();
                Toast toast = Toast.makeText(TransactionActivity.this, yeap, Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        });
    }
}
