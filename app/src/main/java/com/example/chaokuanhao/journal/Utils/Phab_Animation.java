package com.example.chaokuanhao.journal.Utils;

import android.content.Context;
import android.graphics.Interpolator;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.example.chaokuanhao.journal.R;

import java.text.AttributedCharacterIterator;

/**
 * Created by chaokuanhao on 14/10/2017.
 */

/**
 * the main function of this class is that when the snack bar appears, the button will move~
 */

public class Phab_Animation extends FloatingActionButton.Behavior {


    private static final android.view.animation.Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private boolean mIsAnimatingOut = false;
    public Phab_Animation(Context context, AttributedCharacterIterator.Attribute attrs){
        super();
    }
}
