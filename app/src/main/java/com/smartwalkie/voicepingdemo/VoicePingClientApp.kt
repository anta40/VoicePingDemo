package com.smartwalkie.voicepingdemo

import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import com.smartwalkie.voicepingsdk.VoicePing
import com.smartwalkie.voicepingsdk.model.AudioParam

class VoicePingClientApp: Application() {
    private val TAG = "VoicePingClientApp"

    override fun onCreate() {
        super.onCreate()
        context = this
        val SERVER_URL = "wss://router-lite.voiceping.info"
        val audioSource = AudioSourceConfig.getSource()
        val audioParam = AudioParam.Builder()
            .setAudioSource(audioSource)
            .build()
        val audioSourceText = AudioSourceConfig.getAudioSourceText(audioParam.audioSource)
        Log.d(TAG, "Manufacturer: ${Build.MANUFACTURER}, audio source: $audioSourceText")
        VoicePing.init(this, SERVER_URL, audioParam)
    }

    companion object {
        lateinit var context: Context
    }
}