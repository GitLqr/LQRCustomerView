package com.lqr.customerview.ui.practice4;

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
 * @描述 https://github.com/hencoder/PracticeDraw4
 */
public class PracticeDrawActivity4 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private List<PageModel> mPageModels = new ArrayList<>();

    {
        mPageModels.add(new PageModel("clipRect()", R.layout.fragment_practice_4_clip_rect));
        mPageModels.add(new PageModel("clipPath()", R.layout.fragment_practice_4_clip_path));
        mPageModels.add(new PageModel("translate()", R.layout.fragment_practice_4_translate));
        mPageModels.add(new PageModel("scale()", R.layout.fragment_practice_4_scale));
        mPageModels.add(new PageModel("rotate()", R.layout.fragment_practice_4_rotate));
        mPageModels.add(new PageModel("skew()", R.layout.fragment_practice_4_skew));
        mPageModels.add(new PageModel("Matrix.translate()", R.layout.fragment_practice_4_matrix_translate));
        mPageModels.add(new PageModel("Matrix.scale()", R.layout.fragment_practice_4_matrix_scale));
        mPageModels.add(new PageModel("Matrix.rotate()", R.layout.fragment_practice_4_matrix_rotate));
        mPageModels.add(new PageModel("Matrix.skew()", R.layout.fragment_practice_4_matrix_skew));
        mPageModels.add(new PageModel("Camera.rotateX/Y()", R.layout.fragment_practice_4_camera_rotate));
        mPageModels.add(new PageModel("Camera.rotateX/Y()修正版", R.layout.fragment_practice_4_camera_rotate_fixed));
        mPageModels.add(new PageModel("Camera.rotateX/Y()糊脸修正", R.layout.fragment_practice_4_camera_rotate_hitting_face));
        mPageModels.add(new PageModel("翻页效果", R.layout.fragment_practice_4_flipboard));
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
                return PracticeDrawFragment4.newInstance(mPageModels.get(position).practiceLayoutRes);
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
