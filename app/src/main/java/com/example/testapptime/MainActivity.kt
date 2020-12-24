package com.example.testapptime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*TODO : Enlever le bouton OK et faire "en temps réel"
                Remplacer "bande passante" par "débit" pour moins long
                Ajouter Octet/s Mo/s, etc....
                Voir pour les EditText vide pour pas que ça plante
                Augmenter la taille du radio
                Changer le titre de l'app
                Ajouter un bouton "clear" pour toutes les datas*/

        //When the app starting, transferTime radio is preselected
        /*
        radioGroup.check(R.id.transferTime)
        daysTF.isEnabled = false
        hoursTF.isEnabled = false
        minutesTF.isEnabled = false
        secondsTF.isEnabled = false
        */

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.transferTime) {
                var resultValue = 0.0
                daysTF.isEnabled = false
                hoursTF.isEnabled = false
                minutesTF.isEnabled = false
                secondsTF.isEnabled = false
                editTextBandwidth.isEnabled = true
                editTextData.isEnabled = true
                spinner.isEnabled = true
                spinner2.isEnabled = true

                button.setOnClickListener {
                    when (spinner.selectedItem) {
                        "Octet" -> {
                            resultValue =  (editTextData.text.toString()
                                .toDouble() * 8)
                        }
                        "Ko" -> {
                            resultValue =  ((editTextData.text.toString()
                                .toDouble() * 8)*1024)
                        }
                        "Mo" -> {
                            resultValue =  (((editTextData.text.toString()
                                .toDouble() * 8)*1024)*1024)
                        }
                        "Go" -> {
                            resultValue =  ((((editTextData.text.toString()
                                .toDouble() * 8)*1024)*1024)*1024)
                        }
                        "To" -> {
                            resultValue =  (((((editTextData.text.toString()
                                .toDouble() * 8)*1024)*1024)*1024)*1024)
                        }
                    }

                    when (spinner2.selectedItem) {
                        "Bps" -> {
                            resultValue /= editTextBandwidth.text.toString().toDouble() //TODO : modify this
                        }
                        "Kbps" -> {
                            resultValue /= (editTextBandwidth.text.toString().toDouble() * 1024)
                        }
                        "Mbps" -> {
                            resultValue /=  ((editTextBandwidth.text.toString().toDouble()*1024)*1024)
                        }
                        "Gbps" -> {
                            resultValue /=  (((editTextBandwidth.text.toString().toDouble()*1024)*1024)*1024)
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

                    daysTF.setText("$days")
                    hoursTF.setText("$hours")
                    minutesTF.setText("$minutes")
                    secondsTF.setText("%.3f".format(resultValue))
                }
            }

            if (checkedId == R.id.dataQuantity) {
                var resultValue = 0.0
                var totalSec: Double
                daysTF.isEnabled = true
                hoursTF.isEnabled = true
                minutesTF.isEnabled = true
                secondsTF.isEnabled = true
                editTextBandwidth.isEnabled = true
                editTextData.isEnabled = false
                spinner.isEnabled = true
                spinner2.isEnabled = true

                button.setOnClickListener {
                    totalSec =
                        (daysTF.text.toString().toDouble() * 86400) + (hoursTF.text.toString()
                            .toDouble() * 3600) + (minutesTF.text.toString()
                            .toDouble() * 60) + secondsTF.text.toString().toDouble()

                    when (spinner2.selectedItem) {
                        "Bps" -> {
                            resultValue = ((editTextBandwidth.text.toString().toDouble()) / 8) * totalSec
                        }
                        "Kbps" -> {
                            resultValue = (((editTextBandwidth.text.toString()
                                .toDouble()) / 8) * 1024) * totalSec

                        }
                        "Mbps" -> {
                            resultValue = ((((editTextBandwidth.text.toString()
                                .toDouble()) / 8) * 1024) * 1024) * totalSec
                        }
                        "Gbps" -> {
                            resultValue = (((((editTextBandwidth.text.toString()
                                .toDouble()) / 8) * 1024) * 1024) * 1024) * totalSec
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
                    editTextData.setText("%.3f".format(resultValue))
                }
            }

            if (checkedId == R.id.bandwidth) {
                var resultValue = 0.0
                var totalSec: Double
                daysTF.isEnabled = true
                hoursTF.isEnabled = true
                minutesTF.isEnabled = true
                secondsTF.isEnabled = true
                editTextBandwidth.isEnabled = false
                editTextData.isEnabled = true
                spinner.isEnabled = true
                spinner2.isEnabled = true

                button.setOnClickListener {
                    totalSec = (daysTF.text.toString().toInt() * 86400) + (hoursTF.text.toString()
                        .toInt() * 3600) + (minutesTF.text.toString()
                        .toInt() * 60) + secondsTF.text.toString().toDouble()

                    when (spinner.selectedItem) {
                        "Octet" -> {
                            resultValue = ((editTextData.text.toString().toDouble())*8)/totalSec
                        }
                        "Ko" -> {
                            resultValue = (((editTextData.text.toString()
                                .toDouble()) * 8) * 1024) / totalSec

                        }
                        "Mo" -> {
                            resultValue = ((((editTextData.text.toString()
                                .toDouble()) * 8) * 1024) * 1024) / totalSec
                        }
                        "Go" -> {
                            resultValue = (((((editTextData.text.toString()
                                .toDouble()) * 8) * 1024) * 1024) * 1024) / totalSec
                        }
                        "To" -> {
                            resultValue = ((((((editTextData.text.toString()
                                .toDouble()) * 8) * 1024) * 1024) * 1024) * 1024) / totalSec
                        }
                    }

                    when (spinner2.selectedItem) {
                        "Bps" -> {
                            resultValue = resultValue //TODO : modify this
                        }
                        "Kbps" -> {
                            resultValue /= 1024

                        }
                        "Mbps" -> {
                            resultValue = resultValue / 1024 / 1024
                        }
                        "Gbps" -> {
                            resultValue = resultValue /1024 / 1024 / 1024
                        }
                    }
                    editTextBandwidth.setText("%.3f".format(resultValue))
                }
            }
        }
    }
}
