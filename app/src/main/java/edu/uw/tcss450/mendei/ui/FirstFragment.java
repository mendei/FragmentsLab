package edu.uw.tcss450.mendei.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.mendei.R;
import edu.uw.tcss450.mendei.databinding.FragmentFirstBinding;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater,container,false);
        Log.d("FirstFrag", "onCreateView");
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        //onClickListener
        binding.buttonRed.setOnClickListener(this);

        //lambda expression
        binding.buttonGreen.setOnClickListener(button ->
                processColor(Color.GREEN));

        //method reference
        binding.buttonBlue.setOnClickListener(this::handleBlue);
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }

    public void processColor(int color){
        Log.d("ACTIVITY", "Red: " + Color.red(color) +
                " Green: " + Color.green(color) +
                " Blue: " + Color.blue(color));

        FirstFragmentDirections.ActionFirstFragmentToColorFragment directions =
                FirstFragmentDirections.actionFirstFragmentToColorFragment(color);

        Navigation.findNavController(getView()).navigate(directions);

    }

    @Override
    public void onClick(View view){
        if (view == binding.buttonRed){
            processColor(Color.RED);
        }
    }

    private void handleBlue(View v){
        if(v == binding.buttonBlue){
            processColor(Color.BLUE);
        }
    }
}