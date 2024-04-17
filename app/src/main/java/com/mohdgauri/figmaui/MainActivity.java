package com.mohdgauri.figmaui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mohdgauri.figmaui.HomeScreens.ChatFrag;
import com.mohdgauri.figmaui.HomeScreens.HomeFrag;
import com.mohdgauri.figmaui.HomeScreens.ProfileFrag;
import com.mohdgauri.figmaui.HomeScreens.ShoppingFrag;

public class MainActivity extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        fragment = new HomeFrag();
        setFragment(fragment);

    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragment).commit();
    }

    public void hideNavBtn(boolean hide){
        WindowInsetsControllerCompat windowInsetsController =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if (windowInsetsController == null) {
            return;
        }
        windowInsetsController.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE);

        if(hide) {
            windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars());
        }
        else
        {
            windowInsetsController.show(WindowInsetsCompat.Type.navigationBars());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        hideNavBtn(true);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavBtn(true);
    }

}