package vn.com.nghiemduong.calculator

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vn.com.nghiemduong.calculator.databinding.ActivityMainBinding
import vn.com.nghiemduong.calculator.utils.Utils
import vn.com.nghiemduong.calculator.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private val mCalculatorViewModel: CalculatorViewModel by lazy {
        ViewModelProvider(this)[CalculatorViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        onEvents()
        onEventsLong()
        setObserves()
    }

    private fun onEventsLong() {
        binding.tvDelete.setOnLongClickListener {
            mCalculatorViewModel.clearValue()
            return@setOnLongClickListener true
        }
    }

    private fun setObserves() {
        mCalculatorViewModel.mCalculator.observe(this, Observer {
            binding.tvInput.text = Editable.Factory.getInstance().newEditable(it)
        })

        mCalculatorViewModel.mResult.observe(this, Observer {
            binding.tvResult.text = it
        })
    }

    private fun init() {
        Utils.hideKeyboard(this)
        binding.tvDelete.setOnClickListener(this)
        binding.tvDiv.setOnClickListener(this)
        binding.tvMul.setOnClickListener(this)
        binding.tvMinus.setOnClickListener(this)
        binding.tvPlus.setOnClickListener(this)

        binding.tv0.setOnClickListener(this)
        binding.tv1.setOnClickListener(this)
        binding.tv2.setOnClickListener(this)
        binding.tv3.setOnClickListener(this)
        binding.tv4.setOnClickListener(this)
        binding.tv5.setOnClickListener(this)
        binding.tv6.setOnClickListener(this)
        binding.tv7.setOnClickListener(this)
        binding.tv8.setOnClickListener(this)
        binding.tv9.setOnClickListener(this)
        binding.tv0.setOnClickListener(this)
        binding.tvOutput.setOnClickListener(this)
        binding.tvDot.setOnClickListener(this)
    }

    private fun onEvents() {

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            // Keyboard
            R.id.tv0 -> {
                mCalculatorViewModel.addValue(
                    binding.tv0.text.toString()
                )
            }

            R.id.tv1 -> {
                mCalculatorViewModel.addValue(
                    binding.tv1.text.toString()
                )

            }
            R.id.tv2 -> {
                mCalculatorViewModel.addValue(
                    binding.tv2.text.toString()
                )

            }
            R.id.tv3 -> {
                mCalculatorViewModel.addValue(
                    binding.tv3.text.toString()
                )
            }
            R.id.tv4 -> {
                mCalculatorViewModel.addValue(
                    binding.tv4.text.toString()
                )
            }
            R.id.tv5 -> {
                mCalculatorViewModel.addValue(
                    binding.tv5.text.toString()
                )
            }
            R.id.tv6 -> {
                mCalculatorViewModel.addValue(
                    binding.tv6.text.toString()
                )
            }
            R.id.tv7 -> {
                mCalculatorViewModel.addValue(
                    binding.tv7.text.toString()
                )
            }
            R.id.tv8 -> {
                mCalculatorViewModel.addValue(
                    binding.tv8.text.toString()
                )
            }
            R.id.tv9 -> {
                mCalculatorViewModel.addValue(
                    binding.tv9.text.toString()
                )
            }
            R.id.tvOutput -> {
                mCalculatorViewModel.calculator()
            }

            R.id.tvDot -> {
                mCalculatorViewModel.addDot()
            }

            //Calculation
            R.id.tvDelete -> {
                mCalculatorViewModel.deleteValue()
            }

            R.id.tvDiv -> {
                mCalculatorViewModel.addCalculator(
                    binding.tvDiv.text.toString()
                )
            }

            R.id.tvMul -> {
                mCalculatorViewModel.addCalculator(
                    binding.tvMul.text.toString()
                )
            }

            R.id.tvMinus -> {
                mCalculatorViewModel.addCalculator(
                    binding.tvMinus.text.toString()
                )
            }

            R.id.tvPlus -> {
                mCalculatorViewModel.addCalculator(
                    binding.tvPlus.text.toString()
                )
            }
        }
    }
}