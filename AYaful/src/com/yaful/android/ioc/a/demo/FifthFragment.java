package com.yaful.android.ioc.a.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.yaful.android.R;
import com.yaful.android.ioc.inject.InjectListener;
import com.yaful.android.ioc.inject.InjectMethod;
import com.yaful.android.ioc.inject.InjectView;
import com.yaful.android.ioc.verification.Rule;
import com.yaful.android.ioc.verification.Validator;
import com.yaful.android.ioc.verification.Validator.ValidationListener;
import com.yaful.android.ioc.verification.annotation.Checked;
import com.yaful.android.ioc.verification.annotation.ConfirmPassword;
import com.yaful.android.ioc.verification.annotation.Email;
import com.yaful.android.ioc.verification.annotation.IpAddress;
import com.yaful.android.ioc.verification.annotation.NumberRule;
import com.yaful.android.ioc.verification.annotation.NumberRule.NumberType;
import com.yaful.android.ioc.verification.annotation.Password;
import com.yaful.android.ioc.verification.annotation.Regex;
import com.yaful.android.ioc.verification.annotation.Required;
import com.yaful.android.ioc.verification.annotation.TextRule;
import com.yaful.android.ioc.view.listener.OnClick;
import com.yaful.android.util.Handler_Inject;
import com.yaful.android.util.Handler_TextStyle;

public class FifthFragment extends BaseFragment implements ValidationListener {
	@Password(message = "请输入密码", order = 1)
	@InjectView
	EditText a;
	@ConfirmPassword(messageResId = R.string.err, order = 2)
	@InjectView
	EditText b;
	@Email(empty = false, message = "邮箱格式错误", order = 3)
	@InjectView
	EditText c;
	@IpAddress(message = "IP格式错误", order = 4)
	@InjectView
	EditText d;
	@NumberRule(type = NumberType.INTEGER,lt =1000,gt=1, message = "输入数字错误", order = 5)
	@InjectView
	EditText e;
	@Regex(message = "输入内容错误", trim = true, pattern = "[a-zA-Z0-9_]{6,15}", order = 6)
	@InjectView
	EditText f;
	@Required(message = "不能为空", order = 7)
	@InjectView
	EditText g;
	@TextRule(maxLength = 4, minLength = 2, message = "文字长度错误", order = 8)
	@InjectView
	EditText h;
	@Checked(checked = true, message = "必须选中服务条款", order = 9)
	@InjectView
	CheckBox checkbox1;
	
	Validator validator;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.inflater = inflater;
		View rootView = inflater.inflate(R.layout.fragment_main5, container, false);
		Handler_Inject.injectFragment(this, rootView);
		return rootView;
	}

	@InjectMethod(@InjectListener(ids = { R.id.judge }, listeners = { OnClick.class }))
	public void click() {
		//这里是做验证
		validator = new Validator(this);
		validator.setValidationListener(this);
		validator.validate();
	}

	@Override
    public void onValidationSucceeded() {
		Toast.makeText(activity, "验证通过", Toast.LENGTH_SHORT).show();
    }

	/**
	 * 提示的形式可以自己定义
	 */
	@Override
    public void onValidationFailed(View failedView, Rule<?> failedRule) {
		String message = failedRule.getFailureMessage();
		if (failedView instanceof EditText) {
			failedView.requestFocus();
			Handler_TextStyle handler_TextStyle = new Handler_TextStyle();
			handler_TextStyle.setString(message);
			handler_TextStyle.setBackgroundColor(Color.RED, 0, message.length());
			((EditText) failedView).setError(handler_TextStyle.getSpannableString());
		} else {
			Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
		}
    }
}
