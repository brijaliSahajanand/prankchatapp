package ru.fotostrana.socketapp.constant;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ru.fotostrana.socketapp.MyAppDefult;
import ru.fotostrana.socketapp.retrofit.Example;

public class Preference {
    public static String SetFinalPoints = "SetFinalPoints";
    private static final String used_spin = "used_spin";
    private static final String total_spin = "total_spin";
    private static final String level = "level";
    private static final String StateNameVN = "StateNameVN";
    private static final String CountryNmeVN = "CountryNmeVN";
    private static final String CityNmeVN = "CityNmeVN";
    private static final String ads_click = "ads_click"; //i
    private static final String maintenance = "maintenance";  //i
    private static final String back_click = "back_click";  //i
    private static final String _id = "_id";
    private static final String Package = "package";
    private static final String version_name = "version_name";
    private static final String app_msg = "app_msg";
    private static final String update_url = "update_url";
    private static final String is_update = "is_update";
    private static final String ads_type = "ads_type";
    private static final String splash_ads_type = "splash_ads_type";
    private static final String link = "link";
    private static final String privacy_policy = "privacy_policy";
    private static final String vn_header_show = "vn_header_show";
    private static final String appOpen_click = "appOpen_click";
    private static final String appOpen_back_click = "appOpen_back_click";
    private static final String appOpen_inter_show = "appOpen_inter_show";
    private static final String privacy_policy_html = "privacy_policy_html";
    private static final String native_button_color = "native_button_color";
    private static final String native_btn_text_color = "native_btn_text_color";
    private static final String comingsoon = "comingsoon";
    private static final String quiz_header_show = "quiz_header_show";
    private static final String letsgoscreen = "letsgoscreen";
    private static final String nextscreen = "nextscreen";
    private static final String native_by_page = "native_by_page";
    private static final String quiz_show = "quiz_show";
    private static final String country_list = "country_list";
    private static final String url_type = "url_type";
    private static final String url_default = "url_default";
    private static final String is_big_native_quiz = "is_big_native_quiz";
    private static final String is_small_native_quiz = "is_small_native_quiz";
    private static final String admob_reward_id = "admob_reward_id";
    private static final String fb_native_id = "fb_native_id";
    private static final String fb_native_banner_id = "fb_native_banner_id";
    private static final String fb_interstitial_id = "fb_interstitial_id";
    private static final String Vn_direct_connect = "Vn_direct_connect";
    private static final String fullads_array_int = "fullads_array_int";
    private static final String native_array_int = "native_array_int";
    private static final String nativeBanner_array_int = "nativeBanner_array_int";
    private static final String OpenAds_array_int = "OpenAds_array_int";
    private static final String vnid = "vnid";
    private static final String vnpassword = "vnpassword";
    private static final String VPN_Show = "VPN_Show";
    private static final String isBottom_native = "isBottom_native";
    private static final String bottomads_type = "bottomads_type";
    private static final String admob_page = "admob_page";
    private static final String inter_admob = "inter_admob";
    private static final String native_admob = "native_admob";
    private static final String banner_admob = "banner_quiz";
    private static final String ads_open_admob = "ads_open_admob";
    private static final String inter_back_admob = "inter_back_admob";
    private static final String rendomserver = "rendomserver";
    private static final String server_short = "server_short";
    private static final String server_name = "server_name";
    private static final String server_image = "server_image";
    private static final String buttonanimate = "buttonanimate";
    private static final String animationtype = "animationtype";
    private static final String button_animation_native = "button_animation_native";
    private static final String native_btn_type = "native_btn_type";
    private static final String admob_native_content_text_color = "admob_native_content_text_color";
    private static final String admob_native_bg_color = "admob_native_bg_color";
    private static final String fb_native_btn_color = "fb_native_btn_color";
    private static final String fb_native_btn_text_color = "fb_native_btn_text_color";
    private static final String fb_native_content_text_color = "fb_native_content_text_color";
    private static final String fb_native_bg_color = "fb_native_bg_color";
    private static final String screenshow = "screenshow";
    private static final String ad_one_by_one_ids = "ad_one_by_one_ids";
    private static final String isVpnConnect = "isVpnConnect";
    private static final String aura_user_id = "aura_user_id";
    private static final String accessToken = "accessToken";

    public static void setAccessToken(String value) {
        get().edit().putString(accessToken, value).apply();
    }

    public static String getAccessToken() {
        return get().getString(accessToken, "");
    }

    public static void setAura_user_id(long value) {
        get().edit().putLong(aura_user_id, value).apply();
    }
    public static long getAura_user_id() {
        return get().getLong(aura_user_id, 0);
    }

    public static void setad_one_by_one_ids(boolean value) {
        get().edit().putBoolean(ad_one_by_one_ids, value).apply();
    }

    public static boolean getad_one_by_one_ids() {
        return get().getBoolean(ad_one_by_one_ids, false);
    }

    public static void setscreenshow(Integer value) {
        get().edit().putInt(screenshow, value).apply();
    }

    public static Integer getscreenshow() {
        return get().getInt(screenshow, 1);
    }


    public static void setfb_native_bg_color(String value) {
        get().edit().putString(fb_native_bg_color, value).apply();
    }

    public static String getfb_native_bg_color() {
        return get().getString(fb_native_bg_color, "");
    }


    public static void setfb_native_content_text_color(String value) {
        get().edit().putString(fb_native_content_text_color, value).apply();
    }

    public static String getfb_native_content_text_color() {
        return get().getString(fb_native_content_text_color, "");
    }


    public static void setfb_native_btn_text_color(String value) {
        get().edit().putString(fb_native_btn_text_color, value).apply();
    }

    public static String getfb_native_btn_text_color() {
        return get().getString(fb_native_btn_text_color, "");
    }
    public static void setfb_native_btn_color(String value) {
        get().edit().putString(fb_native_btn_color, value).apply();
    }

    public static String getfb_native_btn_color() {
        return get().getString(fb_native_btn_color, "");
    }
    public static void setadmob_native_bg_color(String value) {
        get().edit().putString(admob_native_bg_color, value).apply();
    }

    public static String getadmob_native_bg_color() {
        return get().getString(admob_native_bg_color, "");
    }

    public static void setadmob_native_content_text_color(String value) {
        get().edit().putString(admob_native_content_text_color, value).apply();
    }

    public static String getadmob_native_content_text_color() {
        return get().getString(admob_native_content_text_color, "");
    }

    public static String getNative_btn_type() {
        return get().getString(native_btn_type, "small");
    }

    public static void setNative_btn_type(String value) {
        get().edit().putString(native_btn_type, value).apply();
    }

    public static Boolean getButton_animation_native() {
        return get().getBoolean(button_animation_native, true);
    }

    public static void setButton_animation_native(Boolean value) {
        get().edit().putBoolean(button_animation_native, value).apply();
    }


    public static void setbuttonanimate(boolean value) {
        get().edit().putBoolean(buttonanimate, value).apply();
    }

    public static boolean getbuttonanimate() {
        return get().getBoolean(buttonanimate, false);
    }

    public static void setanimationtype(String value) {
        get().edit().putString(animationtype, value).apply();
    }

    public static String getanimationtype() {
        return get().getString(animationtype, "alpha");
    }


    public static void setServer_image(String value) {
        get().edit().putString(server_image, value).apply();
    }

    public static String getServer_image() {
        return get().getString(server_image, "");
    }


    public static void setserver_name(String value) {
        get().edit().putString(server_name, value).apply();
    }

    public static String getserver_name() {
        return get().getString(server_name, "");
    }


    public static void set_server_short(String value) {
        get().edit().putString(server_short, value).apply();
    }

    public static String getServer_short() {
        return get().getString(server_short, "US");
    }



    public static void setRendomserver(boolean value) {
        get().edit().putBoolean(rendomserver, value).apply();
    }

    public static boolean getRendomserver() {
        return get().getBoolean(rendomserver, false);
    }



    public static void setInter_back_admob(Integer value) {
        get().edit().putInt(inter_back_admob, value).apply();
    }

    public static Integer getInter_back_admob() {
        return get().getInt(inter_back_admob, 3);
    }



    public static void setAds_open_admob(Integer value) {
        get().edit().putInt(ads_open_admob, value).apply();
    }

    public static Integer getAds_open_admob() {
        return get().getInt(ads_open_admob, 3);
    }


    public static void setbanner_admob(Integer value) {
        get().edit().putInt(banner_admob, value).apply();
    }

    public static Integer getbanner_admob() {
        return get().getInt(banner_admob, 3);
    }




    public static void setnative_admob(Integer value) {
        get().edit().putInt(native_admob, value).apply();
    }

    public static Integer getnative_admob() {
        return get().getInt(native_admob, 3);
    }


    public static void setinter_admob(Integer value) {
        get().edit().putInt(inter_admob, value).apply();
    }

    public static Integer getinter_admob() {
        return get().getInt(inter_admob, 3);
    }


    public static void setAdmob_page(boolean value) {
        get().edit().putBoolean(admob_page, value).apply();
    }

    public static boolean getAdmob_page() {
        return get().getBoolean(admob_page, false);
    }



    public static void setBottomads_type(String value) {
        get().edit().putString(bottomads_type, value).apply();
    }

    public static String getBottomads_type() {
        return get().getString(bottomads_type, "nativebanner");
    }


    public static void setisBottom_native(boolean value) {
        get().edit().putBoolean(isBottom_native, value).apply();
    }

    public static boolean getisBottom_native() {
        return get().getBoolean(isBottom_native, false);
    }


    public static void setVPN_Show(boolean value) {
        get().edit().putBoolean(VPN_Show, value).apply();
    }

    public static boolean getVPN_Show() {
        return get().getBoolean(VPN_Show, false);
    }


    public static String getVnpassword() {
        return get().getString(vnpassword, "ZEziW6v0O3");
    }

    public static void setVnpassword(String value) {
        get().edit().putString(vnpassword, value).apply();
    }

    public static String getVnid() {
        return get().getString(vnid, "no_vpn");
    }

    public static void setVnid(String value) {
        get().edit().putString(vnid, value).apply();
    }


    public static void setOpenAdsArrayINT(int ad_type) {
        get().edit().putInt(OpenAds_array_int, ad_type).apply();
    }

    public static void setNativeArrayINT(int ad_type) {
        get().edit().putInt(native_array_int, ad_type).apply();
    }

    public static void setNativeBannerArrayINT(int ad_type) {
        get().edit().putInt(nativeBanner_array_int, ad_type).apply();
    }

    public static void setFulladsArrayINT(int ad_type) {
        get().edit().putInt(fullads_array_int, ad_type).apply();
    }


    public static void setVn_direct_connect(boolean value) {
        get().edit().putBoolean(Vn_direct_connect, value).apply();
    }

    public static boolean getVn_direct_connect() {
        return get().getBoolean(Vn_direct_connect, false);
    }


    public static void setFb_interstitial_id(String value) {
        get().edit().putString(fb_interstitial_id, value).apply();
    }

    public static String getFb_interstitial_id() {
        return get().getString(fb_interstitial_id, "");
    }


    public static void setFb_native_banner_id(String value) {
        get().edit().putString(fb_native_banner_id, value).apply();
    }

    public static String getFb_native_banner_id() {
        return get().getString(fb_native_banner_id, "");
    }


    public static void setFb_native_id(String value) {
        get().edit().putString(fb_native_id, value).apply();
    }

    public static String getFb_native_id() {
        return get().getString(fb_native_id, "");
    }


    public static void setadmob_reward_id(String value) {
        get().edit().putString(admob_reward_id, value).apply();
    }

    public static String getadmob_reward_id() {
        return get().getString(admob_reward_id, "");
    }


    public static void setIs_small_native_quiz(boolean value) {
        get().edit().putBoolean(is_small_native_quiz, value).apply();
    }

    public static boolean getIs_small_native_quiz() {
        return get().getBoolean(is_small_native_quiz, false);
    }

    public static void setIs_big_native_quiz(boolean value) {
        get().edit().putBoolean(is_big_native_quiz, value).apply();
    }

    public static boolean getIs_big_native_quiz() {
        return get().getBoolean(is_big_native_quiz, false);
    }

    public static void setUrl_default(String value) {
        get().edit().putString(url_default, value).apply();
    }

    public static String getUrl_default() {
        return get().getString(url_default, "https://d2isj403unfbyl.cloudfront.net");
    }

    public static void setUrl_type(Boolean value) {
        get().edit().putBoolean(url_type, value).apply();
    }

    public static Boolean getUrl_type() {
        return get().getBoolean(url_type, false);
    }


    public static void setquiz_show(boolean value) {
        get().edit().putBoolean(quiz_show, value).apply();
    }

    public static boolean getquiz_show() {
        return get().getBoolean(quiz_show, false);
    }


    public static void setNative_by_page(Integer value) {
        get().edit().putInt(native_by_page, value).apply();
    }

    public static Integer getNative_by_page() {
        return get().getInt(native_by_page, 1);
    }


    public static void setNextscreen(boolean value) {
        get().edit().putBoolean(nextscreen, value).apply();
    }

    public static boolean getNextscreen() {
        return get().getBoolean(nextscreen, false);
    }


    public static void setLetsgoscreen(boolean value) {
        get().edit().putBoolean(letsgoscreen, value).apply();
    }

    public static boolean getLetsgoscreen() {
        return get().getBoolean(letsgoscreen, false);
    }


    public static void setquiz_header_show(boolean value) {
        get().edit().putBoolean(quiz_header_show, value).apply();
    }

    public static boolean getquiz_header_show() {
        return get().getBoolean(quiz_header_show, false);
    }


    public static void setcomingsoon(boolean value) {
        get().edit().putBoolean(comingsoon, value).apply();
    }

    public static boolean getcomingsoon() {
        return get().getBoolean(comingsoon, false);
    }


    public static void setnative_btn_text_color(String value) {
        get().edit().putString(native_btn_text_color, value).apply();
    }

    public static String getnative_btn_text_color() {
        return get().getString(native_btn_text_color, "#ffffff");
    }

    public static void setnative_button_color(String value) {
        get().edit().putString(native_button_color, value).apply();
    }

    public static String getnative_button_color() {
        return get().getString(native_button_color, "#ffffff");
    }


    public static void setPrivacy_policy_html(String value) {
        get().edit().putString(privacy_policy_html, value).apply();
    }

    public static String getPrivacy_policy_html() {
        return get().getString(privacy_policy_html, "");
    }

    public static void setAppOpen_inter_show(boolean value) {
        get().edit().putBoolean(appOpen_inter_show, value).apply();
    }

    public static boolean getAppOpen_inter_show() {
        return get().getBoolean(appOpen_inter_show, false);
    }


    public static void setAppOpen_back_click(int value) {
        get().edit().putInt(appOpen_back_click, value).apply();
    }

    public static int getAppOpen_back_click() {
        return get().getInt(appOpen_back_click, 0);
    }


    public static void setis_update(boolean value) {
        get().edit().putBoolean(is_update, value).apply();
    }

    public static boolean getis_update() {
        return get().getBoolean(is_update, false);
    }

    public static void setapp_msg(String value) {
        get().edit().putString(app_msg, value).apply();
    }

    public static String getapp_msg() {
        return get().getString(app_msg, "");
    }


    public static void setupdate_url(String value) {
        get().edit().putString(update_url, value).apply();
    }

    public static String getupdate_url() {
        return get().getString(update_url, "");
    }

    public static void setStateNameVN(String value) {
        get().edit().putString(StateNameVN, value).apply();
    }

    public static String getStateNameVN() {
        return get().getString(StateNameVN, "");
    }

    public static void setCountryNmeVN(String value) {
        get().edit().putString(CountryNmeVN, value).apply();
    }

    public static void setVn_header_show(boolean value) {
        get().edit().putBoolean(vn_header_show, value).apply();
    }

    public static boolean getVn_header_show() {
        return get().getBoolean(vn_header_show, false);
    }


    public static String getCountryNmeVN() {
        return get().getString(CountryNmeVN, "");
    }

    public static void setCityNmeVN(String value) {
        get().edit().putString(CityNmeVN, value).apply();
    }

    public static void setsplash_ads_type(String value) {
        get().edit().putString(splash_ads_type, value).apply();
    }

    public static void setprivacy_policy(String value) {
        get().edit().putString(privacy_policy, value).apply();
    }

    public static String getprivacy_policy() {
        return get().getString(privacy_policy, "");
    }


    public static String getsplash_ads_type() {
        return get().getString(splash_ads_type, "");
    }

    public static void setlink(String value) {
        get().edit().putString(link, value).apply();
    }

    public static String getlink() {
        return get().getString(link, "");
    }


    public static String getCityNmeVN() {
        return get().getString(CityNmeVN, "");
    }

    public static void setads_click(int value) {
        get().edit().putInt(ads_click, value).apply();
    }

    public static int getads_click() {
        return get().getInt(ads_click, 0);
    }

    public static void setmaintenance(Boolean value) {
        get().edit().putBoolean(maintenance, value).apply();
    }

    public static Boolean getmaintenance() {
        return get().getBoolean(maintenance, false);
    }

    public static void setback_click(int value) {
        get().edit().putInt(back_click, value).apply();
    }

    public static int getback_click() {
        return get().getInt(back_click, 0);
    }


    public static void set_id(String value) {
        get().edit().putString(_id, value).apply();
    }

    public static String get_id() {
        return get().getString(_id, "");
    }


    public static void setversion_name(String value) {
        get().edit().putString(version_name, value).apply();
    }

    public static String getversion_name() {
        return get().getString(version_name, "");
    }


    private static SharedPreferences get() {
        return MyAppDefult.getApp().getSharedPreferences(
                "Appcontroller", Context.MODE_PRIVATE);
    }


    public static void setPackage(String value) {
        get().edit().putString(Package, value).apply();
    }

    public static String getPackage() {
        return get().getString(Package, "");
    }


    public static void setads_type(String value) {
        get().edit().putString(ads_type, value).apply();
    }

    public static String getads_type() {
        return get().getString(ads_type, "");
    }


    public static void setFinalPoints(int value) {
        get().edit().putInt(SetFinalPoints, value).apply();
    }

    public static int getFinalPoints() {
        return get().getInt(SetFinalPoints, 0);
    }


    public static Integer getUsed_Spin() {
        return get().getInt(used_spin, 0);
    }

    public static void setUsed_Spin(Integer value) {
        get().edit().putInt(used_spin, value).apply();
    }

    public static Integer getTotal_spin() {
        return get().getInt(total_spin, 0);
    }

    public static void setTotal_spin(Integer value) {
        get().edit().putInt(total_spin, value).apply();
    }

    public static Integer getLevel() {
        return get().getInt(level, 0);
    }

    public static void setLevel(Integer value) {
        get().edit().putInt(level, value).apply();
    }


    public static void setAppOpen_click(int value) {
        get().edit().putInt(appOpen_click, value).apply();
    }

    public static int getAppOpen_click() {
        return get().getInt(appOpen_click, 0);
    }

    public static List<Example.CountryList> getCountry_list() {
        Gson gson = new Gson();
        String json = get().getString(country_list, null);
        Type type = new TypeToken<ArrayList<Example.CountryList>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    public static void setCountry_list(List<Example.CountryList> playlistArray) {
        Gson gson = new Gson();
        String hashMapString = gson.toJson(playlistArray);
        get().edit().putString(country_list, hashMapString).apply();

    }
    public static boolean getisVpnConnect() {
        return get().getBoolean(isVpnConnect, false);
    }

    public static void setisVpnConnect(boolean value) {
        get().edit().putBoolean(isVpnConnect, value).apply();
    }


}
