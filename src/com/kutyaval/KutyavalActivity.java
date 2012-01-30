package com.kutyaval;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class KutyavalActivity extends FBConnectionActivity {
    private TextView txtUserName;
    private ProgressBar pbLogin;
    private Button btnLogin;
   
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    txtUserName = (TextView) findViewById(R.id.textFacebook);
	    pbLogin = (ProgressBar) findViewById(R.id.progressLogin);
	    btnLogin = (Button) findViewById(R.id.buttonLogin);
	            btnLogin.setOnClickListener(new OnClickListener() {
	                    @Override
	                    public void onClick(View arg0) {
	                            pbLogin.setVisibility(ProgressBar.VISIBLE);
	                            setConnection();
	                            getID(txtUserName, pbLogin);
	                    }
	            });
	}
}