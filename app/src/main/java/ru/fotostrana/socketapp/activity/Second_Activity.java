package ru.fotostrana.socketapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ads.adsdemosp.AdsClass.Ads_Interstitial;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;
import ru.fotostrana.socketapp.defultdata.BaseActivity;


public class Second_Activity extends BaseActivity {
    TextView iv_get_started;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        iv_get_started = findViewById(R.id.iv_nxt_button);
        

        iv_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Ads_Interstitial.showAds_full(Second_Activity.this, new Ads_Interstitial.OnFinishAds() {
                    @Override
                    public void onFinishAds(boolean b) {
                        if (Preference.getscreenshow() != 2) {
                            Intent intent = new Intent(Second_Activity.this, Third_Activity.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(Second_Activity.this, StartActivity.class);
                            startActivity(intent);
                        }


                    }
                });


            }
        });


    }

    boolean exit_flag = false;

    @Override
    public void onBackPressed() {

        Ads_Interstitial.BackshowAds_full(this, new Ads_Interstitial.OnFinishAds() {
            @Override
            public void onFinishAds(boolean b) {
                finish();
            }
        });


    }
}