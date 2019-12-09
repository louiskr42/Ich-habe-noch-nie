package com.coreelements.ihnn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//import com.purplebrain.adbuddiz.sdk.AdBuddiz;


public class LayoutMainActivity extends ActionBarActivity implements View.OnClickListener {

    int i = 0;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        //AdBuddiz.setPublisherKey("73489c9d-5cab-4fd6-a591-3e09af48f152");
        //AdBuddiz.cacheAds(this);
        //AdBuddiz.showAd(this);
        
        final ImageButton lg_btn = (ImageButton) findViewById(R.id.imageButton);
        lg_btn.setOnClickListener(this);

        final ImageButton anleitung_btn = (ImageButton) findViewById(R.id.anleitung_btn);
        anleitung_btn.setOnClickListener(this);

        final ImageButton quit_btn = (ImageButton) findViewById(R.id.quit_btn);
        quit_btn.setOnClickListener(this);

        //btn = (Button)findViewById(R.id.button2);
        //btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.imageButton:
                startActivity(new Intent(getApplicationContext(), GameActivity.class));
                this.finish();
            break;

            case R.id.quit_btn:
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);

                alertDialog2.setTitle("Beenden");
                alertDialog2.setMessage("Wollen sie die App wirklich beenden?");
                alertDialog2.setIcon(R.drawable.indicator_input_error);
                alertDialog2.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Ich habe noch nie... wurde beendet", Toast.LENGTH_SHORT).show();

                        System.exit(0);
                    }
                });
                alertDialog2.setNegativeButton("Nein", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Dann weiterhin viel Spaß :D", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog2.show();
            break;

            case R.id.anleitung_btn:
                startActivity(new Intent(getApplicationContext(), AnleitungActivity.class));
                this.finish();
            break;

            //case R.id.button2:
            //    startActivity(new Intent(getApplicationContext(), ChangeColor.class));
            //    this.finish();
            //    break;
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(this);

        alertDialog3.setTitle("Beenden");
        alertDialog3.setMessage("Wollen sie die App wirklich beenden?");
        alertDialog3.setIcon(R.drawable.indicator_input_error);
        alertDialog3.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        alertDialog3.setNegativeButton("Nein", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Dann weiterhin viel Spaß :D", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog3.show();
    }
}
