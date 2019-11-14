package com.bikram.navigationdrawer2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactsDetailsActivity extends AppCompatActivity {

    CircleImageView cic;
    TextView nc,pc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_details);

        cic=findViewById(R.id.imgProfilec);
        nc=findViewById(R.id.textViewnamec);
        pc=findViewById(R.id.textViewphonec);

        Bundle bundle=getIntent().getExtras();

        if(bundle!=null)
        {
            cic.setImageResource(bundle.getInt("image"));
            nc.setText(bundle.getString("name"));
            pc.setText(bundle.getString("phone"));
        }
    }
}
