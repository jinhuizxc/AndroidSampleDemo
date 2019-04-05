package com.jh.letterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jh.letterview.widget.LetterGridView;

/**
 * LetterView 一个可以选择字母完成单词的小控件
 * https://github.com/dengzq/LetterView
 */
public class MainActivity extends AppCompatActivity {

    private LetterGridView mLetterGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLetterGridView= (LetterGridView) findViewById(R.id.lgl);
        mLetterGridView.setWords("大雄");
        mLetterGridView.setWords("我爱你");
        mLetterGridView.setWords("胖虎和静香");
        mLetterGridView.setWords("路飞");
        mLetterGridView.setWords("索隆");
    }
}
