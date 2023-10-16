package com.example.accelerometer

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

import com.example.accelerometer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    lateinit var accelerometer: Sensor
    lateinit var x_direction :TextView
    lateinit var y_direction: TextView
    lateinit var z_direction: TextView
    private lateinit var seekbar:SeekBar
    private lateinit var movement_display: TextView
    private lateinit var binding: ActivityMainBinding
    var senseVal: Float = 0.0f
    var x_dir: Float = 0.0f
    var y_dir: Float = 0.0f
    var z_dir: Float = 0.0f
    val sigMove = SigMove()


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

            updateAxisValues(x_dir, y_dir, z_dir,senseVal)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putFloat("SenseVal", senseVal)
        outState.putFloat("x_dir", x_dir)
        outState.putFloat("y_dir", y_dir)
        outState.putFloat("z_dir", z_dir)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {

        super.onRestoreInstanceState(savedInstanceState)

        senseVal = savedInstanceState.getFloat("SenseVal", 0.0f)
        x_dir = savedInstanceState.getFloat("x_dir", 0.0f)
        y_dir = savedInstanceState.getFloat("y_dir", 0.0f)
        z_dir = savedInstanceState.getFloat("z_dir", 0.0f)

        movement_display.text = senseVal.toString()
        x_direction.text = "X axis: $x_dir"
        y_direction.text = "Y axis: $y_dir"
        z_direction.text = "Z axis: $z_dir"


    }

    private fun updateAxisValues(x: Float, y: Float, z: Float, senseval: Float) {


        if (sigMove.isSignificantMovement(x, y, z,senseval)) {
            Toast.makeText(this, "Significant movement detected!", Toast.LENGTH_SHORT).show()
            Log.d("MyApp", "Significant movement detected: X: $x, Y: $y, Z: $z")
            x_direction.text = "X axis: $x"
            y_direction.text = "Y axis: $y"
            z_direction.text = "Z axis: $z"

        } else {
            Toast.makeText(this, "Significant movement not detected!", Toast.LENGTH_SHORT).show()
            Log.d("MyApp", "Significant not movement detected: X: $x, Y: $y, Z: $z")
            x_direction.text = "X axis: 0.00"
            y_direction.text = "Y axis: 0.00"
            z_direction.text = "Z axis: 0.00"

        }
    }




}