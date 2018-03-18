package com.sabdar.android.copychallenge;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.sabdar.android.copychallenge.fragments.CallFragment;
import com.sabdar.android.copychallenge.fragments.ChatFragment;
import com.sabdar.android.copychallenge.fragments.StatusFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton mFab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFab = findViewById(R.id.fab);
        mTabLayout = findViewById(R.id.tabs);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorWhite));

        mViewPager = findViewById(R.id.viewPager);
        setupViewPager(mViewPager);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_camera_alt_black_24dp));

        setupViewPageChange(mViewPager);
    }

    private void setupViewPageChange(ViewPager mViewPager) {
        mViewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        changeFabIcon(position);
                    }

                    @Override
                    public void onPageSelected(int position) {
                        changeFabIcon(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
//                        changeFabIcon(state);
                    }
                }
        );
    }

    private  void changeFabIcon(int position){
        if(position ==1 ){
            mFab.setVisibility(View.VISIBLE);
            mFab.setImageResource(R.drawable.ic_message_black_24dp);
        }else if(position ==3){
            mFab.setVisibility(View.VISIBLE);
            mFab.setImageResource(R.drawable.ic_call_black_24dp);
        }else{
            mFab.setVisibility(View.INVISIBLE);
        }
    }

    private void setupViewPager(ViewPager mViewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new StatusFragment(), "");
        viewPagerAdapter.addFragment(new ChatFragment(), "Chats");
        viewPagerAdapter.addFragment(new StatusFragment(), "Status");
        viewPagerAdapter.addFragment(new CallFragment(), "Calls");
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setCurrentItem(1);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
