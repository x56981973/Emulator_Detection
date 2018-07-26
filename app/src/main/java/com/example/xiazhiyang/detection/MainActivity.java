package com.example.xiazhiyang.detection;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, SensorEventListener{

    private TextView pointStart;
    private TextView pointEnd;
    private TextView pointMoment;
    private TextView pointPressure;
    private TextView gyroscope;
    private TextView accelerator;
    private TextView light;
    private TextView orientation;

    private SensorManager sensorManager;
    private Sensor sensorGyroscope;
    private Sensor sensorAccelerator;
    private Sensor sensorPressure;
    private Sensor sensorLight;
    private Sensor sensorOrientation;

//    Sensor.TYPE_ORIENTATION

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        initScreen();
        initSensor();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initScreen() {
        pointStart = (TextView) findViewById(R.id.point_start);
        pointEnd = (TextView) findViewById(R.id.point_end);
        pointMoment = (TextView) findViewById(R.id.point_moment);
        pointPressure = (TextView) findViewById(R.id.point_pressure);
        gyroscope = (TextView) findViewById(R.id.gyroscope);
        accelerator = (TextView) findViewById(R.id.accelerator);
        light = (TextView) findViewById(R.id.light);
        orientation = (TextView) findViewById(R.id.orientation);
        LinearLayout touch = (LinearLayout) findViewById(R.id.touch);
        touch.setOnTouchListener(this);
    }

    private void initSensor(){
        sensorGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorAccelerator = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorOrientation = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        sensorManager.registerListener(this, sensorGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorAccelerator, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorPressure, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorOrientation, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pointStart.setText("起始位置：(" + event.getX() + "," + event.getY() + ")");
                pointEnd.setText("结束位置：");
                break;
            case MotionEvent.ACTION_UP:
                pointEnd.setText("结束位置：(" + event.getX() + "," + event.getY() + ")");
                pointMoment.setText("实时位置：");
                break;
            case MotionEvent.ACTION_MOVE:
                pointMoment.setText("实时位置：(" + event.getX() + "," + event.getY() + ")");
                break;
            default:
                break;
        }

        return true;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        String str = "X：" + values[0] + "，Y：" + values[1] + "，Z：" + values[2];
        switch (event.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                accelerator.setText("加速度：" + str);
                break;
            case Sensor.TYPE_GYROSCOPE:
                gyroscope.setText("陀螺仪：" + str);
                break;
            case Sensor.TYPE_PRESSURE:
                pointPressure.setText("屏幕压力：" + str);
                break;
            case Sensor.TYPE_LIGHT:
                light.setText("光线强度：" + str);
                break;
            case Sensor.TYPE_ORIENTATION:
                orientation.setText("方向：" + str);
                break;
            default:
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        sensorManager.unregisterListener(this, sensorGyroscope);
        sensorManager.unregisterListener(this, sensorAccelerator);
        sensorManager.unregisterListener(this, sensorPressure);
        sensorManager.unregisterListener(this, sensorLight);
        sensorManager.unregisterListener(this, sensorOrientation);

        super.onStop();
    }
}
