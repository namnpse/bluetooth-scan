package com.namnp.bluetoothscan.presentation.components

import com.namnp.bluetoothscan.domain.BluetoothDevice

data class BluetoothUiState(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List<BluetoothDevice> = emptyList(),
)
