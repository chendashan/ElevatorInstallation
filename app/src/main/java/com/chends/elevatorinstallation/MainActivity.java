package com.chends.elevatorinstallation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.chends.elevatorinstallation.adapter.ViewPagerAdapter;
import com.chends.elevatorinstallation.fragment.ViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;

    private ViewPager mViewPager;

    private List<Fragment> mFragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();

    }

    private void initView() {
        rb1 = findViewById(R.id.rb_bottom_1);
        rb2 = findViewById(R.id.rb_bottom_2);
        rb3 = findViewById(R.id.rb_bottom_3);
        rb4 = findViewById(R.id.rb_bottom_4);
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);

        mViewPager = findViewById(R.id.view_pager);

        int[] arr1 = {R.drawable.hj_01, R.drawable.hj_02, R.drawable.hj_03, R.drawable.hj_04, R.drawable.hj_05, R.drawable.hj_06, R.drawable.hj_07,
                R.drawable.hj_08, R.drawable.hj_09, R.drawable.hj_10, R.drawable.hj_11, R.drawable.hj_12, R.drawable.hj_13, R.drawable.hj_14,
                R.drawable.hj_15, R.drawable.hj_16, R.drawable.hj_17};
        int[] arr2 = {R.drawable.jg_01, R.drawable.jg_02, R.drawable.jg_03, R.drawable.jg_04, R.drawable.jg_05, R.drawable.jg_06, R.drawable.jg_07,
                R.drawable.jg_08, R.drawable.jg_09, R.drawable.jg_10, R.drawable.jg_11, R.drawable.jg_12, R.drawable.jg_13, R.drawable.jg_14,
                R.drawable.jg_15, R.drawable.jg_16, R.drawable.jg_17, R.drawable.jg_18, R.drawable.jg_19, R.drawable.jg_20, R.drawable.jg_21, R.drawable.jg_22};
        int[] arr3 = {R.drawable.az_01, R.drawable.az_02, R.drawable.az_03, R.drawable.az_04, R.drawable.az_05, R.drawable.az_06, R.drawable.az_07,
                R.drawable.az_08, R.drawable.az_09, R.drawable.az_10, R.drawable.az_11, R.drawable.az_12};
        int[] arr4 = {};


        ViewFragment mFragment1 = ViewFragment.newInstance(arr1);
        ViewFragment mFragment2 = ViewFragment.newInstance(arr2);
        ViewFragment mFragment3 = ViewFragment.newInstance(arr3);
        ViewFragment mFragment4 = ViewFragment.newInstance(arr4);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(mFragment1);
        mFragmentList.add(mFragment2);
        mFragmentList.add(mFragment3);
        mFragmentList.add(mFragment4);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        rb1.setChecked(true);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb1.setChecked(true);
                        break;
                    case 1:
                        rb2.setChecked(true);
                        break;
                    case 2:
                        rb3.setChecked(true);
                        break;
                    case 3:
                        rb4.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.fl_content, mFragment);
//        transaction.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_bottom_1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.rb_bottom_2:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.rb_bottom_3:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.rb_bottom_4:
                mViewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
