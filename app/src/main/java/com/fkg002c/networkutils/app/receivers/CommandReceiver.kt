package com.fkg002c.networkutils.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.fkg002c.networkutils.app.ui.cell.CollectCellInfoWorker
import com.fkg002c.networkutils.log.Logger

class CommandReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Logger.i(TAG, "onReceive() action: ${intent.action}")
        when (intent.action) {
            CMD_COLLECT_CELL_KPI -> WorkManager.getInstance(context).enqueue(OneTimeWorkRequestBuilder<CollectCellInfoWorker>().build())
        }
    }

    companion object {
        private const val TAG = "CommandReceiver"
        private const val CMD_COLLECT_CELL_KPI = "cmd.COLLECT_CELL_KPI"
    }
}