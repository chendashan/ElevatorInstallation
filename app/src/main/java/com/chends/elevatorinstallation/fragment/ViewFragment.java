package com.chends.elevatorinstallation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chends.elevatorinstallation.R;
import com.chends.elevatorinstallation.adapter.ImageListAdapter;

public class ViewFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private int[] pictureId;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        mRecyclerView = view.findViewById(R.id.rcv_image);
        initView();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pictureId = getArguments().getIntArray("pictureId");
        }
    }

    private void initView() {

        //LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        ImageListAdapter adapter = new ImageListAdapter(getActivity(), pictureId);
        mRecyclerView.setAdapter(adapter);
    }

    public static ViewFragment newInstance(int[] pictureId) {
        ViewFragment fragment = new ViewFragment();
        Bundle bundle = new Bundle();
        bundle.putIntArray("pictureId", pictureId);
        fragment.setArguments(bundle);
        return fragment;
    }
}
