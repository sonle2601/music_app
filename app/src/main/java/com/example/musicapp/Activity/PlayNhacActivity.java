package com.example.musicapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import com.example.musicapp.Adapter.ViewPagerPlayListNhac;
import com.example.musicapp.Fragment.Fragment_Dia_Nhac;
import com.example.musicapp.Fragment.Fragment_Play_Danh_Sach_Nhac;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class PlayNhacActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txtthoigian, txtTongthoigian;
    SeekBar seekBar;
    ImageButton imgplay, imgrepeat, imgnext, imgpre, imgrandom;
    ViewPager viewPager;

    public  static ArrayList<Baihatyeuthich.Data> mangbaihat = new ArrayList<>();

    public static ViewPagerPlayListNhac adapterNhac;

    Fragment_Dia_Nhac fragment_dia_nhac;
    Fragment_Play_Danh_Sach_Nhac fragment_play_danh_sach_nhac;

    MediaPlayer mediaPlayer;
    int position = 0;
    boolean repeat = false;
    boolean checkrandom = false;
    boolean next = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        getDataFromIntent();



        init();
        evenclick();
    }

    private void evenclick() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapterNhac.getItem(1)!=null){
                    if (mangbaihat.size() > 0){
                        fragment_dia_nhac.PlayNhac(mangbaihat.get(0).getHinhbaihat());
                        handler.removeCallbacks(this);
                    }else{
                        handler.postDelayed(this, 300);
                    }
                }
            }
        }, 5000 );
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imgplay.setImageResource(R.drawable.iconplay);
                }else{
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.iconpause);
                }
            }
        });
        imgrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeat == false){
                    if (checkrandom == true){
                        checkrandom = false;
                        imgrepeat.setImageResource(R.drawable.iconsyned);
                        imgrandom.setImageResource(R.drawable.random);
                    }
                    imgrepeat.setImageResource(R.drawable.iconsyned);
                    repeat = true;
                }else{
                    imgrepeat.setImageResource(R.drawable.iconrepeat);
                    repeat=false;
                }
            }
        });

        imgrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkrandom == false){
                    if (repeat == true){
                        repeat = false;
                        imgrepeat.setImageResource(R.drawable.iconrepeat);
                        imgrandom.setImageResource(R.drawable.randomed);
                    }
                    imgrandom.setImageResource(R.drawable.randomed);
                    checkrandom = true;
                }else{
                    imgrandom.setImageResource(R.drawable.random);
                    checkrandom=false;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                    mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mangbaihat.size() > 0){
                    if(mediaPlayer.isPlaying() || mediaPlayer != null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (position < (mangbaihat.size())){
                        imgplay.setImageResource(R.drawable.iconpause);
                        position++;
                        if( repeat == true){
                            if ( position == 0){
                                position = mangbaihat.size();
                            }
                            position -= 1;
                        }
                        if(checkrandom == true){
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if(index == position){
                                position = index -1 ;

                            }
                            position = index;
                        }
                        if (position > (mangbaihat.size()-1)){
                            position = 0;
                        }
                        new Playmp3().execute(mangbaihat.get(position).getLinkbaihat());
                        fragment_dia_nhac.PlayNhac(mangbaihat.get(position).getHinhbaihat());
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                        UpdateTime();
                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                },5000);
            }
        });

        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mangbaihat.size() > 0){
                    if(mediaPlayer.isPlaying() || mediaPlayer != null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (position < (mangbaihat.size())){
                        imgplay.setImageResource(R.drawable.iconpause);
                        position--;

                        if (position < 0){
                            position = mangbaihat.size() -1;
                        }
                        if( repeat == true){

                            position += 1;
                        }
                        if(checkrandom == true){
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if(index == position){
                                position = index -1 ;

                            }
                            position = index;
                        }

                        new Playmp3().execute(mangbaihat.get(position).getLinkbaihat());
                        fragment_dia_nhac.PlayNhac(mangbaihat.get(position).getHinhbaihat());
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                        UpdateTime();
                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                },5000);
            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        mangbaihat.clear();
        if (intent != null) {
            if (intent.hasExtra("baihat")) {
                Baihatyeuthich.Data baihat = intent.getParcelableExtra("baihat");
                mangbaihat.add(baihat);
            }
            if (intent.hasExtra("mangbaihat")) {
                ArrayList<Baihatyeuthich.Data> baihatArraylist = intent.getParcelableArrayListExtra("mangbaihat");
                mangbaihat.addAll(baihatArraylist);
            }
        }


    }

    private void init(){
        toolbar = findViewById(R.id.toolbarplay);
        txtthoigian = findViewById(R.id.txtthoigian);
        txtTongthoigian = findViewById(R.id.txttongthoigian);
        seekBar = findViewById(R.id.seekbarsong);
        imgnext = findViewById(R.id.imgbuttonnext);
        imgplay = findViewById(R.id.imgbuttonplay);
        imgpre = findViewById(R.id.imgbuttonpreview);
        imgrandom = findViewById(R.id.imgbuttonrandom);
        imgrepeat = findViewById(R.id.imgbuttonrepeat);
        viewPager = findViewById(R.id.viewpagerplaynhac);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Phát nhạc");
        Drawable drawable = toolbar.getNavigationIcon();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable.mutate(), getResources().getColor(R.color.black));
            toolbar.setNavigationIcon(drawable);
        }
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                mediaPlayer.stop();
                mangbaihat.clear();
            }
        });
        toolbar.setTitleTextColor(Color.WHITE);
        fragment_dia_nhac = new Fragment_Dia_Nhac();
        fragment_play_danh_sach_nhac = new Fragment_Play_Danh_Sach_Nhac();

        adapterNhac = new ViewPagerPlayListNhac(getSupportFragmentManager());
        adapterNhac.AddFragment(fragment_play_danh_sach_nhac);
        adapterNhac.AddFragment(fragment_dia_nhac);
        viewPager.setAdapter(adapterNhac);
        fragment_dia_nhac = (Fragment_Dia_Nhac) adapterNhac.getItem(1);
        if(mangbaihat.size() > 0){
            getSupportActionBar().setTitle(mangbaihat.get(0).getTenbaihat());
            new Playmp3().execute(mangbaihat.get(0).getLinkbaihat());
            imgplay.setImageResource(R.drawable.iconpause);
        }

    }
    class Playmp3 extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });

                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mediaPlayer.start();
            Timesong();
            UpdateTime();
        }
    }

    private void Timesong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTongthoigian.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void UpdateTime(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null){
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtthoigian.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this,300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            next = true;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            }
        },300);
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(next == true){
                    if (mangbaihat.size() > 0){
                        if (position < (mangbaihat.size())){
                            imgplay.setImageResource(R.drawable.iconpause);
                            position++;
                            if( repeat == true){
                                if ( position == 0){
                                    position = mangbaihat.size();
                                }
                                position -= 1;
                            }
                            if(checkrandom == true){
                                Random random = new Random();
                                int index = random.nextInt(mangbaihat.size());
                                if(index == position){
                                    position = index -1 ;

                                }
                                position = index;
                            }
                            if (position > (mangbaihat.size()-1)){
                                position = 0;
                            }
                            new Playmp3().execute(mangbaihat.get(position).getLinkbaihat());
                            fragment_dia_nhac.PlayNhac(mangbaihat.get(position).getHinhbaihat());
                            getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                        }
                    }
                    imgpre.setClickable(false);
                    imgnext.setClickable(false);
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgpre.setClickable(true);
                            imgnext.setClickable(true);
                        }
                    },5000);
                    next= false;
                    handler1.removeCallbacks(this);
                }else{
                    handler1.postDelayed(this,1000);
                }
            }
        },1000);
    }

}