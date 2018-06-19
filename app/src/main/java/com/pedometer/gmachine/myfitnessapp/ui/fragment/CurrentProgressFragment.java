package com.pedometer.gmachine.myfitnessapp.ui.fragment;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.pedometer.gmachine.myfitnessapp.R;

import at.grabner.circleprogress.CircleProgressView;

public class CurrentProgressFragment extends Fragment implements SensorEventListener {
    // implements SensorEventListener
    private static final String TAG = "CurrentProgressFragment";

    SensorManager sensorManager;
    CircleProgressView circleProgressView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.current_progress_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        circleProgressView = (CircleProgressView) getView().findViewById(R.id.circleProgressView);
    }

    @Override
    public void onStart() {
        super.onStart();
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null){
            sensorManager.registerListener((SensorEventListener) this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else{
            Log.i("Sensor Not Found", "No Step Counter");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        circleProgressView.setValue(Float.parseFloat(String.valueOf(event.values[0])));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
