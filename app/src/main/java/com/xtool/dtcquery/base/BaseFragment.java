package com.xtool.dtcquery.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xtool.dtcquery.mvp.view.MainActivity;
import com.xtool.dtcquery.utils.RxBus;
import com.xtool.dtcquery.widget.ProgressDialog;

/**
 * Created by xtool on 2017/9/14.
 */

public abstract class BaseFragment extends Fragment implements BaseFragmentView{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unSubscribe();
    }

    @Override
    public void showProgressDialog() {
        BaseActivity.progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        BaseActivity.progressDialog.dismiss();
    }


    public void showToast(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
    }

    protected abstract View initView(LayoutInflater inflater);

    @Override
    public void switchFragment(Fragment fragment) {
        ((MainActivity)getActivity()).switchFragment(fragment);
    }
}
