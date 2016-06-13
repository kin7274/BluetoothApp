package com.example.student.bluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //블루투스를 제어하기 위해 BluetoothAdapter를 지원한다.
    BluetoothAdapter bluetoothAdapter;
    static final int REQUEST_ENABLE=1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getSupport(){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter == null){
            Toast.makeText(this, "bluetooth is not supported in this device!!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "블루투스 지원 단말기 입니다", Toast.LENGTH_SHORT).show();
        }
    }

    public void turnOn(){
        //유저에게 허락없이 켠다!!
        //bluetoothAdapter.enable();

        //유저에게 허락받고 켠다!!
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(intent, REQUEST_ENABLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_ENABLE){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "블루투스 활성화됨!!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "블루투스 켜야 서비스 이용가능하잔아!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void getPared(){

    }

    public void btnClick(View view){
        switch(view.getId()){
            case R.id.bt_support: getSupport();break;
            case R.id.bt_turnon: turnOn();break;
            case R.id.bt_pared:getPared() ;break;
        }
    }


}
