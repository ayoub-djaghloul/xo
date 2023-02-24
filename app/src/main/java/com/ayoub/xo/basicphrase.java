package com.ayoub.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class basicphrase extends AppCompatActivity {
public void playphrase(View v){
    Button Buttonpressed= (Button) v;
    String name=Buttonpressed.getTag().toString();
    Context context;
    MediaPlayer media=MediaPlayer.create(this, getResources().getIdentifier(name, "raw",    this.getPackageName()));
    media.start();
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicphrase);
    }
}