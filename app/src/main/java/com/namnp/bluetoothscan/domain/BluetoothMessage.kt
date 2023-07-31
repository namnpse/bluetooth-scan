package com.namnp.bluetoothscan.domain

data class BluetoothMessage(
    val message: String,
    val senderName: String,
    val isMine: Boolean
)

