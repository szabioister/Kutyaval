package com.kutyaval;

import android.content.SharedPreferences;
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
    // ez a storage, ahol a pwd tarolodik
    public static final String PREFS_NAME = "Kutyaval";
    private String uid;
   
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    // Restore preferences
	    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    uid = settings.getString("uid", "");
	    if(uid=="") {
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
}