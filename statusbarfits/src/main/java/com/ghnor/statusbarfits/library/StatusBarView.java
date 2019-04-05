package com.ghnor.statusbarfits.library;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import static com.ghnor.statusbarfits.library.StatusBarUtils.getStatusBarHeight;


/**
 * Created by ghnor on 2016/12/18.
 * ghnor.me@gmail.com
 */

public class StatusBarView extends View {
    public StatusBarView(Context context) {
        super(context);
    }

    public StatusBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StatusBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 创建半透明矩形 View
     *
     * @param alpha 透明值
     * @return 半透明 View
     */
    public static StatusBarView createTranslucentStatusBarView(Activity activity, int alpha) {
        return createStatusBarView(activity, Color.argb(alpha, 0, 0, 0), -1);
    }

    /**
     * 生成一个和状态栏大小相同的矩形条
     *
     * @param activity 需要设置的 activity
     * @param color    状态栏颜色值
     * @return 状态栏矩形条
     */
    public static StatusBarView createStatusBarView(Activity activity, @ColorInt int color) {
        return createStatusBarView(activity, color, -1);
    }

    /**
     * 生成一个和状态栏大小相同的矩形条
     *
     * @param activity 需要设置的activity
     * @param color    状态栏颜色值
     * @param alpha    透明值
     * @return 状态栏矩形条
     */
    public static StatusBarView createStatusBarView(Activity activity, @ColorInt int color, int alpha) {
        // 绘制一个和状态栏一样高的矩形
        StatusBarView statusBarView = new StatusBarView(activity);
        ViewGroup.LayoutParams params =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        if (alpha < 0 || alpha > 1 ) { //不需要计算透明度
            statusBarView.setBackgroundColor(color);
        } else {
            statusBarView.setBackgroundColor(StatusBarUtils.calculateStatusColor(color, alpha));
        }
        return statusBarView;
    }

}
