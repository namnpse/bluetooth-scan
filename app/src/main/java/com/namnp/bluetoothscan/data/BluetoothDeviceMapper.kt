package com.namnp.bluetoothscan.data

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.namnp.bluetoothscan.domain.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}