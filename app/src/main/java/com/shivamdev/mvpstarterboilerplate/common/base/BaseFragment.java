package com.shivamdev.mvpstarterboilerplate.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shivamdev.mvpstarterboilerplate.common.MvpApp;
import com.shivamdev.mvpstarterboilerplate.di.component.DaggerFragmentComponent;
import com.shivamdev.mvpstarterboilerplate.di.component.FragmentComponent;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by shivam on 9/5/17.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;
    private FragmentComponent component;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getComponent());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getLayout();

    protected abstract FragmentComponent inject(FragmentComponent component);

    private FragmentComponent getComponent() {
        if (component == null) {
            component = DaggerFragmentComponent.builder()
                    .appComponent(MvpApp.getInstance().getComponent())
                    .build();
        }
        return component;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        RefWatcher refWatcher = MvpApp.getRefWatcher();
        refWatcher.watch(this);
    }
}