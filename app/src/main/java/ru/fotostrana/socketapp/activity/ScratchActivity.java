package ru.fotostrana.socketapp.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.adsdemosp.AdsClass.Ads_Reward;
import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;
import ru.fotostrana.socketapp.constant.ScratchImageView;

public class ScratchActivity extends AppCompatActivity {

    Activity activity;
    ImageView img1, img2, img3, img4, img5, img6, imgback;
    int RandomPosition;
    int RandomPosition_Point;
    int RandomPositionPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch);
        activity = ScratchActivity.this;

        initViewData();
    }

    private void initViewData() {
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        imgback = findViewById(R.id.imgback);

        img1.setOnClickListener(OnClick);
        img2.setOnClickListener(OnClick);
        img3.setOnClickListener(OnClick);
        img4.setOnClickListener(OnClick);
        img5.setOnClickListener(OnClick);
        img6.setOnClickListener(OnClick);
        imgback.setOnClickListener(OnClick);
        RandomPosition = new Random().nextInt((6 - 1) + 1) + 1;
        RandomPosition_Point = new Random().nextInt((2 - 0) + 1) + 0;
        if (RandomPosition_Point == 0) {
            RandomPositionPoint = 2;
        } else if (RandomPosition_Point == 1) {
            RandomPositionPoint = 4;
        } else if (RandomPosition_Point == 2) {
            RandomPositionPoint = 10;
        }
    }

    public View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.imgback:
                    onBackPressed();
                    break;
                case R.id.img1:
                    CallGiftData(1);
                    break;

                case R.id.img2:
                    CallGiftData(2);

                    break;

                case R.id.img3:
                    CallGiftData(3);

                    break;

                case R.id.img4:
                    CallGiftData(4);

                    break;

                case R.id.img5:
                    CallGiftData(5);

                    break;

                case R.id.img6:
                    CallGiftData(6);

                    break;
            }

        }
    };
    public static Dialog scartchview;
    ScratchImageView scratchImageView;
    TextView tv_diamond_text;
    LottieAnimationView lottieview;

    public void CallGiftData(int randomPosition) {
        if (scartchview != null) {
            if (scartchview.isShowing()) {
                return;
            }
        }
        scartchview = new Dialog(activity);
        scartchview.requestWindowFeature(Window.FEATURE_NO_TITLE);
        scartchview.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        scartchview.setContentView(R.layout.scartch_dialog);
        scratchImageView = scartchview.findViewById(R.id.scratch_view);
        tv_diamond_text = scartchview.findViewById(R.id.tv_diamond_text);
        lottieview = scartchview.findViewById(R.id.lottieview);

        if (RandomPosition == randomPosition) {
            tv_diamond_text.setText("You Won point : ");
            lottieview.setVisibility(View.VISIBLE);

        } else {
            tv_diamond_text.setText("Batter luck for\nnext time !!");
            lottieview.setVisibility(View.GONE);
        }
        scratchImageView.setRevealListener(new ScratchImageView.IRevealListener() {
            @Override
            public void onRevealed(ScratchImageView iv) {
            }

            @Override
            public void onRevealPercentChangedListener(ScratchImageView siv, float percent) {
                if ((percent * 100f) > 90f) {
                    if (RandomPosition == randomPosition) {
                        Toast.makeText(activity, "You get Reward Point " + RandomPositionPoint, Toast.LENGTH_SHORT).show();
                        Preference.setFinalPoints(Preference.getFinalPoints());
                        out_of_spin_dialog(activity, RandomPositionPoint, randomPosition);

                    } else {
                        Toast.makeText(activity, "Better Luck for next time !!!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                onBackPressed();
                            }
                        }, 2000);

                    }
                    scartchview.dismiss();

                }
            }
        });
        scartchview.setCancelable(false);
        scartchview.show();
    }


    public void out_of_spin_dialog(Context context, Integer coin, int randomPosition) {
        Dialog reward_dialog = new Dialog(context);
        reward_dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        reward_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        reward_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        reward_dialog.setCancelable(false);
        reward_dialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
        reward_dialog.setContentView(R.layout.reward_won_dialogue);
        reward_dialog.show();

        TextView tv_coin = reward_dialog.findViewById(R.id.tv_coin);
        tv_coin.setText("You win " + coin + " Points");
        ImageView rlt_cancel = reward_dialog.findViewById(R.id.rlt_cancel);
        ImageView rlt_ok = reward_dialog.findViewById(R.id.rlt_ok);


        rlt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reward_dialog.dismiss();
            }
        });

        rlt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reward_dialog.dismiss();
                Ads_Reward.Show_Reward_Ads(ScratchActivity.this, new Ads_Reward.OnFinishAds() {
                    @Override
                    public void onFinishAds(boolean b) {
                        scartchview.dismiss();
                        onBackPressed();

                    }
                });
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}