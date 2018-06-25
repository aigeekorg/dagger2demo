package org.aigeek.mydaggerdemo.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.aigeek.mydaggerdemo.R;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by yao on 2018/4/27.
 */
//原生组件类
public class MainFragment extends Fragment implements MainContract.MainViewInterf{
    private TextView mTextView;
    private MainContract.MainPresenterInterf mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //使用layout的布局填充fragment
        View root = inflater.inflate(R.layout.fragment_main,container,false);
        mTextView = root.findViewById(R.id.text_fragment);
        return root;
    }

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 获取presenter调用view接口设置的presenter
     * @param presenter
     */
    @Override
    public void setPresenter(@NonNull MainPresenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public String getText() {
        return mTextView.getText().toString();
    }

    @Override
    public void setText(String s) {
        mTextView.setText(s);
    }
}
