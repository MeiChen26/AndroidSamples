package neusoft.soft.coffeestore.view;

import org.apache.http.Header;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import neusoft.soft.coffeestore.view.R;


public class RegisterActivity extends Activity {
	private EditText etUsername;
	private EditText etPassword;
	private EditText etPasswordAgain;
	
	private Button btnBack;

	private TextView tvTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.CustomTheme);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_register_username);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
		
		etUsername = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_password);
		etPasswordAgain = (EditText) findViewById(R.id.et_passwordAgain);
		
		btnBack = (Button) findViewById(R.id.btn_first);
	
		tvTitle = (TextView) findViewById(R.id.tv_title);
		
		btnBack.setBackgroundResource(R.drawable.img_back);
		
		tvTitle.setText("注册");
		

		Register1OnClickListener register1OnClickListener = new Register1OnClickListener();

		btnBack.setOnClickListener(register1OnClickListener);
		
	}
	
	
	
	class Register1OnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			//������һ���İ�ť������
			if(v.getId() == R.id.btn_first) {
				Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.back_out, R.anim.back_in);
			}
			//��һ����ť������
			else if (v.getId() == R.id.btn_second) {
				String userName = etUsername.getText().toString();
				String password = etPassword.getText().toString();
				String passwordAgain = etPasswordAgain.getText().toString();
				
				if(userName.equals("")) { //����û���Ϊ��
					Toast.makeText(getApplicationContext(), "�û�������Ϊ��", Toast.LENGTH_LONG).show();
				}
				else if(password.equals("")) { //�������Ϊ��
					Toast.makeText(getApplicationContext(), "���벻��Ϊ��", Toast.LENGTH_LONG).show();
				}
				else if(passwordAgain.equals("")) { //���ȷ������Ϊ��
					Toast.makeText(getApplicationContext(), "ȷ�����벻��Ϊ��", Toast.LENGTH_LONG).show();
				}
				else if(!password.equals(passwordAgain)) { //���������������벻��ͬ
					Toast.makeText(getApplicationContext(), "�����������������ͬ", Toast.LENGTH_LONG).show();
				}
				else{


					
				}
			}
		}
	}
	
	
}
