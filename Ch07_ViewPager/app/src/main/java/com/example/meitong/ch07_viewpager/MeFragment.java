package com.example.meitong.ch07_viewpager;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    public MeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);

        Button button = view.findViewById(R.id.sign_in);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent (MeFragment.this.getActivity(), LoginActivity.class);
                startActivity(it);
            }
        });

        return view;
    }



}
