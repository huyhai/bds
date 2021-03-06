package com.hotdealapp.ui2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hotdeal.libs.HotdealUtilities;
import com.hotdeal.libs.NotifySomesDataListener;
import com.hotdealvn.hotdealapp.HotDealFragmentActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import android.graphics.Bitmap;

import com.android.vrealapp.R;

public class Main extends HotDealFragmentActivity implements OnClickListener {
	public static ImageLoader imageLoader;
	public static DisplayImageOptions options;
	private LinearLayout llTopBar;
	private LinearLayout rlToogle;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private FrameLayout left_drawerV2;
	private boolean isOpenDrawer;
	private static TextView imgLogo;

	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main_v2);
		init();
		initView();
		startFragment(new HomeF());
		startSlide(new MenuSlide());
	}

	private void initView() {
		llTopBar = (LinearLayout) findViewById(R.id.llTopBar);
		rlToogle = (LinearLayout) findViewById(R.id.rlToogle);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		left_drawerV2 = (FrameLayout) findViewById(R.id.left_drawerV2);
		imgLogo = (TextView) findViewById(R.id.imgLogo);
		HotdealUtilities.setHeight(llTopBar, 11.5);

		rlToogle.setOnClickListener(this);

		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_launcher, /* nav drawer image to replace 'Up' caret */
		R.string.app_name, /* "open drawer" description for accessibility */
		R.string.app_name /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				isOpenDrawer = false;
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				isOpenDrawer = true;
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

	}

	private void init() {
		HotdealUtilities.setWH(this);

		imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(this));
		// options = new DisplayImageOptions.Builder()
		// .showImageForEmptyUrl(placeholder)
		// .showStubImage(placeholder).cacheOnDisc()
		// .decodingType(DecodingType.MEMORY_SAVING).build();
		options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.img_thumb).showImageForEmptyUri(R.drawable.img_thumb).showImageOnFail(R.drawable.img_thumb).cacheInMemory(true)
				.cacheOnDisc().considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
		// startService(new Intent(this, MyService.class));

	}

	@Override
	public void onClick(View v) {
		if (v == rlToogle) {
			if (isOpenDrawer) {
				closeMenu();
			} else {
				openMenu();
			}

		}

	}

	public static void setTextTop(String text) {
		try {
			imgLogo.setText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void openMenu() {
		mDrawerLayout.openDrawer(left_drawerV2);
	}

	public void closeMenu() {
		mDrawerLayout.closeDrawer(left_drawerV2);

	}
}
