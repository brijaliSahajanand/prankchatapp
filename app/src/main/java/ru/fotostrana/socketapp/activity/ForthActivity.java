package ru.fotostrana.socketapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.adsdemosp.AdsClass.Ads_Interstitial;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;

public class ForthActivity extends AppCompatActivity {

    Activity activity;
    TextView iv_nxt_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        activity = ForthActivity.this;
        InItViewData();
    }

    private void InItViewData() {
        iv_nxt_button = findViewById(R.id.iv_nxt_button);
        iv_nxt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ads_Interstitial.showAds_full(ForthActivity.this, new Ads_Interstitial.OnFinishAds() {
                    @Override
                    public void onFinishAds(boolean b) {
                        Intent intent = new Intent(ForthActivity.this, StartActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}