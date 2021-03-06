package com.transenigma.mediappb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import layout.TrackFragment;

public class BloodTestDetails extends AppCompatActivity {

    CardView c1;
    TextView t1;
    int i1=0;
    ImageView iv1,iv2;
    TextView title,desc,req;
    String[] Title,Desc,Req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_test_details);

        c1=(CardView)findViewById(R.id.bt_pro_filter_card);
        t1 = (TextView) findViewById(R.id.bt_pro_filter_title);
        iv1 = (ImageView)findViewById(R.id.bt_pro_filter_arrow);
        iv2 = (ImageView)findViewById(R.id.bt_pro_iv);

        c1.setVisibility(View.GONE);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i1==0){
                    i1=1;
                    c1.setVisibility(View.VISIBLE);
                    iv1.animate().rotation(180).setDuration(100).start();

                }
                else {
                    i1=0;
                    c1.setVisibility(View.GONE);
                    iv1.animate().rotation(0).setDuration(100).start();
                }
            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //getting intent and fixing values from arrays based on position.

        Intent i = getIntent();
        title = (TextView)findViewById(R.id.bt_pro_title);
        desc =(TextView)findViewById(R.id.bt_pro_desc);
        req= (TextView)findViewById(R.id.bt_pro_req);
        int location = i.getIntExtra("Calling_From",0);  // not needed, Just for future use when tracking
        int position = i.getIntExtra("Position",0);  // Here Position is name tag given when feeding into intent, 0 is default value if missing.
        Title = getResources().getStringArray(R.array.home_bt_title);
        Desc = getResources().getStringArray(R.array.bt_pro_desc);
        Req = getResources().getStringArray(R.array.bt_pro_req);

        title.setText(Title[position]);
        desc.setText(Desc[position]);
        req.setText(Req[position]);


    }
}
