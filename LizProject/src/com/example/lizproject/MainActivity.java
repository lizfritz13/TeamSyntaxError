package com.example.lizproject;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.LayoutInflator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
public class MainActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText amt = (EditText) findViewById(R.id.bill_amt);
        final EditText tip = (EditText) findViewById(R.id.bill_per);
        final TextView result = (TextView) findViewById(R.id.res);
 
        Button calc = (Button) findViewById(R.id.button1);
        calc.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                double amount = Double.parseDouble(amt.getText().toString());
                double tip_per = Double.parseDouble(tip.getText().toString());
                double tip_cal = (amount * tip_per) / 100;
                result.setText("Result : " + String.valueOf(tip_cal));
            }
        });
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //@Override
    //public boolean onOptionsItemSelected(MenuItem m)
    //{
    	//int id = item.getItemId();
    	//if(id == R.id.action_settings)
    	//{
    		//return true;
    	//}
    	//return super.onOptionsItemSelected(item);
    //}
 
}