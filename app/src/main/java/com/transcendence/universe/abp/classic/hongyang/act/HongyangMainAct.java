package com.transcendence.universe.abp.classic.hongyang.act;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.transcendence.universe.R;
import com.transcendence.universe.abp.classic.hongyang.view.FeatureView;
import com.transcendence.universe.abp.ui.widget.textview.act.RippleEffectAct;
import com.umeng.analytics.MobclickAgent;

public class HongyangMainAct extends ListActivity {

    private static class DemoDetails {
        private final int titleId;
        private final int descriptionId;
        private final Class<? extends Activity> activityClass;

        public DemoDetails(int titleId, int descriptionId,
                           Class<? extends Activity> activityClass) {
            super();
            this.titleId = titleId;
            this.descriptionId = descriptionId;
            this.activityClass = activityClass;

        }
    }


    private static class CustomArrayAdapter extends ArrayAdapter<DemoDetails> {
        public CustomArrayAdapter(Context context, DemoDetails[] demos) {
            super(context, R.layout.hongyang_main_item, R.id.title, demos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            FeatureView featureView;
            if (convertView instanceof FeatureView) {
                featureView = (FeatureView) convertView;
            } else {
                featureView = new FeatureView(getContext());
            }
            DemoDetails demo = getItem(position);
            featureView.setTitleId(demo.titleId);
            featureView.setDescriptionId(demo.descriptionId);
            return featureView;
        }
    }

    private static final DemoDetails[] demos = {
//            new DemoDetails(R.string.viewpager, R.string.viewpager_descirbe,             //自定义viewpager，美团上方轮播
//                    MyViewPagerActivity.class),
//            new DemoDetails(R.string.viewpager, R.string.viewpager_descirbe2,             //自定义viewpager，美团上方轮播
//                    MyViewPagerActivity2.class),
//            new DemoDetails(R.string.fontOrNenoTextview, R.string.fontOrNenoTextviewDescribe,             //自定义Textview结合LinearGradient和Matrix与TextView的多向字体效果
//                    ColourfulFontOrNeonAcitivity.class),
//            new DemoDetails(R.string.progressCircle, R.string.progressCircleDescribe,             //手动选择程度圆与进度圆（完全自定义）
//                    ProgressCircleActivity.class),
//            new DemoDetails(R.string.circleHead, R.string.circleHeadDescribe,             //里面含有圆形头像的三大方案，其中，最终方案已经彻底封装
//                    ImageViewActivity.class),
//            new DemoDetails(R.string.arcmenu, R.string.arcmenuDescribe,             //卫星导航菜单
//                    ArcMenuActivity.class),
//            new DemoDetails(R.string.flowLayout, R.string.flowLayoutDescribe,             //瀑布流布局
//                    FlowlayoutActivity.class),
            new DemoDetails(R.string.rippleEffect, R.string.rippleEffectDescribe,             //水波纹
                    RippleEffectAct.class),
//            new DemoDetails(R.string.pictureCarousel, R.string.pictureCarouselDescribe,             //图片轮播
//                    PictureCarouselActivity.class),
//            new DemoDetails(R.string.recyclerview, R.string.recyclerviewDescribe,             //recylerview
//                    RecyclerViewActivity.class),
//            new DemoDetails(R.string.circlemenu, R.string.circlemenudescribe,             //鸿洋的圆形菜单
//                    Main2Activity.class),
//            new DemoDetails(R.string.mycirclemenu, R.string.mycirclemenudescribe,             //我自己的圆形菜单
//                    MyCircleMenuActivity.class),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hongyang_main);
        setTitle("鸿洋自定义View的学习系列");
        ListAdapter adapter = new CustomArrayAdapter(
                this.getApplicationContext(), demos);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        DemoDetails demo = (DemoDetails) getListAdapter().getItem(position);
        startActivity(new Intent(this.getApplicationContext(),
                demo.activityClass));
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
