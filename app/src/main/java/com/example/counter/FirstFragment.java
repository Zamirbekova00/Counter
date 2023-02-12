package com.example.counter;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private TextView textView;
    private Button btn_inc, btn_dec, btn_send;
    static final String KEY_FOR_TEXT = "u";
    Integer num = 0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }
    private void initView() {
        textView = requireActivity().findViewById(R.id.textView);
        btn_inc = requireActivity().findViewById(R.id.btn_increment);
        btn_dec = requireActivity().findViewById(R.id.btn_decrement);
        btn_send = requireActivity().findViewById(R.id.btn_send);
    }
    private void initListener() {
        btn_inc.setOnClickListener(view -> {
            num = Integer.parseInt(textView.getText().toString());
            num++;
            textView.setText(num.toString());
        });
        btn_dec.setOnClickListener(view -> {
            num = Integer.parseInt(textView.getText().toString());
            num--;
            textView.setText(num.toString());
        });
        btn_send.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_FOR_TEXT, textView.getText().toString());

            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, secondFragment).addToBackStack(null).commit();
        });
    }
}

