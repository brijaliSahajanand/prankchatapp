package ru.fotostrana.socketapp.dialog;

import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import ru.fotostrana.socketapp.R;

/* loaded from: classes2.dex */
public class LevelCompleteDialog extends DialogFragment {
    boolean isComplete;
    DialogCLickListener mListener;
    SeekBar seekbar;
    TextView txtPoints;


    public LevelCompleteDialog() {
        this.isComplete = true;
    }

    public LevelCompleteDialog(DialogCLickListener dialogCLickListener, boolean z) {
        this.mListener = dialogCLickListener;
        this.isComplete = z;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_level_complete, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.level_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.level_message);
        TextView txtPoints = (TextView) inflate.findViewById(R.id.txtPoints);
        ImageView imgstar = inflate.findViewById(R.id.imgstar);


        ImageView button = (ImageView) inflate.findViewById(R.id.next);
        ImageView button2 = (ImageView) inflate.findViewById(R.id.home);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.isComplete) {
            txtPoints.setVisibility(View.VISIBLE);
            imgstar.setVisibility(View.VISIBLE);
            textView.setText("Level Complete");
            textView2.setText("Congratulation you pranked well \u1f602");

        } else {
            txtPoints.setVisibility(View.GONE);
            imgstar.setVisibility(View.GONE);

            textView.setText("Level Failed");
            textView2.setText("Your need to prank carefully.!!\nTry Again");
            button.setImageDrawable(getActivity().getDrawable(R.drawable.retry));
        }
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LevelCompleteDialog.this.m29xc13f1288(view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                LevelCompleteDialog.this.m28xb2e8b8a7(view);
            }
        });


        return inflate;
    }

    void m29xc13f1288(View view) {
        this.mListener.homeButtonClick();
        dismiss();
    }

    void m28xb2e8b8a7(View view) {
        if (this.isComplete) {

            this.mListener.nextButtonClick();
            dismiss();
            return;
        }
        this.mListener.retryButtonClick();
        dismiss();
    }
}
