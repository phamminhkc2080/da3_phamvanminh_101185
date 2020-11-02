package com.example.da3_phamvanminh_101185;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.List;

public class customCauTraLoi extends BaseAdapter {
    private String [] suggestSource;
    private Context context;
    private VaoChoi mainActivity;

    public customCauTraLoi(String [] suggestSource, Context context, VaoChoi mainActivity) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount() {
        return suggestSource.length;
    }

    @Override
    public Object getItem(int i) {
        return suggestSource[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Button button;
        if(view==null){
            if(suggestSource[i].equals("null")){
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.DKGRAY);

            }else{
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.DKGRAY);
                button.setTextColor(Color.YELLOW);
                button.setText(suggestSource[i]);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(String.valueOf(mainActivity.ctl).contains(suggestSource[i])){
                            String compare = String.valueOf(suggestSource[i].charAt(0));
                            for(int i =0;i<mainActivity.ctl.length;i++){
                                if(compare==mainActivity.ctl[i]){
                                    Common.user_submit_answer[i]=compare;
                                }
                            }

                            customDapAn answerAdapter=new customDapAn(Common.user_submit_answer,context);
                            mainActivity.gridViewDapAn.setAdapter(answerAdapter);
                            answerAdapter.notifyDataSetChanged();

                            mainActivity.ctl[i]="null";
                            mainActivity.customCauTraLoi=new customCauTraLoi(mainActivity.ctl,context,mainActivity);
                            mainActivity.gridViewCauTraLoi.setAdapter(mainActivity.customCauTraLoi);
                            mainActivity.customCauTraLoi.notifyDataSetChanged();
                        }else {

                            mainActivity.ctl[i]="null";
                            mainActivity.customCauTraLoi=new customCauTraLoi(mainActivity.ctl,context,mainActivity);
                            mainActivity.gridViewCauTraLoi.setAdapter(mainActivity.customCauTraLoi);
                            mainActivity.customCauTraLoi.notifyDataSetChanged();
                        }
                    }
                });
            }
        }else {
            button = (Button)view;
        }
        return button;
    }
}
