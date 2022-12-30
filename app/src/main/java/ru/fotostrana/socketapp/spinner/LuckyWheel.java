package ru.fotostrana.socketapp.spinner;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;
import java.util.Random;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;


public class LuckyWheel extends RelativeLayout {
    private WheelView wheelView;
    //    private ImageView /*arrow,*/ start;
    private ImageView btn_start;
    private OnLuckyWheelStart mOnLuckyWheelStart;
    private OnChangeLevel mChangeListener;
    private OnLuckyWheelReachTheTarget mOnLuckyWheelReachTheTarget;
    private OnOutOfSpin mOnOutOfSpin;
    private OnWinHashChange mOnWinHashChange;
    private int selectedNo = 1;
    private boolean isOutOfSpin = false;
    private SparseIntArray winArray;
    private Random random = new Random();
    private boolean isLive = true;
    private boolean isLive_point = false;
    int coin_pos = 0;

    private static OnFinishAds onFinishAds;
    private int currentLvl = 0;

    private int[] coin = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private int[] coin_custom = new int[]{0, 3, 5, 7, 11, 15, 18, 20};

    public LuckyWheel(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initComponent();
        applyAttribute(attrs);
    }

    public LuckyWheel(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initComponent();
        applyAttribute(attrs);
    }


    public void setWinArray(SparseIntArray winArray) {
        this.winArray = winArray;
    }

    public void setCurrentLvl(int currentLvl) {
        this.currentLvl = currentLvl;
    }

    private void initComponent() {
        inflate(getContext(), R.layout.lucky_spin_design, this);
        wheelView = findViewById(R.id.wv_main_wheel);
//        start = findViewById(R.id.iv_start);
        btn_start = findViewById(R.id.btn_start);

        btn_start.setOnClickListener(v -> {

            // int used_spin = Preference.getUsed_Spin();
            if (Preference.getUsed_Spin() < Preference.getTotal_spin()) {

                btn_start.setClickable(false);
                //   used_spin++;
                //   Preference.setUsed_Spin(used_spin);
                Log.d("spin_start", "start" + Preference.getUsed_Spin());
                int pos = random.nextInt(8);
                rotateWheelTo(pos + 1, coin[pos]);
            } else {

                mOnOutOfSpin.onOutOfSpin();
                /*setOutOfSpin(true);*/
                Log.d("spin_start", "start_else part");
                /*if (rewardedVideoAd.isLoaded()) {
                    rewardedVideoAd.show();
                } else if (UnityAds.isReady()){
                    UnityAds.show((Activity) getContext(),"video");
                } else {
                    new Spin_And_Win().reward_video_showing();
                }

                Log.d("spin_start", "start_else part");*/
            }
        });

        wheelView.setWheelListener((targetPos, winValue, isLive, ads) -> {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setClickable(true);
                }
            }, 500);
            mOnLuckyWheelReachTheTarget.onReachTarget(targetPos, winValue, isLive, ads);
        });
    }

    protected interface OnFinishAds {
        void onFinishAds(boolean b);

    }

    public void setSelectedNo(int selectedNo) {
        this.selectedNo = selectedNo;
    }

    public void setOutOfSpin(boolean isOutOfSpin) {
        this.isOutOfSpin = isOutOfSpin;
    }

    public void setDoPlaySound(boolean doPlaySound) {
        wheelView.setDoPlaySound(doPlaySound);
    }

    public void setSoundFile(int soundFile) {
        wheelView.setSoundFile(soundFile);
    }

    public void addWheelItems(List<WheelItem> wheelItems) {
        wheelView.addWheelItems(wheelItems);
    }

    public void applyAttribute(AttributeSet attrs) {
        /*TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.LuckyWheel, 0, 0);
        try {
            int backgroundColor = typedArray.getColor(R.styleable.LuckyWheel_background_color, Color.TRANSPARENT);
//            int arrowImage = typedArray.getResourceId(R.styleable.LuckyWheel_arrow_image, R.drawable.arrow);

            wheelView.setWheelBackgroundWheel(backgroundColor);
//            arrow.setImageResource(arrowImage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        typedArray.recycle();*/
    }

    /**
     * Function to set lucky wheel reach the target listener
     *
     * @param onLuckyWheelReachTheTarget Lucky wheel listener
     */
    public void setLuckyWheelReachTheTarget(OnLuckyWheelReachTheTarget onLuckyWheelReachTheTarget) {
        mOnLuckyWheelReachTheTarget = onLuckyWheelReachTheTarget;
    }

    /**
     * Function to set lucky wheel start spinning listener
     *
     * @param onLuckyWheelStart Lucky wheel listener
     */
    public void setLuckyWheelStart(OnLuckyWheelStart onLuckyWheelStart) {
        mOnLuckyWheelStart = onLuckyWheelStart;
    }

    /**
     * Function to set lucky wheel start spinning listener
     *
     * @param changeListener Lucky wheel listener
     */
    public void setLevelChangeListener(OnChangeLevel changeListener) {
        mChangeListener = changeListener;
    }

    /**
     * Function to set out of spin listener
     *
     * @param mOnOutOfSpin out of spin listener
     */
    public void setOnOutOfSpin(OnOutOfSpin mOnOutOfSpin) {
        this.mOnOutOfSpin = mOnOutOfSpin;
    }

    /**
     * Function to set win hash change listener
     *
     * @param onWinHashChange win hash change listener
     */
    public void setOnWinHashChange(OnWinHashChange onWinHashChange) {
        this.mOnWinHashChange = onWinHashChange;
    }

    /**
     * Function to rotate wheel to degree
     *
     * @param number   Number to rotate
     * @param winValue Rewarded value
     */
    public void rotateWheelTo(int number, int winValue) {
        wheelView.resetRotationLocationToZeroAngle(number, winValue, isLive, isLive_point);
    }

    /**
     * Function to set wheel rotation time
     *
     * @param millisecond wheel rotation time
     */
    public void setWheelRotationTime(int millisecond) {
        wheelView.setWheelRotationTime(millisecond);
    }

    /**
     * Function to set wheel rotation count
     *
     * @param count wheel rotation count
     */
    public void setWheelRotationNo(int count) {
        wheelView.setWheelRotationNo(count);
    }

    public SparseIntArray getWinHash(int winLevel) {
        WinAlgorithm winAlgorithm = new WinAlgorithm(coin);
        if (winLevel == 7) {
            return winAlgorithm.getWinMap(50, 0, true);
        }
        if (winLevel == 0) {
            return winAlgorithm.getWinMap(100, 1, false);
        } else if (winLevel == 1) {
            return winAlgorithm.getWinMap(100, 1, false);
        } else if (winLevel == 2) {
            return winAlgorithm.getWinMap(100, 1, false);
        } else {
            return winAlgorithm.getWinMap(50, 0, false);
        }
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public void setIsLive_point(boolean setIsLive_point) {
        this.isLive_point = setIsLive_point;
    }

    public void set_coin_pos(int coin_pos) {
        this.coin_pos = coin_pos;
    }
}