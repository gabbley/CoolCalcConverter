package com.gabbley.coolcalcconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DownloadInstructions extends AppCompatActivity {

    public TextView instructions = (TextView) findViewById(R.id.txtInstructions);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_instructions);

        instructions.setText("Instructions on how to download the app onto an android device: /n" +
                "Step 1: Using a usb cable, plug in desired Android device into computer./n" +
                "Step 2: View files on the device and locate the downloads file./n" +
                "Step 3: There is an .apk file provided. Copy and paste that into the downloads file./n" +
                "You should not drag it into the folder./n" +
                "Step 4: Open the device and locate the file commander. You can access the downloads/n" +
                "file from there. Locate the CoolCalcConverter app and open the app.");

    }
}
