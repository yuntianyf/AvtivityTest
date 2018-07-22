package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is "+getTaskId());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });
                //Toast 测试
                //Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
                //销毁活动测试
                //finish();
                //活动之间跳转测试--显式intent
                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);
                //活动之间跳转测试--隐式intent
//                Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity(intent);
                //用intent调用网页
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);
                //调用拨打电话界面
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
                //intent传递数据
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
                //数据回调
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }
}
