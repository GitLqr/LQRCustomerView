package com.lqr.customerview.ui.practice6;

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
 * @描述 https://github.com/hencoder/PracticeDraw6
 */
public class PracticeDrawActivity6 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private List<PageModel> mPageModels = new ArrayList<>();

    {
        mPageModels.add(new PageModel("translationX/Y/Z()", R.layout.fragment_practice_6_translation));
        mPageModels.add(new PageModel("rotationX/Y()", R.layout.fragment_practice_6_rotation));
        mPageModels.add(new PageModel("scaleX/Y()", R.layout.fragment_practice_6_scale));
        mPageModels.add(new PageModel("alpha()", R.layout.fragment_practice_6_alpha));
        mPageModels.add(new PageModel("ViewPropertyAnimator-多属性", R.layout.fragment_practice_6_multi_properties));
        mPageModels.add(new PageModel("setDuration()", R.layout.fragment_practice_6_duration));
        mPageModels.add(new PageModel("setInterpolator()", R.layout.fragment_practice_6_interpolator));
        mPageModels.add(new PageModel("ObjectAnimator()", R.layout.fragment_practice_6_object_animator));
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
                return PracticeDrawFragment6.newInstance(mPageModels.get(position).practiceLayoutRes);
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
