package com.dimples.ui.main;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.dimples.R;
import com.dimples.base.BaseActivity;
import com.dimples.component.ViewInject;

import butterknife.BindView;


@ViewInject(LayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView {

    @BindView(R.id.fab_float_main)
    FloatingActionButton fabFloatMain;
    @BindView(R.id.fl_content_main)
    FrameLayout flContentMain;
    @BindView(R.id.bnv_bottom_main)
    BottomNavigationView bnvBottomMain;
    private IMainActivityContract.IPresenter presenter = new MainActivityPresenter(this);

    @Override
    public void afterBindView() {
        initMainFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initMainFragment() {
        presenter.initMainFragment();
    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content_main, fragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

}
