package com.coreelements.ihnn;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import static com.coreelements.ihnn.R.layout.layout_change_color;

public class ChangeColor extends ActionBarActivity implements View.OnClickListener {

    RelativeLayout layout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout_change_color);

        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        layout = (RelativeLayout)findViewById(R.id.layoutchangecolor);
        layout.setBackgroundColor(getResources().getColor(R.color.red));
    }
}
