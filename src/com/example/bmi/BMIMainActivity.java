package com.example.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class BMIMainActivity extends Activity {

	EditText height;
	EditText weight;
	Button calc;
	TextView result;
	RadioButton kc,li;
	String height1;
	String weight1;
	double resultNum;
	Boolean kgButton = false;
	Boolean lbButton = false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmimain);
		
		calc=(Button)findViewById(R.id.button1);
		height=(EditText)findViewById(R.id.editText2);
		weight=(EditText)findViewById(R.id.editText1);
		result=(TextView)findViewById(R.id.textView4);
		kc=(RadioButton)findViewById(R.id.radioButton1);
		li=(RadioButton)findViewById(R.id.radioButton2);
		
		calc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				height1=height.getText().toString();
				weight1=weight.getText().toString();
				
				if (kgButton){
					resultNum=Double.parseDouble(weight1) / ((Double.parseDouble(height1)*0.01)*(Double.parseDouble(height1)*0.01));
					result.setText(String.valueOf(resultNum));
					
				}
				else if (lbButton) {
					Double up=Double.parseDouble(weight1);
					Double down=Double.parseDouble(height1)*Double.parseDouble(height1);
					resultNum=up/down*703;
					result.setText(String.valueOf(resultNum));
				}
			}
		});
		
		
		kc.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

                //handle the boolean flag here. 
                  if(arg1==true){}
                  {         //Do something
                 li.setChecked(false);
                  }
                    //do something else
                  kgButton = true;
            }
        });
		
		
		li.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

                //handle the boolean flag here. 
                  if(arg1==true){}
                  {         //Do something
                 kc.setChecked(false);
                  }
                    //do something else
                  lbButton = true;

            }
        });
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmimain, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
