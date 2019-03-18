package com.dimples.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dimples.component.ViewInject;
import com.dimples.mvp.view.LifeCircleMvpActivity;

import butterknife.ButterKnife;

@SuppressLint("Registered")
public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (null != annotation) {
            if (annotation.LayoutId() == -1) {
                throw new RuntimeException("LayoutId = 默认值(未注册)");
            } else {
                setContentView(annotation.LayoutId());
                bindView();
                afterBindView();
            }
        } else {
            throw new RuntimeException("annotation = null");
        }
    }

    /**
     * 模板方法  设计模式
     */
    public abstract void afterBindView();

    /**
     * View的依赖注解绑定
     */
    private void bindView() {
        ButterKnife.bind(this);
    }
}
