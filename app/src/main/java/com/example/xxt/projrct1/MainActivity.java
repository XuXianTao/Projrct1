package com.example.xxt.projrct1;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public void init(){

    }

    private void snank_mes(){
        Toast.makeText(MainActivity.this,"Snackbar 的确定按钮被点击了",Toast.LENGTH_SHORT).show();
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
                    public void onClick(View view){
                        snank_mes();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setDuration(5000)
                .show();
    }
    public void check_t(View view){
        Snackbar.make((View)findViewById(R.id.radioGroup),"您选择了教职工",Snackbar.LENGTH_SHORT)
                .setAction("确定",new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        snank_mes();
                    }
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
        String user = u.getText().toString();
        String password = p.getText().toString();
        if (user.isEmpty()) {
            u_mes.setErrorEnabled(true);
            u_mes.setError("学号不能为空");
        } else if (password.isEmpty()) {
            u_mes.setErrorEnabled(false);
            p_mes.setErrorEnabled(true);
            p_mes.setError("密码不能为空");
        } else if (user.equals("123456")&&password.equals("6666")) {
            u_mes.setErrorEnabled(false);
            p_mes.setErrorEnabled(false);
            Snackbar.make((View) findViewById(R.id.radioGroup), "登陆成功", Snackbar.LENGTH_SHORT)
                    .setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            snank_mes();
                        }
                    })
                    .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                    .setDuration(5000)
                    .show();
        }
        else {
            u_mes.setErrorEnabled(false);
            p_mes.setErrorEnabled(false);
            Snackbar.make((View) findViewById(R.id.radioGroup), "学号或密码错误", Snackbar.LENGTH_SHORT)
                    .setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            snank_mes();
                        }
                    })
                    .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                    .setDuration(5000)
                    .show();
        }
    }

    public void signup(View view){
        RadioGroup mradiogroup=(RadioGroup)findViewById(R.id.radioGroup);
        int c_id=mradiogroup.getCheckedRadioButtonId();
        RadioButton ra=(RadioButton)findViewById(c_id);
        Snackbar.make(mradiogroup,ra.getText()+"注册功能尚未启用",Snackbar.LENGTH_SHORT)
                .setAction("确定",new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        snank_mes();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setDuration(5000)
                .show();
    }
    //判断小键盘是否出现的函数，来自http://blog.csdn.net/sinat_31311947/article/details/53899166
    private boolean isSoftShowing() {
        //获取当前屏幕内容的高度
        int screenHeight = getWindow().getDecorView().getHeight();
        //获取View可见区域的bottom
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        return screenHeight - rect.bottom != 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputLayout u_mes = (TextInputLayout) findViewById(R.id.editText2);
        final TextInputLayout p_mes = (TextInputLayout) findViewById(R.id.editText);
        final EditText u = (EditText) findViewById(R.id.user_id);
        final EditText p = (EditText) findViewById(R.id.user_password);


        u.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                u_mes.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        p.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                p_mes.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
