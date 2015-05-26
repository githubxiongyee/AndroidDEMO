package com.yaful.android.ioc.a.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaful.android.R;
import com.yaful.android.util.Handler_Inject;

/*
 * Author: pan Email:gdpancheng@gmail.com
 * Created Date:2014-1-21
 * Copyright @ 2014 BU
 * Description: 类描述
 *
 * History:
 */
public class HomeFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		Handler_Inject.injectFragment(this, rootView);
		return rootView;
	}
}
