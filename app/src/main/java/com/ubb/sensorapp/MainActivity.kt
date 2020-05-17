package com.ubb.sensorapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ubb.lightmeter.HumiditySensorListener
import com.ubb.lightmeter.LightSensorListener
import com.ubb.lightmeter.TemperatureSensorListener

class MainActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        val humiditySensorListener = HumiditySensorListener()
        sensorManager.registerListener(humiditySensorListener, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL)

        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        val lightSensorListener = LightSensorListener()
        sensorManager.registerListener(lightSensorListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)

        val temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        val temperatureSensorListener = TemperatureSensorListener()
        sensorManager.registerListener(temperatureSensorListener, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL)


//        UploadMockData.createAndUpload()
    }
}
