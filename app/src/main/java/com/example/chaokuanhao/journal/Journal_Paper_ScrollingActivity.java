package com.example.chaokuanhao.journal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.chaokuanhao.journal.Fragment_Journal.Journal_Calender_Fragment;
import com.example.chaokuanhao.journal.Fragment_Journal.Journal_List_Fragment;
import com.example.chaokuanhao.journal.Fragment_Journal.Journal_Paper_Fragment;
import com.example.chaokuanhao.journal.Setting_Page.SettingsActivity;
import com.example.chaokuanhao.journal.Utils.SectionPagerAdapter;


/**
 * Created by chaokuanhao on 12/10/2017.
 */
public class Journal_Paper_ScrollingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public enum appBarState {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private appBarState mCurrentState = appBarState.IDLE;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Animation mShowButton = AnimationUtils.loadAnimation(Journal_Paper_ScrollingActivity.this, R.anim.show_button);
        Animation mHideButton = AnimationUtils.loadAnimation(Journal_Paper_ScrollingActivity.this, R.anim.hide_button);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Journal);
        setSupportActionBar(toolbar);       // this one is for support the older version

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_actionbar_util);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        initInstanceDrawer( );
        setupViewPager();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    /**
     * This function is to initiate the dynamic tool bar.
     */
    private void initInstanceDrawer( ){
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_Journal);
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if ( verticalOffset == 0){
////                    Log.d("VerticalOffser: ", String.valueOf(verticalOffset) );
////                    Log.d("getTotalScrollRange: ",String.valueOf(appBarLayout.getTotalScrollRange()) );
//                    if (mCurrentState != appBarState.EXPANDED){
//
//                    }
//                    mCurrentState = appBarState.EXPANDED;
//                    fab.setVisibility(View.VISIBLE);
//                }
//                else if ( Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
////                    Log.d("VerticalOffser: ", String.valueOf(verticalOffset) );
////                    Log.d("getTotalScrollRange: ",String.valueOf(appBarLayout.getTotalScrollRange()) );
//                    if (mCurrentState != appBarState.COLLAPSED){
//
//                    }
//                    mCurrentState = appBarState.COLLAPSED;
//                    fab.setVisibility(View.INVISIBLE);
//                }
//                else{
////                    Log.d("VerticalOffser: ", String.valueOf(verticalOffset) );
////                    Log.d("getTotalScrollRange: ",String.valueOf(appBarLayout.getTotalScrollRange()) );
//                    if (mCurrentState != appBarState.IDLE){
//
//                    }
//                    mCurrentState = appBarState.IDLE;
//                    if ( Math.abs(verticalOffset) <= 200 ){
//                        fab.setVisibility(View.VISIBLE);
//                    }else{
//                        fab.setVisibility(View.INVISIBLE);
//                    }
//                }
//            }
//        });
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_CollapsingToolbarLayout_Journal);
        collapsingToolbarLayout.setTitle("Journal");
    }

    /**
     * This function is to create the main menu on the toolbar. It is called option menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }
    /**
     * This function is to send the MenuItem to the menu.
     */
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

    /**
     * set up the viewPager to add the fragment
     */
    private void setupViewPager(){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Journal_List_Fragment());       // index 0
        adapter.addFragment(new Journal_Paper_Fragment());      // index 1
        adapter.addFragment(new Journal_Calender_Fragment());   // index 2
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                switch (position){
//                    case 0:
//                        fab.show();
//                        break;
//                    case 1:
//                        fab.show();
//                        break;
//                    case 2:
//                        fab.show();
//                        break;
//                    default:
//                        fab.hide();
//                        break;
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.getTabAt(0).setText("List");
        tabLayout.getTabAt(1).setText("Paper");
        tabLayout.getTabAt(2).setText("Calender");
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_setting){
            Intent intent = new Intent();
            intent.setClass(Journal_Paper_ScrollingActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
