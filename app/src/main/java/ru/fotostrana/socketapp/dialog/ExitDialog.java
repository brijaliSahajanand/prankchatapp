package ru.fotostrana.socketapp.dialog;

import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.fotostrana.socketapp.R;


/* loaded from: classes2.dex */
public class ExitDialog extends DialogFragment {
    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_exit, viewGroup, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((Button) inflate.findViewById(R.id.btn_no)).setOnClickListener(new View.OnClickListener() { // from class: com.prank.chatmaster.dialogs.ExitDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExitDialog.this.m192lambda$onCreateView$0$comprankchatmasterdialogsExitDialog(view);
            }
        });
        ((Button) inflate.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() { // from class: com.prank.chatmaster.dialogs.ExitDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                getDialog().dismiss();
                getActivity().moveTaskToBack(true);
            }
        });
        return inflate;
    }

    void m192lambda$onCreateView$0$comprankchatmasterdialogsExitDialog(View view) {
        getDialog().dismiss();
    }
}
