package com.snowofsunflower.android.ui.talker;

import android.app.Activity;

import com.snowofsunflower.android.ui.talkerimpl.AskTalker;
import com.snowofsunflower.android.ui.talkerimpl.HoldTalker;
import com.snowofsunflower.android.ui.talkerimpl.PromptTalker;
import com.snowofsunflower.ui_component.R;

/**
 * Created by zhouztashin on 2018/10/21.
 * 提供对话框工厂
 */

public class EnjoyTalkers {


    /**
     * 加载对话框
     *
     * @param activity
     * @return
     */
    public static IHoldTalker hold(Activity activity) {
        HoldTalker holdTalker = new HoldTalker(activity);
        holdTalker.about(activity.getString(R.string.talk_default_title));
        return holdTalker;
    }

    /**
     * 提问对话框
     *
     * @param activity
     * @return
     */
    public static IAskTalker ask(Activity activity) {
        AskTalker askTalker = new AskTalker(activity);
        askTalker.about(activity.getString(R.string.talk_default_title));
        askTalker.noText(activity.getString(R.string.talk_default_no_text));
        askTalker.yesText(activity.getString(R.string.talk_default_yes_text));
        return askTalker;
    }

    /**
     * 提示对话框
     *
     * @param activity
     * @return
     */
    public static IPromptTalker prompt(Activity activity) {
        PromptTalker promptTalker = new PromptTalker(activity);
        promptTalker.about(activity.getString(R.string.talk_default_title));
        promptTalker.reactText(activity.getString(R.string.talk_default_rect_text));
        return promptTalker;
    }

}
