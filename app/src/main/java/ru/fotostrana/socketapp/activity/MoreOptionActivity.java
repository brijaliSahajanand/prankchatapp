package ru.fotostrana.socketapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;
import ru.fotostrana.socketapp.constant.Utils;
import ru.fotostrana.socketapp.test.AiGameActivity;

public class MoreOptionActivity extends AppCompatActivity {
    Activity activity;
    ImageView imgback, img_scratch, imgSpinner, imgTikTak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_option);
        activity = MoreOptionActivity.this;
        InItDataView();
    }

    private void InItDataView() {
        imgback = findViewById(R.id.imgback);
        img_scratch = findViewById(R.id.img_scratch);
        imgSpinner = findViewById(R.id.imgSpinner);
        imgTikTak = findViewById(R.id.imgTikTak);

        imgback.setOnClickListener(OnClick);
        img_scratch.setOnClickListener(OnClick);
        imgSpinner.setOnClickListener(OnClick);
        imgTikTak.setOnClickListener(OnClick);
    }

    public View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgback:
                    onBackPressed();
                    break;
                case R.id.img_scratch:
                    Preference.setFinalPoints(Preference.getFinalPoints() - 10);
                    Intent intent = new Intent(activity, ScratchActivity.class);
                    startActivity(intent);
                    finish();

                    break;

                case R.id.imgSpinner:
                    Preference.setFinalPoints(Preference.getFinalPoints() - 10);
                    Intent spinner = new Intent(activity, SpinWinActivity.class);
                    startActivity(spinner);
                    finish();

                    break;
                case R.id.imgTikTak:
                    Preference.setFinalPoints(Preference.getFinalPoints() - 10);
                    Intent tiktak = new Intent(activity, AiGameActivity.class);
                    startActivity(tiktak);
                    finish();

                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        Utils.IsFromMainScreen = false;
        super.onBackPressed();
    }
}