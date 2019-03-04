package liujia.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RelativeLayout splash_root = findViewById(R.id.splash_root);

        //渐变动画，缩放动画，旋转动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1); //Animation 动画 alphaAnimation 应该是阿尔法通道的动画 , 0-1 从看不见到看得见
//        alphaAnimation.setDuration(2000); // duration 持续播放时间（播放时长） ms
        alphaAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
//        scaleAnimation.setDuration(2000);// scale  规模 =size  怎么就成了缩放动画了...
        scaleAnimation.setFillAfter(true);

        RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
//        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);

        AnimationSet set = new AnimationSet(false) ;
        //添加三个动画的没有顺序,便于同事播放
        set.addAnimation(alphaAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(rotateAnimation);
        set.setDuration(2000); //在set中设置时间 取代上面三行代码

        splash_root.startAnimation(set);

    }
}
