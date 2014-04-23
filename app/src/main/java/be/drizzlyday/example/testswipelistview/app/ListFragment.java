package be.drizzlyday.example.testswipelistview.app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.testswipelistview.app.R;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.fortysevendeg.swipelistview.SwipeListViewListener;

import java.util.ArrayList;
import java.util.List;

import be.drizzlyday.example.testswipelistview.app.adapters.ContentAdapter;
import be.drizzlyday.example.testswipelistview.app.data.ContentData;
import be.drizzlyday.example.testswipelistview.app.models.ContentModel;
import uk.co.senab.actionbarpulltorefresh.extras.actionbarsherlock.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;
import uk.co.senab.actionbarpulltorefresh.library.viewdelegates.AbsListViewDelegate;

/**
 * Created by Kevin on 23/04/2014.
 */
public class ListFragment extends Fragment implements OnRefreshListener {

    private ContentAdapter contentAdapter;
    private PullToRefreshLayout pullToRefreshLayout;
    private SwipeListView listView;

    private List<ContentModel> content = new ArrayList<ContentModel>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = ContentData.CreateData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (SwipeListView) view.findViewById(R.id.lv_content);
        pullToRefreshLayout = (PullToRefreshLayout) view.findViewById(R.id.ptr_layout);

        contentAdapter = new ContentAdapter(getActivity(), R.layout.row_content, content);
        listView.setAdapter(contentAdapter);
        listView.setSwipeListViewListener(new SwipeListViewHandler());

        ActionBarPullToRefresh.from(getActivity())
                .allChildrenArePullable()
                .listener(this)
                .useViewDelegate(ListView.class, new AbsListViewDelegate())
                .setup(pullToRefreshLayout);
    }

    @Override
    public void onRefreshStarted(View view) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);

                // Notify PullToRefreshLayout that the refresh has finished
                pullToRefreshLayout.setRefreshComplete();
            }
        }.execute();
    }

    private class SwipeListViewHandler implements SwipeListViewListener {

        @Override
        public void onOpened(int i, boolean b) {

        }

        @Override
        public void onClosed(int i, boolean b) {

        }

        @Override
        public void onListChanged() {

        }

        @Override
        public void onMove(int i, float v) {

        }

        @Override
        public void onStartOpen(int i, int i2, boolean b) {

        }

        @Override
        public void onStartClose(int i, boolean b) {

        }

        @Override
        public void onClickFrontView(int i) {
            Log.d("ListFragment", "Front view clicked!");
        }

        @Override
        public void onClickBackView(int i) {
            Log.d("ListFragment", "Front view clicked!");
        }

        @Override
        public void onDismiss(int[] ints) {

        }

        @Override
        public int onChangeSwipeMode(int i) {
            return 0;
        }

        @Override
        public void onChoiceChanged(int i, boolean b) {

        }

        @Override
        public void onChoiceStarted() {

        }

        @Override
        public void onChoiceEnded() {

        }

        @Override
        public void onFirstListItem() {

        }

        @Override
        public void onLastListItem() {

        }
    }
}
