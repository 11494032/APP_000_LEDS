package com.example.administrator.app_0001_leds1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import com.example.administrator.hardlibrary.*;

public class MainActivity extends AppCompatActivity {
    private Button button_onoff;

    private CheckBox checkBoxLed1;
    private CheckBox checkBoxLed2;
    private CheckBox checkBoxLed3;
    private CheckBox checkBoxLed4;
    private boolean leds_on = false;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_onoff = (Button) findViewById(R.id.myButton);

        checkBoxLed1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBoxLed2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBoxLed3 = (CheckBox) findViewById(R.id.checkbox3);
        checkBoxLed4 = (CheckBox) findViewById(R.id.checkbox4);

        button_onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leds_on = !leds_on;
                if (leds_on) {
                    button_onoff.setText("on");

                   Toast.makeText(getApplicationContext(), "leds on", Toast.LENGTH_SHORT).show();
                }
                else {
                    button_onoff.setText("off");
                    Toast.makeText(getApplicationContext(), "leds off", Toast.LENGTH_SHORT).show();
                }

                checkBoxLed1.setChecked(leds_on);
                checkBoxLed2.setChecked(leds_on);
                checkBoxLed3.setChecked(leds_on);
                checkBoxLed4.setChecked(leds_on);

            }

        });





        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox1:
                if (checked) {

                    Toast.makeText(getApplicationContext(), "led1 on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "led1 off", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox2:
                if (checked) {

                    Toast.makeText(getApplicationContext(), "led2 on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "led2 off", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox3:
                if (checked) {

                    Toast.makeText(getApplicationContext(), "led3 on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "led3 off", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox4:
                if (checked) {

                    Toast.makeText(getApplicationContext(), "led4 on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "led4 off", Toast.LENGTH_SHORT).show();
                }
                break;
                // TODO: Veggie sandwich
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.app_0001_leds1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.app_0001_leds1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
