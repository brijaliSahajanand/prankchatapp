package ru.fotostrana.socketapp.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.ads.adsdemosp.AdsClass.Ads_ExitNativeFull;
import com.ads.adsdemosp.AdsClass.Ads_Interstitial;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ForwardToSettingsCallback;
import com.permissionx.guolindev.callback.RequestCallback;
import com.permissionx.guolindev.request.ForwardScope;


import java.util.List;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;
import ru.fotostrana.socketapp.defultdata.BaseActivity;

import static ru.fotostrana.socketapp.constant.Utils.Exit_Dialog;


public class First_Activity extends BaseActivity {
    TextView iv_nxt_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_);

        iv_nxt_button = findViewById(R.id.iv_nxt_button);

        iv_nxt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckPermission()) {
                    onPermissionGranted();
                } else {
                    requestStoragePermission();
                }
              /*  Ads_Interstitial.showAds_full(First_Activity.this, new Ads_Interstitial.OnFinishAds() {
                    @Override
                    public void onFinishAds(boolean b) {
                        Intent intent = new Intent(First_Activity.this, Second_Activity.class);
                        startActivity(intent);
                    }
                });*/

            }
        });
    }

    String[] permissions = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

    private void requestStoragePermission() {
        PermissionX.init(First_Activity.this)
                .permissions(permissions)
                .onForwardToSettings(new ForwardToSettingsCallback() {
                    @Override
                    public void onForwardToSettings(@NonNull ForwardScope scope, @NonNull List<String> deniedList) {
                        scope.showForwardToSettingsDialog(deniedList, "Core fundamental are based on these permissions",
                                "OK", "Cancel");
                    }
                }).request(new RequestCallback() {
            @Override
            public void onResult(boolean allGranted, @NonNull List<String> grantedList, @NonNull List<String> deniedList) {
                if (allGranted) {
//                    onPermissionGranted();
                }
            }
        });

    }


    private void onPermissionGranted() {
        Ads_Interstitial.showAds_full(First_Activity.this, new Ads_Interstitial.OnFinishAds() {
            @Override
            public void onFinishAds(boolean b) {

                if (Preference.getscreenshow() != 1) {
                    Intent intent = new Intent(First_Activity.this, Second_Activity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(First_Activity.this, StartActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean CheckPermission() {
        for (int i = 0; i < permissions.length; i++) {

            if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }

        }
        return true;
    }

    boolean exit_flag = false;

    @Override
    public void onBackPressed() {

        if (Ads_ExitNativeFull.checkExitAdsLoaded()) {
            Exit_Dialog(this);
        } else {
            if (exit_flag) {
                finishAffinity();
            } else {
                exit_flag = true;
                Toast.makeText(this, "Please tap again!", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit_flag = false;
                    }
                }, 3000);
            }
        }
    }
}