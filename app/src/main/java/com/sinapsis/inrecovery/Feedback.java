package com.sinapsis.inrecovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Feedback extends AppCompatActivity {
    int adiccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Button ok=(Button)findViewById(R.id.ok);
        ok.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            Feedback.this.finish();
            }
        });
    }
}
