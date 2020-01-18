package de.doender.anki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCalc(View view) {
        TextView tv = (TextView) findViewById(R.id.tvResult);
        EditText p = (EditText) findViewById(R.id.editTextPoints);

        tv.setText(getDistribution(Integer.parseInt(p.getText().toString())));
    }
    private String getDistribution(Integer points) {
        double p40 = points * 0.45;
        double stepsize = (points - p40) / 4;
        String result = "45% : " +  p40 + "\n";
        result = result + "stepsize : " + stepsize + "\n";
        for (int i=1;i<6;i++) {
            result = result + i + " : " + (points - (i * stepsize)) + "\n" ;
        }
        result = result + "6 : 0";
        return result;
    }
}
