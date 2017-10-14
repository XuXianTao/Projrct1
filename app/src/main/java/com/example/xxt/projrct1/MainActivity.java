package com.example.xxt.projrct1;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public void init(){

    }
    public void im_build_dialog(View view){
        final String[] items=new String[]{"拍摄","从相册中选择"};
        AlertDialog.Builder im_mes=new AlertDialog.Builder(this)
                .setTitle("上传头像")
                .setItems(items,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"您选择了["+items[which]+"]",Toast.LENGTH_SHORT).show();
                    }
                })

                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"您选择了[取消]",Toast.LENGTH_SHORT).show();
                    }
                })
                ;
        im_mes.create();
        im_mes.show();
    }

    public void check_s(View view){
        Snackbar.make((View)findViewById(R.id.radioGroup),"您选择了学生",Snackbar.LENGTH_SHORT)
                .setAction("确定",new View.OnClickListener(){
                    @Override
                    public void onClick(View view){}
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setDuration(5000)
                .show();
    }
    public void check_t(View view){
        Snackbar.make((View)findViewById(R.id.radioGroup),"您选择了教职工",Snackbar.LENGTH_SHORT)
                .setAction("确定",new View.OnClickListener(){
                    @Override
                    public void onClick(View view){}
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setDuration(5000)
                .show();
    }

    public void login(View view){
        EditText u=(EditText)findViewById(R.id.user_id);
        EditText p=(EditText)findViewById(R.id.user_password);
        TextInputLayout u_mes=(TextInputLayout)findViewById(R.id.editText2);
        TextInputLayout p_mes=(TextInputLayout)findViewById(R.id.editText);
        ImageView im=(ImageView)findViewById(R.id.imageView) ;
        String user = u.getText().toString();
        String password = p.getText().toString();
        im.requestFocus();
        if (user.isEmpty()) {
            u_mes.setErrorEnabled(true);
            u_mes.setError("学号不能为空");
        } else u_mes.setErrorEnabled(false);
        if (password.isEmpty()) {
            p_mes.setErrorEnabled(true);
            p_mes.setError("密码不能为空");
        } else p_mes.setErrorEnabled(false);
        if (user.equals("123456")&&password.equals("6666"))
            Snackbar.make((View)findViewById(R.id.radioGroup),"登陆成功",Snackbar.LENGTH_SHORT)
                    .setAction("确定",new View.OnClickListener(){
                        @Override
                        public void onClick(View view){}
                    })
                    .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                    .setDuration(5000)
                    .show();
        else if (!user.isEmpty()&&!password.isEmpty())
            Snackbar.make((View)findViewById(R.id.radioGroup),"学号或密码错误",Snackbar.LENGTH_SHORT)
                .setAction("确定",new View.OnClickListener(){
                    @Override
                    public void onClick(View view){}
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setDuration(5000)
                .show();
    }

    public void signup(View view){
        RadioGroup mradiogroup=(RadioGroup)findViewById(R.id.radioGroup);
        int c_id=mradiogroup.getCheckedRadioButtonId();
        RadioButton ra=(RadioButton)findViewById(c_id);
        Snackbar.make(mradiogroup,ra.getText()+"注册功能尚未启用",Snackbar.LENGTH_SHORT)
                .setAction("确定",new View.OnClickListener(){
                    @Override
                    public void onClick(View view){}
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setDuration(5000)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
