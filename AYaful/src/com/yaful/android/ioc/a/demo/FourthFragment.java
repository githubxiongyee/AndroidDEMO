package com.yaful.android.ioc.a.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaful.android.R;
import com.yaful.android.ioc.event.EventBus;
import com.yaful.android.ioc.inject.InjectListener;
import com.yaful.android.ioc.inject.InjectMethod;
import com.yaful.android.ioc.view.listener.OnClick;
import com.yaful.android.util.Handler_Inject;

/**
 * 跨进程通信
 * @author gdpancheng@gmail.com 2014-1-22 下午10:37:26
 */
public class FourthFragment extends BaseFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main4, container, false);
		Handler_Inject.injectFragment(this, rootView);
		return rootView;
	}

	@InjectMethod(@InjectListener(ids = { R.id.send }, listeners = { OnClick.class }))
	private void button() {
		//此处发送的消息 就像发送广播一样 这里只有监听了SendEntity这个的才会接收到消息
		EventBus eventBus = EventBus.getDefault();
		eventBus.post(new SendEntity());
	}
}
