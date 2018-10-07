package tw.sean.activitytest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long lastBackTime = 0;

    public MainActivity() {
        Log.d( "brad",  "MainActivity()");
    }

    /*
     * switch to page2
     */
    public void test1(View view){
        //從哪裡去哪裡.class，在手機中任一class在記憶體中的位址只有一個
        Intent intent = new Intent(this, Page2Activity.class);
        startActivity(intent);
        super.finish();//加上此行，切換頁面時，此舊頁面會從記憶體堆疊中被殺掉。新頁面會new出來
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("brad",  "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("brad","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("brad","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("brad","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("brad","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("brad","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("brad","onDestory");
    }
    //呼叫finish()方法，自殺，生命週期走的路線與按下"back"相同，onPause,onStop,onDestory.
    //非正規用法
    public void die(View view) {
        finish();
    }

    //方法二
    @Override
    public void onBackPressed() {
        //super.onBackPressed();//會去呼叫super.finish()，若註解掉，則系統back鍵失效，只能由設計的結束鍵finish()
        Log.d("brad","onBackPressed()");
    }

    //方法一
    @Override
    public void finish() {
        //Log.d("brad","before super.finish()");//收尾動作要寫在super.finish()之前
        //super.finish();//真正的死點在此，觸發super.finish
        //Log.d("brad","after super.finish()");

        long nowTime = System.currentTimeMillis();

        if (nowTime - lastBackTime <= 3*1000 ){
            super.finish();
        }else {
            Toast.makeText(this, "在按一次就離開", Toast.LENGTH_SHORT).show();
            lastBackTime = nowTime;
        }

    }
}
