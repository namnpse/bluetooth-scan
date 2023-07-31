package com.namnp.bluetoothscan.data

import com.namnp.bluetoothscan.domain.BluetoothMessage

fun String.toBluetoothMessage(isMine: Boolean): BluetoothMessage {
    val name = substringBeforeLast("#")
    val message = substringAfter("#")
    return BluetoothMessage(
        message = message,
        senderName = name,
        isMine = isMine
    )
}

fun BluetoothMessage.toByteArray(): ByteArray {
    return "$senderName#$message".encodeToByteArray()
}