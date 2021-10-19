package com.clempera.TTime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//TODO : Modifier message Toast pour qu'il soit traduit
//       Traduction b/s Bytes.......
//       Toast qui ne disparait pas qu'après un temps long

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //When the app starting, transferTime radio is preselected
        radioGroup.check(R.id.transferTime)
        daysTF.isEnabled = false
        hoursTF.isEnabled = false
        minutesTF.isEnabled = false
        secondsTF.isEnabled = false

        //Clear all Text Field
        clearBtn.setOnClickListener {
            daysTF.setText("0")
            hoursTF.setText("0")
            minutesTF.setText("0")
            secondsTF.setText("0")
            editTextData.setText("0.00")
            editTextBandwidth.setText("0.00")
        }

        //Enable or disable text field if checked in radio
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.transferTime -> {
                    daysTF.isEnabled = false
                    hoursTF.isEnabled = false
                    minutesTF.isEnabled = false
                    secondsTF.isEnabled = false
                    editTextBandwidth.isEnabled = true
                    editTextData.isEnabled = true
                }

                R.id.dataQuantity -> {
                    daysTF.isEnabled = true
                    hoursTF.isEnabled = true
                    minutesTF.isEnabled = true
                    secondsTF.isEnabled = true
                    editTextBandwidth.isEnabled = true
                    editTextData.isEnabled = false
                }

                R.id.bandwidth -> {
                    daysTF.isEnabled = true
                    hoursTF.isEnabled = true
                    minutesTF.isEnabled = true
                    secondsTF.isEnabled = true
                    editTextBandwidth.isEnabled = false
                    editTextData.isEnabled = true
                }
            }
        }

        //Change text result if daysTF modified
        daysTF.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                    if(daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                    {
                        if(dataQuantity.isChecked)
                            if (editTextBandwidth.text.toString().toDouble() != 0.0)
                                calculateDataQuantity(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                            else
                                Toast.makeText(this@MainActivity,"Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                        else if (bandwidth.isChecked)
                            if (editTextData.text.toString().toDouble() != 0.0)
                                calculateBandwidth(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextData.text.toString().toDouble())
                            else
                                Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                    }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //Change text result if hoursTF modified
        hoursTF.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                {
                    if (dataQuantity.isChecked)
                        if (editTextBandwidth.text.toString().toDouble() != 0.0)
                            calculateDataQuantity(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                    else if (bandwidth.isChecked)
                        if (editTextData.text.toString().toDouble() != 0.0)
                            calculateBandwidth(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextData.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //Change text result if minutesTF modified
        minutesTF.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                {
                    if (dataQuantity.isChecked)
                        if (editTextBandwidth.text.toString().toDouble() != 0.0)
                            calculateDataQuantity(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                    else if (bandwidth.isChecked)
                        if (editTextData.text.toString().toDouble() != 0.0)
                            calculateBandwidth(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextData.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //Change text result if secondsTF modified
        secondsTF.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                {
                    if(dataQuantity.isChecked)
                        if (editTextBandwidth.text.toString().toDouble() != 0.0)
                            calculateDataQuantity(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity,"Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                    else if (bandwidth.isChecked) {
                        if (editTextData.text.toString().toDouble() != 0.0)
                            calculateBandwidth(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextData.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //Change text result if editTextData modified
        editTextData.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (transferTime.isChecked)
                {
                    if (editTextData.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                        if (editTextBandwidth.text.toString().toDouble() != 0.0 && editTextData.text.toString().toDouble() != 0.0)
                            calculateTime(editTextData.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
                else if (bandwidth.isChecked)
                {
                    if (daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextData.text.isNotEmpty())
                        if (editTextData.text.toString().toDouble() != 0.0)
                            calculateBandwidth(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextData.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //Change text result if editTextBandwidth modified
        editTextBandwidth.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (transferTime.isChecked)
                {
                    if (editTextData.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                        if (editTextBandwidth.text.toString().toDouble() != 0.0 && editTextData.text.toString().toDouble() != 0.0)
                            calculateTime(editTextData.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
                else if (dataQuantity.isChecked)
                {
                    if (daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                        if (editTextBandwidth.text.toString().toDouble() != 0.0)
                            calculateDataQuantity(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //Change text result if spinner modified
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (transferTime.isChecked)
                {
                    if (editTextData.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                        if (editTextBandwidth.text.toString().toDouble() != 0.0 && editTextData.text.toString().toDouble() != 0.0)
                            calculateTime(editTextData.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
                else if (dataQuantity.isChecked)
                {
                    if (daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                        if (editTextBandwidth.text.toString().toDouble() != 0.0)
                            calculateDataQuantity(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
                else if (bandwidth.isChecked)
                {
                    if (daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextData.text.isNotEmpty())
                        if (editTextData.text.toString().toDouble() != 0.0)
                            calculateBandwidth(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextData.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
            }
        }

        //Change text result if spinner2 modified
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (transferTime.isChecked)
                {
                    if (editTextData.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                        if (editTextBandwidth.text.toString().toDouble() != 0.0 && editTextData.text.toString().toDouble() != 0.0)
                            calculateTime(editTextData.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
                else if (dataQuantity.isChecked)
                {
                    if (daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextBandwidth.text.isNotEmpty())
                        if (editTextBandwidth.text.toString().toDouble() != 0.0)
                            calculateDataQuantity(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextBandwidth.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
                else if (bandwidth.isChecked)
                {
                    if (daysTF.text.isNotEmpty() && hoursTF.text.isNotEmpty() && minutesTF.text.isNotEmpty() && secondsTF.text.isNotEmpty() && editTextData.text.isNotEmpty())
                        if (editTextData.text.toString().toDouble() != 0.0)
                            calculateBandwidth(daysTF.text.toString().toInt(), hoursTF.text.toString().toInt(), minutesTF.text.toString().toInt(), secondsTF.text.toString().toDouble(), editTextData.text.toString().toDouble())
                        else
                            Toast.makeText(this@MainActivity, "Veuillez choisir une valeur supérieur à zero", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun calculateTime(data:Double, bandwidth:Double) {
        var resultValue = 0.0

        when (spinner.selectedItem) {
            "Byte" -> {
                resultValue =  (data * 8)
            }
            "KB" -> {
                resultValue =  ((data * 8)*1024)
            }
            "MB" -> {
                resultValue =  (((data * 8)*1024)*1024)
            }
            "GB" -> {
                resultValue =  ((((data * 8)*1024)*1024)*1024)
            }
            "TB" -> {
                resultValue =  (((((data * 8)*1024)*1024)*1024)*1024)
            }
        }
        when (spinner2.selectedItem) {
            "b/s" -> {
                resultValue /= bandwidth
            }
            "Kb/s" -> {
                resultValue /= (bandwidth * 1024)
            }
            "Mb/s" -> {
                resultValue /=  ((bandwidth*1024)*1024)
            }
            "Gb/s" -> {
                resultValue /=  (((bandwidth*1024)*1024)*1024)
            }
            "B/s" -> {
                resultValue /= (bandwidth*8)
            }
            "KB/s" -> {
                resultValue /= ((bandwidth*8)*1024)
            }
            "MB/s" -> {
                resultValue /= (((bandwidth*8)*1024)*1024)
            }
            "GB/s" -> {
                resultValue /= ((((bandwidth*8)*1024)*1024)*1024)
            }

        }
        var days = 0
        var hours = 0
        var minutes = 0

        while(resultValue >= 86400)
        {
            resultValue -= 86400
            days++
        }

        while((resultValue) >= 3600)
        {
            resultValue -= 3600
            hours++
        }

        while((resultValue) >= 60)
        {
            resultValue -= 60
            minutes++
        }
        var result = "%.3f".format(resultValue)
        result = result.replace(',', '.')
        daysTF.setText("$days")
        hoursTF.setText("$hours")
        minutesTF.setText("$minutes")
        secondsTF.setText(result)
    }

    private fun calculateDataQuantity(days:Int, hours:Int, minutes:Int, seconds:Double, bandwidth:Double){
        var resultValue = 0.0

        var totalSec: Double = (days * 86400) + (hours * 3600) + (minutes * 60) + seconds

        when (spinner2.selectedItem) {
            "b/s" -> {
                resultValue = (bandwidth / 8) * totalSec
            }
            "Kb/s" -> {
                resultValue = ((bandwidth / 8) * 1024) * totalSec
            }
            "Mb/s" -> {
                resultValue = (((bandwidth / 8) * 1024) * 1024) * totalSec
            }
            "Gb/s" -> {
                resultValue = ((((bandwidth / 8) * 1024) * 1024) * 1024) * totalSec
            }
            "B/s" -> {
                resultValue = bandwidth * totalSec
            }
            "KB/s" -> {
                resultValue = (bandwidth * 1024) * totalSec
            }
            "MB/s" -> {
                resultValue = ((bandwidth * 1024) * 1024) * totalSec
            }
            "GB/s" -> {
                resultValue = (((bandwidth * 1024) * 1024) * 1024) * totalSec
            }
        }
        when(spinner.selectedItem) {
            "Byte" -> {
                resultValue = resultValue //TODO : modify this
            }
            "KB" -> {
                resultValue /= 1024
            }
            "MB" -> {
                resultValue = resultValue /1024/1024
            }
            "GB" -> {
                resultValue = resultValue /1024/1024/1024
            }
            "TB" -> {
                resultValue = resultValue /1024/1024/1024/1024
            }
        }
        var result = "%.3f".format(resultValue)
        result = result.replace(',', '.')
        editTextData.setText("$result")

    }

    private fun calculateBandwidth(days:Int, hours:Int, minutes:Int, seconds:Double, data:Double){
        var resultValue = 0.0
        var totalSec: Double = (days * 86400) + (hours * 3600) + (minutes * 60) + seconds

        when (spinner.selectedItem) {
            "Byte" -> {
                resultValue = (data*8)/totalSec
            }
            "KB" -> {
                resultValue = ((data * 8) * 1024) / totalSec

            }
            "MB" -> {
                resultValue = (((data * 8) * 1024) * 1024) / totalSec
            }
            "GB" -> {
                resultValue = ((((data * 8) * 1024) * 1024) * 1024) / totalSec
            }
            "TB" -> {
                resultValue = (((((data * 8) * 1024) * 1024) * 1024) * 1024) / totalSec
            }
        }

        when (spinner2.selectedItem) {
            "b/s" -> {
                resultValue = resultValue //TODO : modify this
            }
            "Kb/s" -> {
                resultValue /= 1024
            }
            "Mb/s" -> {
                resultValue = resultValue / 1024 / 1024
            }
            "Gb/s" -> {
                resultValue = resultValue /1024 / 1024 / 1024
            }
            "B/s" -> {
                resultValue *= 8
            }
            "KB/s" -> {
                resultValue /= 1024 * 8
            }
            "MB/s" -> {
                resultValue = resultValue / 1024 / 1024 * 8
            }
            "GB/s" -> {
                resultValue = resultValue / 1024 / 1024 / 1024 * 8
            }
        }
        var result = "%.3f".format(resultValue)
        result = result.replace(',', '.')
        editTextBandwidth.setText(result)
    }
}
