package com.lqr.customerview.ui.practice5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lqr.customerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 CSDN_LQR
 * @描述 https://github.com/hencoder/PracticeDraw5
 */
public class PracticeDrawActivity5 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private List<PageModel> mPageModels = new ArrayList<>();

    {
        mPageModels.add(new PageModel("onDraw()-后插", R.layout.fragment_practice_5_after_ondraw));
        mPageModels.add(new PageModel("onDraw()-前插", R.layout.fragment_practice_5_before_ondraw));
        mPageModels.add(new PageModel("onDraw()-在Layout中", R.layout.fragment_practice_5_ondraw_layout));
        mPageModels.add(new PageModel("dispatchDraw()", R.layout.fragment_practice_5_dispatch_draw));
        mPageModels.add(new PageModel("onDrawForeground()-后插", R.layout.fragment_practice_5_after_ondraw_foreground));
        mPageModels.add(new PageModel("onDrawForeground()-前插", R.layout.fragment_practice_5_before_ondraw_foreground));
        mPageModels.add(new PageModel("draw()-后插", R.layout.fragment_practice_5_after_draw));
        mPageModels.add(new PageModel("draw()-前插", R.layout.fragment_practice_5_before_draw));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_draw);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mPager = (ViewPager) findViewById(R.id.pager);

        mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PracticeDrawFragment5.newInstance(mPageModels.get(position).practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return mPageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mPageModels.get(position).title;
            }
        });

        mTabLayout.setupWithViewPager(mPager);
    }

    private class PageModel {
        String title;
        int practiceLayoutRes;

        public PageModel(String title, int practiceLayoutRes) {
            this.title = title;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }

}
