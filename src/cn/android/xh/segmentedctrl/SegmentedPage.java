package cn.android.xh.segmentedctrl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public abstract class SegmentedPage extends LinearLayout {
	private OnSegmentedPageDataChangedListener mSegmentedPageDataChangedListener;

	public interface OnSegmentedPageDataChangedListener {
		/**
		 * Notify the application when the data changed
		 * 
		 * @param page
		 *            this
		 * @param o
		 *            data
		 * @param type
		 *            data type
		 */
		void pageChangedNotify(SegmentedPage page, Object o, int type);
	}

	public SegmentedPage(Context context) {
		super(context);

		setupView(context, null);
	}

	public SegmentedPage(Context context, AttributeSet attr) {
		super(context, attr);

		setupView(context, null);
	}

	/**
	 * Setup the page view tree
	 * 
	 * @param context
	 * @param attr
	 */
	abstract protected void setupView(Context context, AttributeSet attr);

	public void setOnSegmentedPageDataChangedListener(
			OnSegmentedPageDataChangedListener listener) {
		mSegmentedPageDataChangedListener = listener;
	}

	public OnSegmentedPageDataChangedListener getOnSegmentedPageDataChangedListener() {
		return mSegmentedPageDataChangedListener;
	}

	public boolean isVisible() {
		return getVisibility() == View.VISIBLE;
	}

	protected void toPageChangedNotify(SegmentedPage page, Object o) {
		toPageChangedNotify(page, o, 0);
	}

	protected void toPageChangedNotify(SegmentedPage page, Object o, int type) {
		if (isVisible() && mSegmentedPageDataChangedListener != null) {
			mSegmentedPageDataChangedListener.pageChangedNotify(page, o, type);
		}
	}
}
