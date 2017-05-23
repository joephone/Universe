package com.transcendence.universe.abp.index.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.transcendence.universe.R;
import com.transcendence.universe.abp.index.adapter.IndexAdapter;
import com.transcendence.universe.util.Loger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by joephone on 2017/5/12.
 */
public class IndexAct extends Activity implements IndexAdapter.IndexEvent {

    @Bind(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private String tag = this.getClass().getName();
    private Activity mActivity;
    private IndexAdapter adapter;
    private List<String> sourceList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        ButterKnife.bind(this);

        sourceList.add("基础知识");
        sourceList.add("UI");
        sourceList.add("通信");
        sourceList.add("数据持久化");
        sourceList.add("安全");
        sourceList.add("第三方扩展");
        sourceList.add("其他");

        mActivity = this;

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new IndexAdapter(this,sourceList);
        mRecyclerView.setAdapter(adapter);
        adapter.setEvent(this);
    }

    @Override
    public void onItemClick(int position) {
        Loger.i(tag,"onItemClick");
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent = new Intent(mActivity,UIIndexAct.class);
                break;
            case 1:
                intent = new Intent(mActivity,UIIndexAct.class);
                break;
            case 2:
                intent = new Intent(mActivity,UIIndexAct.class);
                break;
            case 3:
                intent = new Intent(mActivity,UIIndexAct.class);
                break;
            case 4:
                intent = new Intent(mActivity,UIIndexAct.class);
                break;
            case 5:
                intent = new Intent(mActivity,UIIndexAct.class);
                break;
            case 6:
                intent = new Intent(mActivity,ClassicIndexAct.class);
                break;
        }
        startActivity(intent);
    }
}
