package com.coreelements.ihnn;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionAdd extends ActionBarActivity implements View.OnClickListener {

    EditText aq_et;
    TextView aq_tv;

    private SharedPreferences speicher;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_questionadd);

        aq_et = (EditText)findViewById(R.id.addquestion_et);

        aq_tv = (TextView)findViewById(R.id.addquestion_tv);
        aq_tv.setOnClickListener(this);

        speicher = getApplicationContext().getSharedPreferences("Daten", 0);
        editor = speicher.edit();
    }

    @Override
    public void onClick(View v) {
        Textspeichern(aq_et.getText().toString());

    }

    private void Textspeichern(String inhalt){
        int i = 1;
        int k = i-1;
        if (inhalt != null){
            if (speicher.getString("Data"+i,null) == null) {
                editor.putString("Data" + i, inhalt);
                editor.commit();
                Toast.makeText(this, "Frage wurde hinzugefügt!", Toast.LENGTH_LONG).show();
                i++;
            }
            else if (speicher.getString("Data"+i,null) != null){
                while (speicher.getString("Data"+i,null) != null){
                    i++;
                }
            }
        }
    }
}
