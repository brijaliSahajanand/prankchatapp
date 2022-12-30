package ru.fotostrana.socketapp.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ads.adsdemosp.AdsClass.Ads_Reward;

import java.util.ArrayList;
import java.util.List;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;
import ru.fotostrana.socketapp.spinner.LuckyWheel;
import ru.fotostrana.socketapp.spinner.OnChangeLevel;
import ru.fotostrana.socketapp.spinner.OnLuckyWheelReachTheTarget;
import ru.fotostrana.socketapp.spinner.OnLuckyWheelStart;
import ru.fotostrana.socketapp.spinner.OnOutOfSpin;
import ru.fotostrana.socketapp.spinner.OnWinHashChange;
import ru.fotostrana.socketapp.spinner.WheelItem;

import static ru.fotostrana.socketapp.constant.Utils.new_loader;

public class SpinWinActivity extends Activity {


    ImageView rl_back;
    TextView tv_diamond_balance;
    RelativeLayout ll_coin_toast;
    private LuckyWheel lwvPoint;
    private int ROTATION_TIME = 5000;
    private int NO_OF_ROTATION = 15 * (ROTATION_TIME / 5000);
    Boolean dailog_bool = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_win);

        lwvPoint = findViewById(R.id.lwvPoint);
        tv_diamond_balance = findViewById(R.id.tv_diamond_balance);
        rl_back = findViewById(R.id.rl_back);
        ll_coin_toast = findViewById(R.id.ll_coin_toast);
        tv_diamond_balance.setText("Balance: " + String.valueOf(Preference.getFinalPoints()));
        Preference.setTotal_spin(1);
        Preference.setUsed_Spin(0);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setUpWheel();
    }
    @Override
    public void onBackPressed() {
        finish();
    }

    private void setUpWheel() {
        final List<WheelItem> wheelItems = new ArrayList<>();
        wheelItems.add(new WheelItem(Color.parseColor("#A05CF6")
                , BitmapFactory.decodeResource(getResources(), R.drawable.zero)));
        wheelItems.add(new WheelItem(Color.parseColor("#32ADF9")
                , BitmapFactory.decodeResource(getResources(), R.drawable.three)));
        wheelItems.add(new WheelItem(Color.parseColor("#29CAEA")
                , BitmapFactory.decodeResource(getResources(), R.drawable.five)));
        wheelItems.add(new WheelItem(Color.parseColor("#F6CA45")
                , BitmapFactory.decodeResource(getResources(), R.drawable.seven)));
        wheelItems.add(new WheelItem(Color.parseColor("#F58977")
                , BitmapFactory.decodeResource(getResources(), R.drawable.eleven)));
        wheelItems.add(new WheelItem(Color.parseColor("#E85299")
                , BitmapFactory.decodeResource(getResources(), R.drawable.fifteen)));
        wheelItems.add(new WheelItem(Color.parseColor("#CC326A")
                , BitmapFactory.decodeResource(getResources(), R.drawable.eighteen)));
        wheelItems.add(new WheelItem(Color.parseColor("#E07AFE")
                , BitmapFactory.decodeResource(getResources(), R.drawable.twenty)));

        lwvPoint.addWheelItems(wheelItems);
        lwvPoint.setIsLive(true);
        lwvPoint.setSoundFile(R.raw.bicycle);
        lwvPoint.setWheelRotationTime(ROTATION_TIME);
        lwvPoint.setWheelRotationNo(NO_OF_ROTATION);

        lwvPoint.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget(int targetPos, int winValue, boolean isLive, boolean ads) {
                Log.d("spin_start", "reach_target" + winValue);
                if (dailog_bool) {
                    spin_updated(SpinWinActivity.this, winValue);
                }
            }
        });

        lwvPoint.setLuckyWheelStart(new OnLuckyWheelStart() {
            @Override
            public int onStartSpinning(boolean isLive) {
                return 0;
            }
        });

        lwvPoint.setOnOutOfSpin(new OnOutOfSpin() {
            @Override
            public void onOutOfSpin() {
                out_of_spin_dialog(SpinWinActivity.this, 0);
                Log.d("spin_start", "out_of_spin");
            }
        });

        lwvPoint.setOnWinHashChange(new OnWinHashChange() {
            @Override
            public void onWinHashChange(SparseIntArray winHash) {
                Log.d("spin_start", "win_hash_change");
            }
        });

        lwvPoint.setLevelChangeListener(new OnChangeLevel() {
            @Override
            public SparseIntArray onChangeLevel(int level) {
                Log.d("spin_start", "level change");
                return null;
            }
        });
    }

    @Override
    protected void onPause() {
        dailog_bool = false;
        super.onPause();
    }

    @Override
    protected void onResume() {
        dailog_bool = true;
        super.onResume();
    }

    public void spin_updated(Context context, Integer coin) {
        tv_diamond_balance.setText("Balance: " + String.valueOf(Preference.getFinalPoints() +coin));
        reward_won_dialog(SpinWinActivity.this, coin);
    }

    public void watch_reward_update(Context context) {
        lwvPoint.setOutOfSpin(false);
        tv_diamond_balance.setText("Balance: " + String.valueOf(Preference.getFinalPoints()));
        new_loader(SpinWinActivity.this, false);
        Preference.setTotal_spin(Preference.getTotal_spin());
        Preference.setUsed_Spin(0);

    }


    public void out_of_spin_dialog(Context context, Integer coin) {
        Dialog reward_dialog = new Dialog(context);
        reward_dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        reward_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        reward_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        reward_dialog.setCancelable(false);
        reward_dialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
        reward_dialog.setContentView(R.layout.reward_won_dialogue);
        reward_dialog.show();

        TextView tv_coin = reward_dialog.findViewById(R.id.tv_coin);
        tv_coin.setText("Out Of Spin");
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
                Ads_Reward.Show_Reward_Ads(SpinWinActivity.this, new Ads_Reward.OnFinishAds() {
                    @Override
                    public void onFinishAds(boolean b) {
                        if (b) {
                            outof_spin();
                            watch_reward_update(SpinWinActivity.this);
                        } else {
                            Toast.makeText(SpinWinActivity.this, "Please Try Again After Some Time", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void reward_won_dialog(Context context, Integer coin) {
        Dialog reward_dialog = new Dialog(context);
        reward_dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        reward_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        reward_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        reward_dialog.setCancelable(false);
        reward_dialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
        reward_dialog.setContentView(R.layout.reward_won_dialogue);
        reward_dialog.show();


        TextView tv_coin = reward_dialog.findViewById(R.id.tv_coin);
        tv_coin.setText("You Win " + coin + " Diamonds");
        ImageView rlt_cancel = reward_dialog.findViewById(R.id.rlt_cancel);
        ImageView rlt_ok = reward_dialog.findViewById(R.id.rlt_ok);

        Preference.setFinalPoints(Preference.getFinalPoints() + coin);
        rlt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(context, coin + " Coins Added To Your Wallet", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();

                setResult(RESULT_OK, intent);
                finish();


            }
        });

        rlt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, coin + " Coins Added To Your Wallet", Toast.LENGTH_SHORT).show();
                reward_dialog.dismiss();
                Intent intent = new Intent();
                intent.putExtra("FinalPoint", "10");
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }

    public void outof_spin() {
        Toast.makeText(this, Preference.getTotal_spin() + " New Spin Added", Toast.LENGTH_SHORT).show();
        lwvPoint.setOutOfSpin(false);
    }


}