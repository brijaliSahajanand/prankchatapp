package ru.fotostrana.socketapp.constant;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ads.adsdemosp.AdsClass.Ads_ExitNativeFull;

import java.util.List;
import java.util.Random;

import ru.fotostrana.socketapp.BuildConfig;
import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.retrofit.Example;

public class Utils {


    public static ProgressDialog new_loader;
    public static Dialog internet_dialog;
    public static no_internet no_internet;
    public static boolean vpnStart = false;
    public static boolean IsFromMainScreen = false;
    private static OnCheckNet onChecknet;

    public interface OnCheckNet {
        void OnCheckNet(boolean b);
    }
    public static Dialog exit_dialog;
    public static void Exit_Dialog(Activity activity) {
        exit_dialog = new Dialog( activity);
        exit_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        LayoutInflater inflater = (LayoutInflater) exit_dialog.getLayoutInflater();
        View customView = inflater.inflate(R.layout.custom_exit_dialog, null);
        exit_dialog.setContentView(customView);

        Window window = exit_dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        window.getDecorView().setSystemUiVisibility(uiOptions);

        exit_dialog.getWindow().setGravity(Gravity.BOTTOM);
        exit_dialog.getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        exit_dialog.getWindow().getAttributes().windowAnimations = R.style.ExitDialogAnimation;
        exit_dialog.setCancelable(true);
        exit_dialog.setCanceledOnTouchOutside(true);
        TextView txt_done = (TextView) exit_dialog.findViewById(R.id.txt_done);

        LinearLayout llline = (LinearLayout) exit_dialog.findViewById(R.id.llline);
        LinearLayout llnative = (LinearLayout) exit_dialog.findViewById(R.id.llnative);
        TextView ad_call_to_action = (TextView) exit_dialog.findViewById(R.id.ad_call_to_action);

        //NativeAds_Sp.NativeExit_Show( First_Activity.this, llnative, llline, ad_call_to_action);
        Ads_ExitNativeFull.Exit_NativeFull_Show(activity, llnative, llline, ad_call_to_action);

        txt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finishAffinity();
            }
        });

        exit_dialog.show();
    }


    static Dialog dialog_simple;
    public static void hideProgressDialog() {
        try {
            if (dialog_simple != null && dialog_simple.isShowing()) {
                dialog_simple.dismiss();
            }
        } catch (NullPointerException n) {
            n.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showProgressDialog(Activity context) {
        try {
            try {
                if (dialog_simple != null && dialog_simple.isShowing()) {
                    dialog_simple.dismiss();
                }
            } catch (NullPointerException n) {
                n.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            dialog_simple = new Dialog(context);
            dialog_simple.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            LayoutInflater inflater = (LayoutInflater) dialog_simple.getLayoutInflater();
            View customView = inflater.inflate(R.layout.custom_progressbar, null);
            dialog_simple.setContentView(customView);
            dialog_simple.setCancelable(false);
            dialog_simple.setCanceledOnTouchOutside(false);
            dialog_simple.show();
        } catch (NullPointerException n) {
            n.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void showAlertDialog(Context context, String title, String msg, String positiveText) {
        androidx.appcompat.app.AlertDialog alertDialog = new androidx.appcompat.app.AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CheckInternetData(context);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onChecknet.OnCheckNet(false);
                    }
                })
                .show();
    }


    private static void CheckInternetData(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            onChecknet.OnCheckNet(true);
        } else {
            try {
                showAlertDialog(context, context.getString(R.string.app_name),
                        context.getString(R.string.disconnected),
                        "Retry");
            } catch (NumberFormatException ex) { // handle your exception
            }
        }
    }
    public static void isConnectingToInternet(Context context, OnCheckNet onChecknets, boolean... booleans) {
        onChecknet = onChecknets;
        CheckInternetData(context);

        // return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void new_loader(Context context, boolean dialog_check) {

        if (dialog_check) {
            new_loader = new ProgressDialog(context);
            try {
                new_loader.show();
            } catch (WindowManager.BadTokenException e) {

            }
            new_loader.setCancelable(false);
            new_loader.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            new_loader.setContentView(R.layout.progressdialog);

        } else {
            if (new_loader != null) {
                new_loader.dismiss();
            }
        }
    }
    public static List<Example.CountryList> country_List = null;

    public static void setUpCountry() {
        Utils.country_List = Preference.getCountry_list();
        int pos = new Random().nextInt(Utils.country_List.size());
        if(Utils.country_List.size() > 2 && Utils.country_List.get(pos).name.equals(Preference.getserver_name())){
            setUpCountry();
            return;
        }

        String selectedCountryCode = Utils.country_List.get(pos).code;
        String selectedCountryName = Utils.country_List.get(pos).name;
        String selectedCountryImage = Utils.country_List.get(pos).cuntryimages;
        Log.d("selectedCountry", "pos = " + pos);
        Log.d("selectedCountry", "selectedCountry = " + selectedCountryCode);
        Log.d("selectedCountry", "selectedCountryName = " + selectedCountryName);
        Preference.set_server_short(selectedCountryCode);
        Preference.setserver_name(selectedCountryName);
        Preference.setServer_image(selectedCountryImage);
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public static void internetDialog(Context context) {
        internet_dialog = new Dialog(context);

        WindowManager.LayoutParams lWindowParams = new WindowManager.LayoutParams();
        lWindowParams.copyFrom(internet_dialog.getWindow().getAttributes());
        lWindowParams.width = WindowManager.LayoutParams.FILL_PARENT;
        lWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        internet_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        internet_dialog.setCancelable(false);
        internet_dialog.setContentView(R.layout.internet_dialogue);
        internet_dialog.show();
        internet_dialog.getWindow().setAttributes(lWindowParams);

        LinearLayout iv_try_again = internet_dialog.findViewById(R.id.ln_try_again);
        iv_try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_internet.no_internet();
            }
        });
    }
    public interface no_internet {
        void no_internet();
    }

    public static void internetcheck(no_internet no_internet) {
        Utils.no_internet = no_internet;
    }


    public static Boolean isdebuggle(Context context) {
        if (BuildConfig.DEBUG) {
            return false;
        }


        if (Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, 0) == 1) {
            // debugging enabled
            Log.d("oncheck_debug", "isdebuggle  true ");
            return true;
        } else {
            Log.d("oncheck_debug", "isdebuggle  false ");
            return false;
            // debugging does not enabled
        }
    }

    public static Dialog warningdialog;
    public static no_debug no_debug;

    public static void Get_Developer_Dialog(Context context) {
        if (warningdialog != null) {
            if (warningdialog.isShowing()) {
                return;
            }
        }
        warningdialog = new Dialog(context);
        warningdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        warningdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        warningdialog.setContentView(R.layout.developer_dialog);
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        final int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        warningdialog.getWindow().setLayout(width, height);
        warningdialog.setCancelable(false);
        warningdialog.show();
        Button btn_recheck = warningdialog.findViewById(R.id.btn_recheck);
        Button btn_turnoff = warningdialog.findViewById(R.id.btn_turnoff);
        btn_recheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isdebuggle(context)) {
                    Log.d("oncheck_debug", "debug truee Utils ");
                } else {
                    no_debug.no_debug();
                }
            }
        });
        btn_turnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                developer_intent(context);
            }
        });
    }

    public static void debug_check(no_debug no_debug) {
        Utils.no_debug = no_debug;
    }

    public static void developer_intent(Context context) {
        context.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
    }

    public interface no_debug {
        void no_debug();
    }



}
