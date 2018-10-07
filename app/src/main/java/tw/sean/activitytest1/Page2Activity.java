package tw.sean.activitytest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Page2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }

    public void test2(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();//加上此行，切換頁面時，此舊頁面會從記憶體堆疊中被殺掉。新頁面會new出來
    }
}
