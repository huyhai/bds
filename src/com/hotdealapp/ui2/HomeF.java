package com.hotdealapp.ui2;

import com.android.vrealapp.R;
import com.hotdeal.libs.HotdealUtilities;
import com.hotdealvn.hotdealapp.HotDealFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomeF extends Fragment implements OnClickListener {
	private ImageView img;
	private RelativeLayout llBanthue;
	private RelativeLayout llDuanmoi;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_f, container, false);
		initView(rootView);
		HotdealUtilities.showALog("Home CREATE");
		return rootView;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		HotdealUtilities.showALog("Home RESUME");
		Main.setTextTop("Vreal.vn");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		HotdealUtilities.showALog("Home PAUSE");
	}

	private void initView(View rootView) {
		img = (ImageView) rootView.findViewById(R.id.img);
		llBanthue = (RelativeLayout) rootView.findViewById(R.id.llBanthue);
		llDuanmoi = (RelativeLayout) rootView.findViewById(R.id.llDuanmoi);
		HotdealUtilities.setHeight(img, 3);
		llBanthue.setOnClickListener(this);
		llDuanmoi.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v == llBanthue) {
			((HotDealFragmentActivity) getActivity()).startFragment(new SearchF());
		} else if (v == llDuanmoi) {
			((HotDealFragmentActivity) getActivity()).startFragment(new DuAnMoiF());
		}

	}
}
