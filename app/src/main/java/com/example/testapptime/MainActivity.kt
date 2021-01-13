package com.example.testapptime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*TODO : Remplacer "bande passante" par "débit" pour moins long?
                 Augmenter la taille du radio
                 Changer le titre de l'app
        */

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
            editTextData.setText("0")
            editTextBandwidth.setText("0")
        }

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
            "Octet" -> {
                resultValue =  (data * 8)
            }
            "Ko" -> {
                resultValue =  ((data * 8)*1024)
            }
            "Mo" -> {
                resultValue =  (((data * 8)*1024)*1024)
            }
            "Go" -> {
                resultValue =  ((((data * 8)*1024)*1024)*1024)
            }
            "To" -> {
                resultValue =  (((((data * 8)*1024)*1024)*1024)*1024)
            }
        }
        when (spinner2.selectedItem) {
            "B/s" -> {
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
            "O/s" -> {
                resultValue /= (bandwidth*8)
            }
            "Ko/s" -> {
                resultValue /= ((bandwidth.toDouble()*8)*1024)
            }
            "Mo/s" -> {
                resultValue /= (((bandwidth*8)*1024)*1024)
            }
            "Go/s" -> {
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
            "B/s" -> {
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
            "O/s" -> {
                resultValue = bandwidth * totalSec
            }
            "Ko/s" -> {
                resultValue = (bandwidth * 1024) * totalSec
            }
            "Mo/s" -> {
                resultValue = ((bandwidth * 1024) * 1024) * totalSec
            }
            "Go/s" -> {
                resultValue = (((bandwidth * 1024) * 1024) * 1024) * totalSec
            }
        }
        when(spinner.selectedItem) {
            "Octet" -> {
                resultValue = resultValue //TODO : modify this
            }
            "Ko" -> {
                resultValue /= 1024
            }
            "Mo" -> {
                resultValue = resultValue /1024/1024
            }
            "Go" -> {
                resultValue = resultValue /1024/1024/1024
            }
            "To" -> {
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
            "Octet" -> {
                resultValue = (data*8)/totalSec
            }
            "Ko" -> {
                resultValue = ((data * 8) * 1024) / totalSec

            }
            "Mo" -> {
                resultValue = (((data * 8) * 1024) * 1024) / totalSec
            }
            "Go" -> {
                resultValue = ((((data * 8) * 1024) * 1024) * 1024) / totalSec
            }
            "To" -> {
                resultValue = (((((data * 8) * 1024) * 1024) * 1024) * 1024) / totalSec
            }
        }

        when (spinner2.selectedItem) {
            "B/s" -> {
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
            "O/s" -> {
                resultValue *= 8
            }
            "Ko/s" -> {
                resultValue /= 1024 * 8
            }
            "Mo/s" -> {
                resultValue = resultValue / 1024 / 1024 * 8
            }
            "Go/s" -> {
                resultValue = resultValue / 1024 / 1024 / 1024 * 8
            }
        }
        var result = "%.3f".format(resultValue)
        result = result.replace(',', '.')
        editTextBandwidth.setText(result)
    }
}
