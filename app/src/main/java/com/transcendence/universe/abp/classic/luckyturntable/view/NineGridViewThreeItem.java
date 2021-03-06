package com.transcendence.universe.abp.classic.luckyturntable.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.transcendence.universe.R;

/**
 * Created by jeanboy on 2017/4/20.
 */

public class NineGridViewThreeItem extends FrameLayout implements ItemView{

    private View overlay;

    public NineGridViewThreeItem(Context context) {
        this(context, null);
    }

    public NineGridViewThreeItem(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NineGridViewThreeItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.nine_grid_lucky3_panel_item, this);
        overlay = findViewById(R.id.overlay);
    }

    @Override
    public void setFocus(boolean isFocused) {
        if (overlay != null) {
            overlay.setVisibility(isFocused ? INVISIBLE : VISIBLE);
        }
    }

}
