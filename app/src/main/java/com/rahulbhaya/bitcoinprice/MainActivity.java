package com.rahulbhaya.bitcoinprice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import data.BitcoinHttpClient;
import data.JSONParser;
import model.Bitcoin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView HyperLink;
    private TextView fifteenM;
    private TextView last;
    private TextView buy;
    private TextView sell;
    Spanned Text;
    Bitcoin bitcoin = new Bitcoin();
    Button btnClickMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // HyperLink = (TextView)findViewById(R.id.textView2);

        //Text = Html.fromHtml("<a href='https://www.coindesk.com/price/'>P</a>");

       // HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
       // HyperLink.setText(Text);
        fifteenM = (TextView) findViewById(R.id.fifteenm);
        last = (TextView) findViewById(R.id.last);
        buy = (TextView) findViewById(R.id.buy);
        sell = (TextView) findViewById(R.id.sell);
        btnClickMe = (Button) findViewById(R.id.button);
        btnClickMe.setOnClickListener(MainActivity.this);
        renderBitcoinData();

    }
    @Override
    public void onClick(View v) {
        renderBitcoinData();
    }
    public void renderBitcoinData(){
        BitcoinTask bitcoinTask = new BitcoinTask();
        bitcoinTask.execute();
    }

    private class BitcoinTask extends AsyncTask<String, Void, Bitcoin> {
    @Override
        protected Bitcoin doInBackground(String... params){
            String data = new BitcoinHttpClient().getBitcoinData();
            bitcoin = JSONParser.getBitcoinPrice(data);
            Log.v("Data:", Float.toString(bitcoin.getPrice15m()));

            return bitcoin ;
        }
    @Override
        protected void onPostExecute(Bitcoin bitcoin){
            super.onPostExecute(bitcoin);


        fifteenM.setText("$ "+Float.toString(bitcoin.getPrice15m()));
        last.setText("$ "+Float.toString(bitcoin.getLast()));
        buy.setText("$ "+Float.toString(bitcoin.getBuy()));
        sell.setText("$ "+Float.toString(bitcoin.getSell()));
        }
    }
}
