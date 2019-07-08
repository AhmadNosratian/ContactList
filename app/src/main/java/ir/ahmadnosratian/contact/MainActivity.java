package ir.ahmadnosratian.contact;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getApplicationComponent().injectMainActivity(this);



        Toast.makeText(context, "Ok Context is injected", Toast.LENGTH_SHORT).show();
    }
}
