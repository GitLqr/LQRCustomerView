package com.lqr.customerview.ui.practice1;

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
 * @描述 https://github.com/hencoder/PracticeDraw1
 */
public class PracticeDrawActivity1 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private List<PageModel> mPageModels = new ArrayList<>();

    {
        mPageModels.add(new PageModel("drawColor()", R.layout.fragment_practice_1_color));
        mPageModels.add(new PageModel("drawCircle()", R.layout.fragment_practice_1_circle));
        mPageModels.add(new PageModel("drawRect()", R.layout.fragment_practice_1_rect));
        mPageModels.add(new PageModel("drawPoint()", R.layout.fragment_practice_1_point));
        mPageModels.add(new PageModel("drawOval()", R.layout.fragment_practice_1_oval));
        mPageModels.add(new PageModel("drawLine()", R.layout.fragment_practice_1_line));
        mPageModels.add(new PageModel("drawRoundRect()", R.layout.fragment_practice_1_round_rect));
        mPageModels.add(new PageModel("drawArc()", R.layout.fragment_practice_1_arc));
        mPageModels.add(new PageModel("drawPath()", R.layout.fragment_practice_1_path));
        mPageModels.add(new PageModel("直方图", R.layout.fragment_practice_1_histogram));
        mPageModels.add(new PageModel("饼图", R.layout.fragment_practice_1_pie_chart));
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
                return PracticeDrawFragment1.newInstance(mPageModels.get(position).practiceLayoutRes);
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
