package ru.fotostrana.socketapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.adapter.ChatAdapter;
import ru.fotostrana.socketapp.constant.ChatLevels;
import ru.fotostrana.socketapp.constant.Preference;
import ru.fotostrana.socketapp.constant.Utils;
import ru.fotostrana.socketapp.dialog.DialogCLickListener;
import ru.fotostrana.socketapp.dialog.LevelCompleteDialog;
import ru.fotostrana.socketapp.model.ChatMaster;
import ru.fotostrana.socketapp.model.Message;

/* loaded from: classes2.dex */
public class MainActivity extends AppCompatActivity implements DialogCLickListener {
    ChatAdapter adapter;
    ChatLevels chatLevels;
    LinearLayout chatStartLayout, optionview;
    AppCompatTextView chatStartMessage;
    LevelCompleteDialog dialog;
    TextView mTitle, txtPoints, option1, option2;
    RecyclerView recyclerView;
    ArrayList<Message> messagesList = new ArrayList<>();
    ArrayList<ChatMaster> chatDataList = new ArrayList<>();
    int currentIndex = 1;
    int level = 0;
    RelativeLayout rr_view1, rr_view2;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.txtPoints = (TextView) findViewById(R.id.txtPoints);
        this.mTitle = (TextView) findViewById(R.id.toolbar_title);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view_chat);
        this.option1 = (TextView) findViewById(R.id.option_1);
        this.option2 = (TextView) findViewById(R.id.option_2);
        rr_view1 = findViewById(R.id.rr_view1);
        rr_view2 = findViewById(R.id.rr_view2);
        this.chatStartLayout = (LinearLayout) findViewById(R.id.chat_start_layout);
        optionview = findViewById(R.id.optionview);
        this.chatStartMessage = (AppCompatTextView) findViewById(R.id.start_chat_message);
        loadData();
        this.chatLevels = new ChatLevels();
        this.option1.setVisibility(View.INVISIBLE);
        this.option2.setVisibility(View.INVISIBLE);

        if (this.chatLevels.getChatMasterArrayList().size() > 0) {
            if (Preference.getLevel() >= 23) {
                Preference.setLevel(0);
            }
            this.level = Preference.getLevel();
        }

        ArrayList<ChatMaster> arrayList = this.chatLevels.getChatMasterArrayList().get(this.level);
        this.chatDataList = arrayList;
        this.chatStartMessage.setText(arrayList.get(0).getQuestion2());
        this.mTitle.setText(this.chatDataList.get(0).getQuestion1());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                m182lambda$onCreate$0$comprankchatmasteractivitiesMainActivity();
            }
        }, 3000L);
        this.option1.setText(this.chatDataList.get(this.currentIndex).getQuestion1());
        this.option2.setText(this.chatDataList.get(this.currentIndex).getQuestion2());
        this.adapter = new ChatAdapter(this, this.messagesList);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.adapter);

        this.rr_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m184lambda$onCreate$2$comprankchatmasteractivitiesMainActivity(view);
            }
        });
        this.option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m184lambda$onCreate$2$comprankchatmasteractivitiesMainActivity(view);
            }
        });


        this.rr_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m186lambda$onCreate$4$comprankchatmasteractivitiesMainActivity(view);
            }
        });
        this.option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                m186lambda$onCreate$4$comprankchatmasteractivitiesMainActivity(view);
            }
        });

        txtPoints.setText(Preference.getFinalPoints() + "");
    }

    void m182lambda$onCreate$0$comprankchatmasteractivitiesMainActivity() {
        this.chatStartLayout.setVisibility(View.GONE);
        this.recyclerView.setVisibility(View.VISIBLE);
        this.option1.setVisibility(View.VISIBLE);
        this.option2.setVisibility(View.VISIBLE);
        this.optionview.setVisibility(View.VISIBLE);
    }

    void m184lambda$onCreate$2$comprankchatmasteractivitiesMainActivity(View view) {
        this.option1.setClickable(false);
        this.option2.setClickable(false);
        if (this.currentIndex < this.chatDataList.size()) {
            this.messagesList.add(new Message(this.chatDataList.get(this.currentIndex).getQuestion1(), 1));
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                m183lambda$onCreate$1$comprankchatmasteractivitiesMainActivity();
            }
        }, 1L);
    }

    void m183lambda$onCreate$1$comprankchatmasteractivitiesMainActivity() {
        if (this.currentIndex < this.chatDataList.size() && !this.chatDataList.get(this.currentIndex).getAnswer1().equals("")) {
            this.messagesList.add(new Message(this.chatDataList.get(this.currentIndex).getAnswer1(), 2));
            this.adapter.notifyDataSetChanged();
        }
        if (this.currentIndex < this.chatDataList.size()) {
            nextQuestion(this.chatDataList.get(this.currentIndex).getOption1NextQuestionArrayIndex());
            this.recyclerView.scrollToPosition(this.messagesList.size() - 1);
        }
    }

    void m186lambda$onCreate$4$comprankchatmasteractivitiesMainActivity(View view) {
        this.option1.setClickable(false);
        this.option2.setClickable(false);
        if (this.currentIndex < this.chatDataList.size()) {
            this.messagesList.add(new Message(this.chatDataList.get(this.currentIndex).getQuestion2(), 1));
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override // java.lang.Runnable
            public final void run() {
                m185lambda$onCreate$3$comprankchatmasteractivitiesMainActivity();
            }
        }, 1L);
    }

    void m185lambda$onCreate$3$comprankchatmasteractivitiesMainActivity() {
        if (this.currentIndex < this.chatDataList.size() && !this.chatDataList.get(this.currentIndex).getAnswer2().equals("")) {
            this.messagesList.add(new Message(this.chatDataList.get(this.currentIndex).getAnswer2(), 2));
            this.adapter.notifyDataSetChanged();
        }
        if (this.currentIndex < this.chatDataList.size()) {
            nextQuestion(this.chatDataList.get(this.currentIndex).getOption2NextQuestionArrayIndex());
        }
        this.recyclerView.scrollToPosition(this.messagesList.size() - 1);
    }

    private void nextQuestion(int i) {
        this.currentIndex = i;
        if (i == 100) {
            this.option1.setVisibility(View.INVISIBLE);
            this.option2.setVisibility(View.INVISIBLE);
            this.dialog = new LevelCompleteDialog(this, false);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override // java.lang.Runnable
                public final void run() {
                    m31x871b7b2f();
                }
            }, 1500L);
        } else if (i == this.chatDataList.size()) {
            this.option1.setVisibility(View.INVISIBLE);
            this.option2.setVisibility(View.INVISIBLE);
            this.dialog = new LevelCompleteDialog(this, true);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override // java.lang.Runnable
                public final void run() {
                    m30x409308ce();
                }
            }, 1500L);
        } else {
            this.option1.setText(this.chatDataList.get(this.currentIndex).getQuestion1());
            this.option2.setText(this.chatDataList.get(this.currentIndex).getQuestion2());
            this.option1.setClickable(true);
            this.option2.setClickable(true);
        }
    }

    void m31x871b7b2f() {
        this.dialog.show(getFragmentManager(), "MyCustomDialog");
        this.dialog.setCancelable(false);
    }

    void m30x409308ce() {
        this.dialog.show(getFragmentManager(), "MyCustomDialog");
        this.dialog.setCancelable(false);
    }

    @Override
    public void nextButtonClick() {
        if (Preference.getLevel() < 23)
            Preference.setLevel(Preference.getLevel() + 1);
        Preference.setFinalPoints(Preference.getFinalPoints() + 10);
        Utils.IsFromMainScreen = true;
        Intent intent = new Intent(MainActivity.this, LevelActivity.class);
        startActivity(intent);
        finish();

      /*  customDialogClass = new AskOptionsDialog(MainActivity.this, true);
        customDialogClass.show(getFragmentManager(), "ChoiceFragment");*/
    }

    @Override
    public void retryButtonClick() {
        this.messagesList.clear();
        this.option1.setVisibility(View.GONE);
        this.option2.setVisibility(View.GONE);
        if (this.level < this.chatLevels.getChatMasterArrayList().size()) {
            this.option1.setVisibility(View.VISIBLE);
            this.option2.setVisibility(View.VISIBLE);
            this.option1.setClickable(true);
            this.option2.setClickable(true);
            this.currentIndex = 1;
            ArrayList<ChatMaster> arrayList = this.chatLevels.getChatMasterArrayList().get(this.level);
            this.chatDataList = arrayList;
            this.option1.setText(arrayList.get(this.currentIndex).getQuestion1());
            this.option2.setText(this.chatDataList.get(this.currentIndex).getQuestion2());
            this.messagesList.clear();
            this.adapter.notifyDataSetChanged();
            this.chatStartMessage.setText(this.chatDataList.get(0).getQuestion2());
            this.mTitle.setText(this.chatDataList.get(0).getQuestion1());
        }
    }

    @Override
    public void selectionofoption(int position) {
        Preference.setLevel(Preference.getLevel() + 1);
        IncreasePoint();
        int finalpoints = Preference.getFinalPoints();
        txtPoints.setText(finalpoints + "");


        /*if (position == 1) {
            Intent intent = new Intent(MainActivity.this, AiGameActivity.class);
            startActivityForResult(intent, 1010);
        } else if (position == 2) {
            Intent intent = new Intent(MainActivity.this, ScratchActivity.class);
            startActivityForResult(intent, 1010);
        } else if (position == 3) {
            Intent intent = new Intent(MainActivity.this, SpinWinActivity.class);
            startActivityForResult(intent, 1010);
        }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.txtPoints = (TextView) findViewById(R.id.txtPoints);
        txtPoints.setText(Preference.getFinalPoints() + "");
        try {
            nextLevel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closedialog() {
        IncreasePoint();
        nextLevel();
    }

    public void IncreasePoint() {
        int finalpoints = Preference.getFinalPoints() + 10;
        Preference.setFinalPoints(finalpoints);
        txtPoints.setText(finalpoints + "");
    }

    @Override
    public void homeButtonClick() {
        startActivity(new Intent(this, StartActivity.class));
        finish();
    }

    public void loadData() {
        this.level = getSharedPreferences("sharedPrefs", 0).getInt("value", 0);
        Log.e("Level", "" + this.level);
    }

    public void saveData() {
        SharedPreferences.Editor edit = getSharedPreferences("sharedPrefs", 0).edit();
        edit.putInt("value", this.level);
        edit.apply();
    }

    @Override
    public void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, StartActivity.class));
        finish();
    }

    private void nextLevel() {
        this.messagesList.clear();
        this.option1.setVisibility(View.GONE);
        this.option2.setVisibility(View.GONE);
        int i = this.level + 1;
        this.level = i;
        if (i < this.chatLevels.getChatMasterArrayList().size()) {
            this.option1.setVisibility(View.VISIBLE);
            this.option2.setVisibility(View.VISIBLE);
            this.option1.setClickable(true);
            this.option2.setClickable(true);
            this.currentIndex = 1;
            ArrayList<ChatMaster> arrayList = this.chatLevels.getChatMasterArrayList().get(this.level);
            this.chatDataList = arrayList;
            this.option1.setText(arrayList.get(this.currentIndex).getQuestion1());
            this.option2.setText(this.chatDataList.get(this.currentIndex).getQuestion2());
            this.messagesList.clear();
            this.adapter.notifyDataSetChanged();
            this.chatStartMessage.setText(this.chatDataList.get(0).getQuestion2());
            this.mTitle.setText(this.chatDataList.get(0).getQuestion1());
            return;
        }
        finish();
        //  startActivity(getIntent());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1010) {

        }
    }

}
