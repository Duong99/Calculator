package vn.com.nghiemduong.calculator.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

object Utils {
    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity.currentFocus
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}