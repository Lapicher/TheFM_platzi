package com.example.lapicher.thefm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by Nataly on 19/08/2015.
 */
public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
    // La medida en pixeles del espaciado
    private int miItemOffset;

    public ItemOffsetDecoration(Context conte, @IntegerRes int integerResId) {

        int itemOffsetDp = conte.getResources().getInteger(integerResId);
        miItemOffset=convertToPx(itemOffsetDp,conte.getResources().getDisplayMetrics());
    }
    public int convertToPx(int dps, DisplayMetrics metricas) {
        return dps*(metricas.densityDpi/160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(miItemOffset,miItemOffset,miItemOffset,miItemOffset);
    }
}
