package com.coreelements.ihnn;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.ads.*;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;


public class AnleitungActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anleitung);

        AdView adViewAnleitung = (AdView)findViewById(R.id.adViewAnleitung);
        AdRequest adRequestAnleitung = new AdRequest.Builder().build();
        adViewAnleitung.loadAd(adRequestAnleitung);

        AdBuddiz.setPublisherKey("73489c9d-5cab-4fd6-a591-3e09af48f152");
        AdBuddiz.cacheAds(this);
        AdBuddiz.showAd(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_anleitung, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_anleitung) {
            startActivity(new Intent(getApplicationContext(), QuestionAdd.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), LayoutMainActivity.class));
        this.finish();
    }
}
