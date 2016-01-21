package com.keyhua.renameyourself.main.chat.recorderview;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.importotherlib.R;


/**
 * Created by yz1309 on 2015/5/1.
 */
public class DialogManager {
    private Dialog mDialog;

    private ImageView mIcon;
    private ImageView mVoice;
    private TextView mLable;
    private Context mContext;

    public DialogManager(Context context) {
        mContext = context;
    }

    public void showRecordingDialog() {
        mDialog = new Dialog(mContext, R.style.ThemeAudioDialog);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.dialog_record, null);
        mDialog.setContentView(view);
        mIcon = (ImageView) mDialog.findViewById(R.id.id_recorder_dialog_icon);
        mVoice = (ImageView) mDialog.findViewById(R.id.id_recorder_dialog_voice);
        mLable = (TextView) mDialog.findViewById(R.id.id_recorder_dialog_label);
        mDialog.show();

    }

    public void recording() {
        if(mDialog != null && mDialog.isShowing()){
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.VISIBLE);
            mLable.setVisibility(View.VISIBLE);
            mIcon.setImageResource(R.mipmap.recorder);
            mLable.setText("手指上滑,取消发送");
        }
    }

    public void wantToCancel() {

        if(mDialog != null && mDialog.isShowing()){
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLable.setVisibility(View.VISIBLE);
            mIcon.setImageResource(R.mipmap.cancel);
            mLable.setText("松开手指,取消发送");
        }
    }

    public void tooShort() {
        if(mDialog != null && mDialog.isShowing()){
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLable.setVisibility(View.VISIBLE);
            mIcon.setImageResource(R.mipmap.voice_to_short);
            mLable.setText("录音时间过短");
        }

    }

    public void dimissDialog() {
        if(mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
            mDialog = null;
        }

    }

    public void updateVoiceLevel(int level) {
        if(mDialog != null && mDialog.isShowing()){
            /*mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.VISIBLE);
            mLable.setVisibility(View.VISIBLE);*/

            /**/
            int resID = mContext.getResources()
                    .getIdentifier("v"+level,"mipmap",mContext.getPackageName());
            mVoice.setImageResource(resID);
        }
    }
}
