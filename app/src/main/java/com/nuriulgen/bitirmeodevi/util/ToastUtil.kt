package com.nuriulgen.bitirmeodevi.util

import android.content.Context
import android.widget.Toast

/**
 * Projenin birçok yerinde Toast Message kullanıldı ve her seferinde
 * aynı kodları yazmak ve kod tekrarı oluşmasını için object ToastUtils oluşturuldu.
 */
object ToastUtils {
    fun showError(message: String?, context: Context?) {
        ToastUtils.getToast(message!!, context!!).show()
    }

    fun showShortMessage(message: String?, context: Context?) {
        ToastUtils.getToast(message!!, context!!, Toast.LENGTH_SHORT).show()
    }

    private fun getToast(message: String, context: Context): Toast {
        return ToastUtils.getToast(message, context, Toast.LENGTH_LONG)
    }

    private fun getToast(message: String, context: Context, length: Int): Toast {
        return Toast.makeText(context, message, length)
    }
}