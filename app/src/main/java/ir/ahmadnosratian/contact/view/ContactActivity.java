package ir.ahmadnosratian.contact.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import ir.ahmadnosratian.contact.App;
import ir.ahmadnosratian.contact.R;
import ir.ahmadnosratian.contact.di.DatabaseInfo;

public class ContactActivity extends AppCompatActivity {

    @Inject
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
