package com.samir.andrew.andrewsamiremiratesauction.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samir.andrew.andrewsamiremiratesauction.R;

import java.text.SimpleDateFormat;
import java.util.TimeZone;


public class CustomItem extends LinearLayout {
    //region fields
    private TextView tvCustomViewItemTitle, tvCustomViewItemValue;
    private View verticalView;
    private CountDownTimer countDownTimer;
    //endregion

    //region constructor
    public CustomItem(Context context) {
        super(context);
        init(context, null);
    }

    public CustomItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    //endregion

    private void init(Context context, @Nullable AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.custom_view_item, this, true);
        tvCustomViewItemTitle = findViewById(R.id.tvCustomViewItemTitle);
        tvCustomViewItemValue = findViewById(R.id.tvCustomViewItemValue);
        verticalView = findViewById(R.id.verticalView);

        if (attrs != null) {
            TypedArray mainTypedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomItem, 0, 0);

            try {
                Boolean ci_isLastItem = mainTypedArray.getBoolean(R.styleable.CustomItem_ci_isLastItem, false);
                if (ci_isLastItem) {
                    verticalView.setVisibility(GONE);
                    tvCustomViewItemValue.setText("00:00:00");
                } else {
                    verticalView.setVisibility(VISIBLE);
                }

                String ci_title = mainTypedArray.getString(R.styleable.CustomItem_ci_title);
                tvCustomViewItemTitle.setText(ci_title);

                String ci_value = mainTypedArray.getString(R.styleable.CustomItem_ci_value);
                tvCustomViewItemValue.setText(ci_value);


            } catch (RuntimeException ex) {

            } finally {
                mainTypedArray.recycle();
            }
        }
    }

    public void setValue(String value) {
        tvCustomViewItemValue.setText(value);
    }

    public void setTimer(Long time, Long interval) {

        if (countDownTimer != null)
            countDownTimer.cancel();

        countDownTimer = new CountDownTimer(time, interval) {
            public void onTick(long millisUntilFinished) {
                tvCustomViewItemValue.setText(getDateFromMillis(millisUntilFinished));

                long fiveMinutesInMilliSeconds = 5 * 60 * 1000;
                if (fiveMinutesInMilliSeconds > millisUntilFinished) {
                    tvCustomViewItemValue.setTextColor(getResources().getColor(R.color.colorRed));
                } else
                    tvCustomViewItemValue.setTextColor(getResources().getColor(R.color.colorBlack));
            }

            public void onFinish() {
                tvCustomViewItemValue.setText("00:00:00");
            }
        }.start();
    }

    public static String getDateFromMillis(long d) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(d);
    }
}
