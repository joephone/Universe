package com.transcendence.universe.abp.classic.weiganloopview.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.transcendence.universe.R;
import com.transcendence.universe.abp.classic.weiganloopview.view.LoopView;
import com.transcendence.universe.abp.classic.weiganloopview.view.OnItemSelectedListener;

import java.util.ArrayList;

/**
 * Created by Weidongjian on 2017/3/25.
 */

public class DialogActivity extends AppCompatActivity {

    private Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weigan_dialog);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_view, null);
        dialogBuilder.setView(dialogView);

        LoopView loopView = (LoopView) dialogView.findViewById(R.id.loopView);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("item " + i);
        }
        // 滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (toast == null) {
                    toast = Toast.makeText(DialogActivity.this, "item " + index, Toast.LENGTH_SHORT);
                }
                toast.setText("item " + index);
                toast.show();
            }
        });
        // 设置原始数据
        loopView.setItems(list);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}
