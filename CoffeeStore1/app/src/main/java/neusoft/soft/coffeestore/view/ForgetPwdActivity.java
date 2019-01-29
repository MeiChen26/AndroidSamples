package neusoft.soft.coffeestore.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import neusoft.soft.coffeestore.view.R;

/**
 找回密码
 */
public class ForgetPwdActivity extends Activity {
	private EditText etPhoneNumber;
	private EditText etNewPassword;
	private EditText etCaptcha;
	private Button btnVerify;
	private Button btnFinish;
	private ButtonTimeCount btnTimeCount;
	
	private Button btnBack;
	private TextView tvTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.CustomTheme);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_forget_password);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
		
		etPhoneNumber = (EditText) findViewById(R.id.et_phoneNumber);
		etNewPassword = (EditText) findViewById(R.id.et_newPassword);
		etCaptcha = (EditText) findViewById(R.id.et_captcha);
		btnVerify = (Button) findViewById(R.id.btn_verify);
		btnFinish = (Button) findViewById(R.id.btn_finish);
		btnBack = (Button) findViewById(R.id.btn_first);
		tvTitle = (TextView) findViewById(R.id.tv_title);
		
		btnBack.setBackgroundResource(R.drawable.img_back);
		tvTitle.setText(R.string.find_password);
		
		btnTimeCount = new ButtonTimeCount(60000, 1000);
		
		btnBack.setOnClickListener(new ButtonBackClickListener());
		btnVerify.setOnClickListener(new ButtonVerifyClickListener());
	}
	
	/**
	 * 
	 * @ClassName:ButtonBackClickListener
	 * @Description:���ص���¼����
	 * @author zhangshengjian
	 * @date 2014-12-16����7:48:08
	 *
	 */
	class ButtonBackClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(ForgetPwdActivity.this, LoginActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.back_out, R.anim.back_in);
		}
	}
	
	/**
	 * 
	 * @ClassName:ButtonVerifyClickListener
	 * @Description:��ȡ��֤��İ�ť������
	 * @author zhangshengjian
	 * @date 2014-12-20����11:13:07
	 *
	 */
	class ButtonVerifyClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			btnTimeCount.start();
		}
	}
	
	/**
	 * 
	 * @ClassName:ButtonTimeCount
	 * @Description:�һ�����ʱ��֤�ֻ�����
	 * @author zhangshengjian
	 * @date 2014-12-16����9:10:06
	 *
	 */
	class ButtonTimeCount extends CountDownTimer {

		/**
		 * @param millisInFuture ��ʱ��
		 * @param countDownInterval	��ʱ��ʱ����
		 */
		public ButtonTimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		/**
		 * ��ʱ���ʱ����
		 */
		@Override
		public void onFinish() {
			btnVerify.setText(R.string.verify_phone);
			btnVerify.setClickable(true);
		}

		/**
		 * ��ʱ������ʾ
		 */
		@Override
		public void onTick(long millisUntilFinished) {
			btnVerify.setClickable(false);
			btnVerify.setTextColor(Color.WHITE);
			btnVerify.setText((millisUntilFinished/1000) + "��");
		}

	}
	
}
