package com.example.accelerometer

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.accelerometer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private lateinit var accelerometer: Sensor
    private lateinit var x_direction :TextView
    private lateinit var y_direction: TextView
    private lateinit var z_direction: TextView
    private lateinit var seekbar:SeekBar
    private lateinit var movement_display: TextView
    private lateinit var binding: ActivityMainBinding
    private var senseVal: Float = 10.0f
    private var x_dir: Float = 0.0f
    private var y_dir: Float = 0.0f
    private var z_dir: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)!!
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)

        x_direction = findViewById(R.id.x_direction_text)
        y_direction = findViewById(R.id.y_direction_text)
        z_direction = findViewById(R.id.z_direction_text)
        seekbar = findViewById(R.id.movementSeekBar)
        movement_display = findViewById(R.id.movement_show)
        movement_display.text = String.format("%.2f", 0.00)

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                senseVal = progress.toDouble().toFloat()
                movement_display.text = progress.toDouble().toString();
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }

    override fun onSensorChanged(event: SensorEvent){
        if (event.sensor.type == Sensor.TYPE_LINEAR_ACCELERATION){
            x_dir = event.values[0]
            y_dir = event.values[1]
            z_dir = event.values[2]




            if (Math.abs(x_dir) > senseVal || Math.abs(y_dir).toDouble() > senseVal || Math.abs(z_dir).toDouble() > senseVal) {

                x_direction.text = "X axis: $x_dir"
                y_direction.text = "Y axis: $y_dir"
                z_direction.text = "Z axis: $z_dir"

                Toast.makeText(this, "Significant movement detected!", Toast.LENGTH_LONG)
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putFloat("SenseVal", senseVal)
        outState.putFloat("x_dir", x_dir)
        outState.putFloat("y_dir", y_dir)
        outState.putFloat("z_dir", z_dir)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {

        super.onRestoreInstanceState(savedInstanceState)

        senseVal = savedInstanceState.getFloat("SenseVal", 10.0f)
        x_dir = savedInstanceState.getFloat("x_dir", 0.0f)
        y_dir = savedInstanceState.getFloat("y_dir", 0.0f)
        z_dir = savedInstanceState.getFloat("z_dir", 0.0f)

        movement_display.text = senseVal.toString()
        x_direction.text = "X axis: $x_dir"
        y_direction.text = "Y axis: $y_dir"
        z_direction.text = "Z axis: $z_dir"

    }
}