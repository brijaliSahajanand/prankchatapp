package ru.fotostrana.socketapp.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;
import ru.fotostrana.socketapp.dialog.DialogCLickListener;
import ru.fotostrana.socketapp.fragment.FirstFragment;
import ru.fotostrana.socketapp.fragment.SecondFragment;
import ru.fotostrana.socketapp.model.LevelMaster;
import ru.fotostrana.socketapp.test.AiGameActivity;

public class LevelActivity extends AppCompatActivity implements DialogCLickListener {

    Activity activity;
    ImageView btnNextLevel, btnContinue, iv_star, imgLeftView, imgRightView;
    ArrayList<LevelMaster> DataOfLevelView = new ArrayList<>();
    ArrayList<LevelMaster> DataOfLevelView1 = new ArrayList<>();
    TextView txtPoints;
    LottieAnimationView imgstar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        activity = LevelActivity.this;
        FillListDataView();
        InItViewData();
    }

    private void InItViewData() {
        btnContinue = findViewById(R.id.btnContinue);
        btnNextLevel = findViewById(R.id.btnNextlevel);
        imgLeftView = findViewById(R.id.imgLeftView);
        viewPager = findViewById(R.id.rrlevel);
        imgRightView = findViewById(R.id.imgRightView);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FirstFragment(activity, DataOfLevelView));
        adapter.addFrag(new SecondFragment(activity, DataOfLevelView1));
        viewPager.setAdapter(adapter);
        btnNextLevel.setOnClickListener(OnClick);
        btnContinue.setOnClickListener(OnClick);
        imgLeftView.setOnClickListener(OnClick);
        imgRightView.setOnClickListener(OnClick);

        if (Preference.getLevel() > 12) {
            viewPager.setCurrentItem(2);
        }

    }

    public View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnNextlevel:
                    Intent intent = new Intent(activity, MoreOptionActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnContinue:
                    Intent intent1 = new Intent(activity, MainActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.imgLeftView:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.imgRightView:
                    viewPager.setCurrentItem(1);
                    break;
            }
        }
    };

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void homeButtonClick() {
    }

    @Override
    public void nextButtonClick() {
    }

    @Override
    public void retryButtonClick() {
    }

    @Override
    public void selectionofoption(int position) {

        if (Preference.getFinalPoints() == 0) {
            Toast.makeText(activity, "You don't have enough balance to play the game", Toast.LENGTH_SHORT).show();
            return;
        }
        Preference.setFinalPoints(Preference.getFinalPoints() - 10);
        if (position == 1) {
            Intent intent = new Intent(LevelActivity.this, AiGameActivity.class);
            startActivity(intent);
            finish();
        } else if (position == 2) {
            Intent intent = new Intent(LevelActivity.this, ScratchActivity.class);
            startActivity(intent);
            finish();

        } else if (position == 3) {
            Intent intent = new Intent(LevelActivity.this, SpinWinActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void closedialog() {
        Intent intent = new Intent(LevelActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void FillListDataView() {
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g1)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g2)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g3)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g4)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g5)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g6)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g7)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g8)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g9)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g10)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g11)));
        DataOfLevelView.add(new LevelMaster(activity.getDrawable(R.drawable.g12)));

        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g13)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g14)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g15)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g16)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g17)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g18)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g19)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g20)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g21)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g22)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g23)));
        DataOfLevelView1.add(new LevelMaster(activity.getDrawable(R.drawable.g24)));

    }

    @Override
    protected void onResume() {
        super.onResume();
        txtPoints = findViewById(R.id.txtPoints);
        imgstar = findViewById(R.id.imgstar);
        iv_star = findViewById(R.id.iv_star);
        if (Preference.getFinalPoints() == 0) {
            txtPoints.setText("0");
            return;
        }
        ValueAnimator animator = ValueAnimator.ofInt(Preference.getFinalPoints() - 10, Preference.getFinalPoints());
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                txtPoints.setText(animation.getAnimatedValue().toString());
                if (animation.getAnimatedValue().toString().equalsIgnoreCase(String.valueOf(Preference.getFinalPoints()))) {
                    imgstar.pauseAnimation();
                    imgstar.clearAnimation();
                    imgstar.setVisibility(View.GONE);
                    iv_star.setVisibility(View.VISIBLE);
                }
            }
        });
        animator.start();
    }
}