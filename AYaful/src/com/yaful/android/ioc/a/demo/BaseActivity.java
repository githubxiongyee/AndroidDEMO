package com.yaful.android.ioc.a.demo;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yaful.android.R;
import com.yaful.android.ioc.app.Ioc;
import com.yaful.android.ioc.inject.InjectAll;
import com.yaful.android.ioc.inject.InjectInit;
import com.yaful.android.ioc.inject.InjectListener;
import com.yaful.android.ioc.inject.InjectMethod;
import com.yaful.android.ioc.inject.InjectPLayer;
import com.yaful.android.ioc.view.listener.OnClick;
import com.yaful.android.util.Handler_TextStyle;

@InjectPLayer(R.layout.activity_com)
public  class BaseActivity extends FragmentActivity {
	
	@InjectAll
	Views v;
	
	 class Views{
		 TextView tv_top;
	}
	
	@InjectInit
	private void init() {
		Ioc.getIoc().getLogger().s("公共类的初始化");
		v.tv_top.setText("父类对顶部文字进行填充");
	}

	// 这里是第一种交互事件注入方式（单击）
	@InjectMethod(@InjectListener(ids = { R.id.top, R.id.bottom }, listeners = { OnClick.class }))
	private void click2(View view) {
		Handler_TextStyle handler_TextStyle = new Handler_TextStyle();
		switch (view.getId()) {
		case R.id.top:
			handler_TextStyle.setString("点击了顶部按钮(在基类中统一注册,也可以单独注册)");
			handler_TextStyle.setBackgroundColor(Color.RED, 3, 5);
			Toast.makeText(this, handler_TextStyle.getSpannableString(), Toast.LENGTH_LONG).show();
			break;
		case R.id.bottom:
			handler_TextStyle.setString("点击了底部按钮(在基类中统一注册,也可以单独注册)");
			handler_TextStyle.setBackgroundColor(Color.RED, 3, 5);
			Toast.makeText(this, handler_TextStyle.getSpannableString(), Toast.LENGTH_LONG).show();
			break;
		}
	}
}
