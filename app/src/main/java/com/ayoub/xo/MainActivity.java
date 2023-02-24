package com.ayoub.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    // 0:x 1:o 2:empty
    int [] gamestate ={2,2,2,2,2,2,2,2,2};
    int [][] winningpositions={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    boolean gameactive=true;

    public void clickiyaa(View v){
        int k = 0;
    ImageView counter = (ImageView) v;

    int tabclicked= Integer.parseInt(counter.getTag().toString())-1;
    if(gamestate[tabclicked]==2&&gameactive){
            counter.setTranslationY(-1500);
    gamestate[tabclicked]=activePlayer;
    if(activePlayer==0) {
        counter.setImageResource(R.drawable.x);
        activePlayer=1;
    }
    else{
        counter.setImageResource(R.drawable.o);
        activePlayer=0;
    }
    counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

    for(int[] winningpos:winningpositions){
        String winner="";
        if(activePlayer==1)
        { winner="X";}
            else if(activePlayer==0){ winner="O";}
        if(gamestate[winningpos[0]-1]==gamestate[winningpos[1]-1]&&gamestate[winningpos[1]-1]==gamestate[winningpos[2]-1]&&gamestate[winningpos[0]-1]!=2){
            gameactive=false;
            Button playagain=findViewById(R.id.playagain);
            TextView winners=findViewById(R.id.winner);
            Toast.makeText(MainActivity.this,winner+" has won",Toast.LENGTH_SHORT).show();
            playagain.setVisibility(View.VISIBLE);
            winners.setText(winner+" has won!");
            winners.setVisibility(View.VISIBLE);


        }
    }

        for (int i = 0; i < 9; i++) {
            if(gamestate[i]!=2)k++;
            Button playagain=findViewById(R.id.playagain);
        if(k==9&&playagain.getVisibility()!=View.VISIBLE){gameactive=false;
                TextView winners=findViewById(R.id.winner);
                playagain.setVisibility(View.VISIBLE);
                winners.setText(" NULL!");
                winners.setVisibility(View.VISIBLE);
        }}}}



    public void playagain(View v){
        recreate();
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdView adView ;
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        Button basicphrase=findViewById(R.id.basicphrase);
        basicphrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,basicphrase.class);
                startActivity(intent);
            }
        });
        Button webvie=findViewById(R.id.webid);
        webvie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,webvie.class);
                startActivity(intent);
            }
        });
        Button videoButton=findViewById(R.id.videoid);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,videoplayer.class);
                startActivity(intent);
            }
        });
        Button audioButton=findViewById(R.id.audioid);
        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,mediaplayer.class);
                startActivity(intent);
            }
        });
    }
}