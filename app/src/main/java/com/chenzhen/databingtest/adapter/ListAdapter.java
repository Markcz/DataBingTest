package com.chenzhen.databingtest.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by chenzhen on 2018/3/23.
 */

public class ListAdapter<T> extends BaseAdapter {


    Context mContext;
    List<T> mList;
    int mLayoutId;
    int mVariableId;

    public ListAdapter() {

    }

    public ListAdapter(Context mContext, List<T> mList, int mLayoutId, int mVariableId) {
        this.mContext = mContext;
        this.mList = mList;
        this.mLayoutId = mLayoutId;
        this.mVariableId = mVariableId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i) ;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewDataBinding binding = null;
        if (view == null){
            binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),mLayoutId,viewGroup,false);
        }else {
            binding = DataBindingUtil.getBinding(view);
        }
        binding.setVariable(mVariableId,mList.get(i));
        return binding.getRoot();
    }
}
