package com.fkg002c.networkutils.app.ui.cell

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.fkg002c.networkutils.log.Logger
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

internal class CollectCellInfoWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result = coroutineScope {
        Logger.i(TAG, "CollectCellInfoWorker started with inputData: $inputData")

        val defferedCellInfo = async { com.fkg002c.networkutils.Api.getCellInfo(applicationContext, TAG) }

        val cellInfo = defferedCellInfo.await()

        Logger.i(TAG, "CollectCellInfoWorker finished: cell info all: ${cellInfo.size} registered: ${cellInfo.filter { it.isRegistered }.size}")
        Result.success()
    }

    companion object {
        private const val TAG = "CollectCellInfoWorker"
    }
}
