package com.google.adit.daftarmahasiswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity implements StudentAdapter.OnAdapterClickListener {


    public static final String NAME = "";
    public static final String ID = "";
    public static final String IMAGE = "";

    TextView detName, detId;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img = findViewById(R.id.det_img);
        detName = findViewById(R.id.det_name);
        detId = findViewById(R.id.det_id);

        detName.setText(getIntent().getStringExtra("name"));
        detId.setText(getIntent().getStringExtra("id"));

    }

    @Override
    public void onClick(Student student) {

    }
}
