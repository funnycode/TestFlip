package com.testflip;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnGestureListener {

	private ViewFlipper flipper;// ViewFlipperʵ��
	private GestureDetector detector;// ��������ʵ��
	private final String TAG = "Main: ";

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		detector = new GestureDetector(this);// ��ʼ������̽��
		flipper = (ViewFlipper) this.findViewById(R.id.ViewFlipper01);// ���ViewFlipperʵ��

		if (flipper != null) {
			flipper.addView(addTextView("step 1"));// ��View��ӵ�flipper������
			flipper.addView(addTextView("step 2"));
			flipper.addView(addTextView("step 3"));
			flipper.addView(addTextView("step 4"));
			flipper.addView(addTextView("step 5"));
		} else {
			Log.v(TAG, "flipper is null");
		}
	}

	private View addTextView(String text) {
		TextView tv = new TextView(this);
		tv.setText(text);
		tv.setGravity(1);
		return tv;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (e1.getX() - e2.getX() > 120) {// ����Ǵ������󻬶�
			// ע��flipper�Ľ���Ч��
			this.flipper.setInAnimation(AnimationUtils.loadAnimation(this,
					R.anim.left_in));
			this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this,
					R.anim.left_out));
			this.flipper.showNext();
			return true;
		} else if (e1.getX() - e2.getX() < -120) {// ����Ǵ������һ���
			this.flipper.setInAnimation(AnimationUtils.loadAnimation(this,
					R.anim.right_in));
			this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this,
					R.anim.right_out));
			this.flipper.showPrevious();
			return true;
		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return this.detector.onTouchEvent(event);
	}
}
