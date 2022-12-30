package ru.fotostrana.socketapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import ru.fotostrana.socketapp.BuildConfig;
import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.dialog.ExitDialog;


/* loaded from: classes2.dex */
public class StartActivity extends AppCompatActivity {

    ImageView button, share, rateUs;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_start);


        this.button = (ImageView) findViewById(R.id.button);

        this.rateUs = (ImageView) findViewById(R.id.image_rate);
        this.share = (ImageView) findViewById(R.id.image_share);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        });
        this.rateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                StartActivity.this.m190lambda$onCreate$3$comprankchatmasteractivitiesStartActivity(view);
            }
        });
        this.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                StartActivity.this.m191lambda$onCreate$4$comprankchatmasteractivitiesStartActivity(view);
            }
        });
    }


    void m190lambda$onCreate$3$comprankchatmasteractivitiesStartActivity(View view) {
        startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)));
    }

    void m191lambda$onCreate$4$comprankchatmasteractivitiesStartActivity(View view) {
        startActivity(new Intent("android.intent.action.SEND")
                .putExtra("android.intent.extra.TEXT",
                        "Check out this amazing application\nhttps://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)
                .setType("text/plain"));
    }


    @Override
    public void onBackPressed() {
        ExitDialog exitDialog = new ExitDialog();
        exitDialog.show(getFragmentManager(), "MyCustomDialog");
        exitDialog.setCancelable(false);
    }
}
