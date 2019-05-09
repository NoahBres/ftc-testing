package com.noahbres.missioncontrol

import android.util.Log
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress

class WebSocket : WebSocketServer(InetSocketAddress(PORT)) {
    companion object {
        const val PORT = 8889
        const val TAG = "MissionControlWebSocket"
    }

    override fun onOpen(conn: WebSocket?, handshake: ClientHandshake?) {
        conn!!.send("Welcome to the server!")
        Log.i(TAG, "$conn has joined the room")
    }

    override fun onClose(conn: WebSocket?, code: Int, reason: String?, remote: Boolean) {
        Log.i(TAG, "$conn has left the room")
    }

    override fun onMessage(conn: WebSocket?, msg: String?) {
        Log.i(TAG, "Message: $msg")
    }

    override fun onStart() {
        Log.i(TAG, "Mission Control socket server starting")
        // examples in github repo include this but apparently the function doesn't exist
        // setConnectionLostTimeout(0)
        // setConnectionLostTimeout(100
    }

    override fun onError(conn: WebSocket?, e: Exception?) {
        Log.e(TAG, e.toString())
        e!!.printStackTrace()
    }
}
