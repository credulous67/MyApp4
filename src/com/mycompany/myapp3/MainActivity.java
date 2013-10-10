package com.mycompany.myapp3;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.app.AlertDialog.Builder;
import android.content.pm.*;
import java.util.*;
import android.content.*;

public class MainActivity extends Activity implements View.OnClickListener
{
	EditText txtName;
	Button btnOk,btnCancel,btnList;
	PackageManager packageManager;
    ListView apkList;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/* Referencing controls */
		txtName=(EditText)findViewById(R.id.txtName);
		btnOk=(Button)findViewById(R.id.btnOk);
		btnCancel=(Button)findViewById(R.id.btnCancel);
		/* Registering the onClick event of the buttons */
		btnOk.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
	}
	public void onClick(View view)
	{
		if(view==btnOk)
		{
			/* Display Welcome message */
			Builder builder=new Builder(this);
			builder.setTitle("Welcome to Android");
			builder.setMessage("Hello "+txtName.getText()+"!!!");
			builder.setCancelable(true);
			builder.show();
		}
		if(view==btnCancel)
		{
			/* Clear the EditText */
			txtName.setText("");
			txtName.requestFocus();
		}
		if(view==btnList)
		{
			setContentView(R.layout.listapps);

			PackageManager packageManager = getPackageManager();
			List<PackageInfo> packageList = packageManager
				.getInstalledPackages(PackageManager.GET_PERMISSIONS);
/*			ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout
				.simple_list_item_1, myStringArray); */
			ListView listView = (ListView) findViewById(R.id.applist);
			listView.setAdapter(new ApkAdapter(this, packageList, packageManager));
//        apkList = (ListView) findViewById(R.id.applist);
//       apkList.setAdapter(new ApkAdapter(this, packageList, packageManager));

//        apkList.setOnItemClickListener(this);
//			Intent appInfo = new Intent(getApplicationContext(), ApkInfo.class);
//			startActivity(appInfo);
		}
	}
}
