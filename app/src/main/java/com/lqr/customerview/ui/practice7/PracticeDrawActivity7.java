package com.lqr.customerview.ui.practice7;

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
 * @描述 https://github.com/hencoder/PracticeDraw7
 */
public class PracticeDrawActivity7 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private List<PageModel> mPageModels = new ArrayList<>();

    {
        mPageModels.add(new PageModel("ArgbEvaluator", R.layout.fragment_practice_7_argb_evaluator));
        mPageModels.add(new PageModel("HsvEvaluator", R.layout.fragment_practice_7_hsv_evaluator));
        mPageModels.add(new PageModel("ofObject()", R.layout.fragment_practice_7_of_object));
        mPageModels.add(new PageModel("PropertyValuesHolder", R.layout.fragment_practice_7_property_values_holder));
        mPageModels.add(new PageModel("AnimatorSet", R.layout.fragment_practice_7_animator_set));
        mPageModels.add(new PageModel("PropertyValuesHolder.ofKeyframe()", R.layout.fragment_practice_7_key_frame));
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
                return PracticeDrawFragment7.newInstance(mPageModels.get(position).practiceLayoutRes);
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
