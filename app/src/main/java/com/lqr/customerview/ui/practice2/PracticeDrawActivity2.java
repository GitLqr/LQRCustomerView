package com.lqr.customerview.ui.practice2;

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
 * @描述 https://github.com/hencoder/PracticeDraw2
 */
public class PracticeDrawActivity2 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private List<PageModel> mPageModels = new ArrayList<>();

    {
        mPageModels.add(new PageModel("LinearGradient", R.layout.fragment_practice_2_linear_gradient));
        mPageModels.add(new PageModel("RadialGradient", R.layout.fragment_practice_2_radial_gradient));
        mPageModels.add(new PageModel("SweepGradient", R.layout.fragment_practice_2_sweep_gradient));
        mPageModels.add(new PageModel("BitmapShader", R.layout.fragment_practice_2_bitmap_shader));
        mPageModels.add(new PageModel("ComposeShader", R.layout.fragment_practice_2_compose_shader));
        mPageModels.add(new PageModel("LightingColorFilter", R.layout.fragment_practice_2_lighting_color_filter));
        mPageModels.add(new PageModel("ColorMatrixColorFilter", R.layout.fragment_practice_2_color_matrix_color_filter));
        mPageModels.add(new PageModel("setXfermode()", R.layout.fragment_practice_2_xfermode));
        mPageModels.add(new PageModel("setStrokeCap()", R.layout.fragment_practice_2_stroke_cap));
        mPageModels.add(new PageModel("setStrokeJoin()", R.layout.fragment_practice_2_stroke_join));
        mPageModels.add(new PageModel("setStrokeMiter()", R.layout.fragment_practice_2_stroke_miter));
        mPageModels.add(new PageModel("setPathEffect()", R.layout.fragment_practice_2_path_effect));
        mPageModels.add(new PageModel("setShadowLayer()", R.layout.fragment_practice_2_shadow_layer));
        mPageModels.add(new PageModel("setMaskFilter()", R.layout.fragment_practice_2_mask_filter));
        mPageModels.add(new PageModel("setFillPath()", R.layout.fragment_practice_2_fill_path));
        mPageModels.add(new PageModel("setTextPath()", R.layout.fragment_practice_2_text_path));
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
                return PracticeDrawFragment2.newInstance(mPageModels.get(position).practiceLayoutRes);
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
