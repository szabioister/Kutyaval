package com.kutyaval;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class KutyavalActivity extends FBConnectionActivity {
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
	    	
		    pbLogin = (ProgressBar) findViewById(R.id.progressLogin);
		    btnLogin = (Button) findViewById(R.id.buttonLogin);
	        btnLogin.setOnClickListener(new OnClickListener() {
	                @Override
	                public void onClick(View arg0) {
	                        pbLogin.setVisibility(ProgressBar.VISIBLE);
	                        setConnection();
	                        getID(uid, pbLogin);
	                }
	        });
	    }
	}
}