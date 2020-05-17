package com.ubb.lightmeter

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.ubb.sensorapp.UploadUtil

class TemperatureSensorListener : SensorEventListener {
    private val databaseReference = Firebase.database.getReference("temperature")
    private val currentValueReference = Firebase.database.getReference("temperatureCurrentValue")

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val value = event?.values?.get(0)
        UploadUtil.upload(databaseReference, currentValueReference, value)
    }
}