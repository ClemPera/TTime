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



        /*TODO : Enlever le bouton OK et faire "en réel"
                Remplacer "bande passante" par "débit" pour moins long
                Ajouter Octet/s Mo/s, etc....
                Voir pour les EditText vide pour pas que ça plante
                Augmenter la taille du radio
                Changer le titre de l'app*/

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
                            when (spinner2.selectedItem) {
                                "Bps" -> {
                                    resultValue =  (editTextData.text.toString()
                                        .toDouble() * 8) / editTextBandwidth.text.toString()
                                        .toDouble()

                                }
                                "Kbps" -> {
                                    resultValue =  (editTextData.text.toString()
                                        .toDouble() * 8) / (editTextBandwidth.text.toString()
                                        .toDouble()*1024)
                                }
                                "Mbps" -> {
                                    resultValue =  (editTextData.text.toString()
                                        .toDouble() * 8) / ((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)
                                }
                                "Gbps" -> {
                                    resultValue =  (editTextData.text.toString()
                                        .toDouble() * 8) / (((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)*1024)
                                }
                            }
                        }
                        "Ko" -> {
                            when (spinner2.selectedItem) {
                                "Bps" -> {
                                    resultValue =  ((editTextData.text.toString()
                                        .toDouble() * 8)*1024) / editTextBandwidth.text.toString()
                                        .toDouble()
                                }
                                "Kbps" -> {
                                    resultValue =  ((editTextData.text.toString()
                                        .toDouble() * 8)*1024) / (editTextBandwidth.text.toString()
                                        .toDouble()*1024)
                                }
                                "Mbps" -> {
                                    resultValue =  ((editTextData.text.toString()
                                        .toDouble() * 8)*1024) / ((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)
                                }
                                "Gbps" -> {
                                    resultValue =  ((editTextData.text.toString()
                                        .toDouble() * 8)*1024) / (((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)*1024)
                                }
                            }
                        }
                        "Mo" -> {
                            when (spinner2.selectedItem) {
                                "Bps" -> {
                                    resultValue =  (((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024) / editTextBandwidth.text.toString()
                                        .toDouble()
                                }
                                "Kbps" -> {
                                    resultValue =  (((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024) / (editTextBandwidth.text.toString()
                                        .toDouble()*1024)
                                }
                                "Mbps" -> {
                                    resultValue =  (((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024) / ((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)
                                }
                                "Gbps" -> {
                                    resultValue =  (((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024) / (((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)*1024)
                                }
                            }
                        }
                        "Go" -> {
                            when (spinner2.selectedItem) {
                                "Bps" -> {
                                    resultValue =  ((((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024)*1024) / editTextBandwidth.text.toString()
                                        .toDouble()
                                }
                                "Kbps" -> {
                                    resultValue =  ((((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024)*1024) / (editTextBandwidth.text.toString()
                                        .toDouble()*1024)
                                }
                                "Mbps" -> {
                                    resultValue =  ((((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024)*1024) / ((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)
                                }
                                "Gbps" -> {
                                    resultValue =  ((((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024)*1024) / (((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)*1024)
                                }
                            }
                        }
                        "To" -> {
                            when (spinner2.selectedItem) {
                                "Bps" -> {
                                    resultValue =  (((((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024)*1024)*1024) / editTextBandwidth.text.toString()
                                        .toDouble()
                                }
                                "Kbps" -> {
                                    resultValue =  (((((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024)*1024)*1024) / (editTextBandwidth.text.toString()
                                        .toDouble()*1024)
                                }
                                "Mbps" -> {
                                    resultValue =  (((((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024)*1024)*1024) / ((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)
                                }
                                "Gbps" -> {
                                    resultValue =  (((((editTextData.text.toString()
                                        .toDouble() * 8)*1024)*1024)*1024)*1024) / (((editTextBandwidth.text.toString()
                                        .toDouble()*1024)*1024)*1024)
                                }
                            }
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

                    //resultValue = String.format("%.3f", resultValue).toDouble() // Rounded to 3 decimal
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
                            spinner.setSelection(0) //Set bandwidth spinner to Bps
                        }
                        "Kbps" -> {
                            resultValue = ((((editTextBandwidth.text.toString().toDouble()) / 8)*1024) * totalSec)/1024
                            spinner.setSelection(1) //Set bandwidth spinner to Kbps

                        }
                        "Mbps" -> {
                            resultValue = ((((((editTextBandwidth.text.toString().toDouble())/8)*1024)*1024)*totalSec)/1024)/1024
                            spinner.setSelection(2) //Set bandwidth spinner to Mbps
                        }
                        "Gbps" -> {
                            resultValue = (((((((((editTextBandwidth.text.toString().toDouble()) / 8)*1024)*1024)*1024) * totalSec)/1024)/1024)/1024)
                            spinner.setSelection(3) //Set bandwidth spinner to Mbps
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
                spinner2.isEnabled = false

                button.setOnClickListener {
                    totalSec = (daysTF.text.toString().toInt() * 86400) + (hoursTF.text.toString()
                        .toInt() * 3600) + (minutesTF.text.toString()
                        .toInt() * 60) + secondsTF.text.toString().toDouble()

                    when (spinner.selectedItem) {
                        "Octet" -> {
                            resultValue = ((editTextData.text.toString().toDouble())*8)/totalSec
                            spinner2.setSelection(0) //Set bandwidth spinner to Bps
                        }
                        "Ko" -> {
                            resultValue = ((((editTextData.text.toString().toDouble())*8)*1024)/totalSec)/1024
                            spinner2.setSelection(1) //Set bandwidth spinner to Kbps

                        }
                        "Mo" -> {
                            resultValue = ((((((editTextData.text.toString().toDouble())*8)*1024)*1024)/totalSec)/1024)/1024
                            spinner2.setSelection(2) //Set bandwidth spinner to Mbps
                        }
                        "Go" -> {
                            resultValue = ((((((((editTextData.text.toString().toDouble())*8)*1024)*1024)*1024)/totalSec)/1024)/1024)/1024
                            spinner2.setSelection(3) //Set bandwidth spinner to Mbps
                        }
                        "To" -> {
                            resultValue = (((((((((editTextData.text.toString().toDouble())*8)*1024)*1024)*1024)*1024)/totalSec)/1024)/1024)/1024
                            spinner2.setSelection(3) //Set bandwidth spinner to Mbps
                        }
                    }

                    editTextBandwidth.setText("%.3f".format(resultValue))
                }
            }
        }
    }
}
