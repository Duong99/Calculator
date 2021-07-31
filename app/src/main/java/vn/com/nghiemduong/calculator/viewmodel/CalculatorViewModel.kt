package vn.com.nghiemduong.calculator.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder
import javax.xml.xpath.XPathExpressionException

class CalculatorViewModel : ViewModel() {

    val mCalculator: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val mResult: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun addValue(number: String) {
        val value = mCalculator.value ?: ""
        mCalculator.postValue(value + number)
    }

    fun addCalculator(calculator: String) {
        var value = mCalculator.value ?: ""
        if (value != "") {
            val cal = value[value.length - 1].toString()
            if (cal == "*" || cal == "/" || cal == "+" || cal == "-") {
                value = value.subSequence(0, value.length - 1).toString() + calculator
                mCalculator.postValue(value)
            } else {
                mCalculator.postValue(value + calculator)
            }
        } else {
            if (calculator == "+" || calculator == "-") {
                mCalculator.postValue(calculator)
            }
        }
    }

    fun addDot() {
        val value = mCalculator.value ?: ""
        if (value.isNotEmpty()) {
            val dot = value[value.length - 1].toString()
            if (dot != "." && dot != "+" && dot != "*" && dot != "/" && dot != "-") {
                mCalculator.postValue("$value.")
            }
        } else {
            mCalculator.postValue("$value.")
        }
    }

    fun deleteValue() {
        val value = mCalculator.value ?: ""
        if (value != "") {
            val valueDelete = value.subSequence(0, value.length - 1).toString()
            mCalculator.postValue(valueDelete)
        }
    }

    fun calculator() {
        val calculator = mCalculator.value ?: ""
        if (calculator != "") {
            try {
                val result = ExpressionBuilder(calculator).build().evaluate()
                mResult.postValue(result.toString())
            } catch (e: Exception) {
                if (e.toString().contains("Division by zero")) {
                    mResult.postValue("Division by zero")
                } else {
                    mResult.postValue("Bad expression")
                }
            }
        }
    }

    fun clearValue() {
        mCalculator.postValue("")
        mResult.postValue("")
    }
}