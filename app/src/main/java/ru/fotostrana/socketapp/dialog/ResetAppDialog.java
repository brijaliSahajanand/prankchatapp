package ru.fotostrana.socketapp.dialog;

import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.fotostrana.socketapp.R;


/* loaded from: classes2.dex */
public class ResetAppDialog extends DialogFragment {
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_reset, viewGroup, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((Button) inflate.findViewById(R.id.btn_no)).setOnClickListener(new View.OnClickListener() { // from class: com.prank.chatmaster.dialogs.ResetAppDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResetAppDialog.this.m27x54858657(view);
            }
        });
        ((Button) inflate.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() { // from class: com.prank.chatmaster.dialogs.ResetAppDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResetAppDialog.this.m26xef2648d8(view);
            }
        });
        return inflate;
    }

    /* renamed from: lambda$onCreateView$0$com-prank-chatmaster-dialogs-ResetAppDialog */
    /* synthetic */ void m27x54858657(View view) {
        getDialog().dismiss();
    }

    /* renamed from: lambda$onCreateView$1$com-prank-chatmaster-dialogs-ResetAppDialog */
    /* synthetic */ void m26xef2648d8(View view) {
        SharedPreferences.Editor edit = getActivity().getSharedPreferences("sharedPrefs", 0).edit();
        edit.putInt("value", 0);
        edit.apply();
        getDialog().dismiss();
    }
}
