package wyq.expandablelistviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	//创建一个BaseExpandableListAdapter对象
	//ExpandableListAdapter adapter = new BaseExpandalebleListAdapter()
	ExpandableListAdapter adapter = new BaseExpandableListAdapter()
		{
			int[] logos =new int[]
				{
						R.drawable.p,
						R.drawable.z,
						R.drawable.t 
						
				};
			
			private String[] armTypes = new String[]
					{"神兵兵种","虫族兵种","人族兵种"};
			private String[][] arms = new String[][]
					{
						{"狂战士","龙骑士","暗黑圣堂","电兵"},
						{"小狗","赤蛇","飞龙","自爆飞机"},
						{"机枪兵","护士MM","幽灵"}
					};
			
			//获取指定组位置、指定子列表项处的子列表项数据			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO 自动生成的方法存根
				return arms[groupPosition][ childPosition];
			}

			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO 自动生成的方法存根
				return childPosition;
			}

			@Override
			public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
					ViewGroup parent) {
				// TODO 自动生成的方法存根
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition,childPosition).toString());
				return textView;
			}

			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO 自动生成的方法存根
				return arms[groupPosition].length;
			}
			
			private TextView getTextView()
			{
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
				TextView textView = new TextView(MainActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
				textView.setPadding(36,0,0, 0);
				textView.setTextSize(20);
				return textView;
			}

			@Override
			public Object getGroup(int groupPosition) {
				// TODO 自动生成的方法存根
				return armTypes[groupPosition];
			}

			@Override
			public int getGroupCount() {
				// TODO 自动生成的方法存根
				return armTypes.length;
			}

			@Override
			public long getGroupId(int groupPosition) {
				// TODO 自动生成的方法存根
				return groupPosition;
			}

			@Override
			public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
				// TODO 自动生成的方法存根
				LinearLayout ll = new LinearLayout(MainActivity.this);
				ll.setOrientation(0);
				ImageView logo = new ImageView(MainActivity.this);
				logo.setImageResource(logos[groupPosition]);
				ll.addView(logo);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString()); 
				ll.addView(textView);
				return ll;
			}

			@Override
			public boolean hasStableIds() {
				// TODO 自动生成的方法存根
				return true;
			}

			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				// TODO 自动生成的方法存根
				return true;
			}
		};
		ExpandableListView expandListView = (ExpandableListView)findViewById(R.id.list);
		expandListView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
