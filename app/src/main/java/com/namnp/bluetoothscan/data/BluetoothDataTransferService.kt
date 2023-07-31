package com.namnp.bluetoothscan.data

import android.bluetooth.BluetoothSocket
import com.namnp.bluetoothscan.domain.BluetoothMessage
import com.namnp.bluetoothscan.domain.TransferFailedException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.io.IOException

class BluetoothDataTransferService(
    private val socket: BluetoothSocket
) {

    fun listenForIncomingMessages(): Flow<BluetoothMessage> {
        return flow {
            if(!socket.isConnected) {
                return@flow
            }
            val buffer = ByteArray(1024)
            while (true) {
                val byteCount = try {
                    socket.inputStream.read(buffer)
                }catch (e: IOException) {
                    throw TransferFailedException()
                }

                emit(
                    buffer.decodeToString(
                        endIndex = byteCount
                    ).toBluetoothMessage(isMine = false)
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun sendMessage(byteArray: ByteArray) = withContext(Dispatchers.IO) {
        try {
            socket.outputStream.write(byteArray)
        }catch (e: IOException) {
            e.printStackTrace()
            return@withContext false
        }
        true
    }

}