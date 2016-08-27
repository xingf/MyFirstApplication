package com.example.xw.myfirstapplication.slidingmenu.fragments;


        import android.app.Fragment;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.example.xw.myfirstapplication.R;

public class CommunityFragment extends Fragment {

    private static CommunityFragment mCommunityFragment = null;
    public CommunityFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_community, container, false);
        mCommunityFragment = this;
        return rootView;
    }
    public static CommunityFragment getCommunityFragment(){
        if(mCommunityFragment == null){
            mCommunityFragment = new CommunityFragment();
        }
        return mCommunityFragment;
    }

}
