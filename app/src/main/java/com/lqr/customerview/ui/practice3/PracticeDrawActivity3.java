package com.lqr.customerview.ui.practice3;

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
 * @描述 https://github.com/hencoder/PracticeDraw3
 */
public class PracticeDrawActivity3 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private List<PageModel> mPageModels = new ArrayList<>();

    {
        mPageModels.add(new PageModel("drawText()", R.layout.fragment_practice_3_draw_text));
        mPageModels.add(new PageModel("StaticLayout", R.layout.fragment_practice_3_static_layout));
        mPageModels.add(new PageModel("setTextSize()", R.layout.fragment_practice_3_text_size));
        mPageModels.add(new PageModel("setTypeface()", R.layout.fragment_practice_3_typeface));
        mPageModels.add(new PageModel("setFakeBoldText()", R.layout.fragment_practice_3_fake_bold));
        mPageModels.add(new PageModel("setStrikeThruText()", R.layout.fragment_practice_3_strike_thru));
        mPageModels.add(new PageModel("setUnderlineText()", R.layout.fragment_practice_3_underline));
        mPageModels.add(new PageModel("setTextSkewX()", R.layout.fragment_practice_3_text_skewx));
        mPageModels.add(new PageModel("setTextScaleX()", R.layout.fragment_practice_3_text_scalex));
        mPageModels.add(new PageModel("setTextAlign()", R.layout.fragment_practice_3_text_align));
        mPageModels.add(new PageModel("getFontSpacing()", R.layout.fragment_practice_3_font_spacing));
        mPageModels.add(new PageModel("measureText()", R.layout.fragment_practice_3_measure_text));
        mPageModels.add(new PageModel("getTextBounds()", R.layout.fragment_practice_3_text_bounds));
        mPageModels.add(new PageModel("getFontMetrics()", R.layout.fragment_practice_3_font_metrics));
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
                return PracticeDrawFragment3.newInstance(mPageModels.get(position).practiceLayoutRes);
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
