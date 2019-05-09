package com.noahbres.missioncontrol

import android.util.Log

class MissionControl {
    companion object {
        const val TAG = "MissionControl"
    }

    private val webServer = WebServer()
    private val webSocket = WebSocket()

    fun start() {
        Log.i(TAG, "Mission Control starting")
        webServer.start()
        webSocket.start()
    }

    fun stop() {
        webServer.stop()
        webSocket.stop()
    }
}