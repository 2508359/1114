package com.example.pintu1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.*;

public class GameActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
   
      Button btn_01=(Button)findViewById(R.id.btn_01);
      btn_01.setOnClickListener(new View.OnClickListener() {
	  @Override
		    public void onClick(View V) {
			  Intent intent = new Intent(GameActivity.this,MainActivity.class); 
	          startActivity(intent);
		  }
	
	  });

}
}





