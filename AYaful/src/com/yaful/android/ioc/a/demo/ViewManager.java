package com.yaful.android.ioc.a.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yaful.android.R;
import com.yaful.android.ioc.inject.InjectBinder;
import com.yaful.android.ioc.inject.InjectView;
import com.yaful.android.ioc.view.listener.OnClick;
import com.yaful.android.util.Handler_Inject;

/**
 * 这种情况下 不支持acitivity生命周期的注解
 * @author gdpancheng@gmail.com 2014-5-20 下午11:13:07
 */
public class ViewManager {

	@InjectView
	TextView test;
	@InjectView(binders = @InjectBinder(method = "click", listeners = { OnClick.class }))
	Button button;
	
	public View getView() {
		LayoutInflater layoutInflater = LayoutInflater.from(MeApplication.app);
		View v = layoutInflater.inflate(R.layout.activity_main5, null);
		Handler_Inject.injectOrther(this, v);
		return v;
	}
	
	private void click(){
		Toast.makeText(MeApplication.app, "这个注解 不是在acitivity中", Toast.LENGTH_SHORT).show();
	}
}
