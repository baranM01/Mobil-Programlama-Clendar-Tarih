package com.example.myapplication

import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

   lateinit var editTextAd: EditText
   lateinit var editTextVize: EditText
   lateinit var editTextFinal: EditText
   lateinit var RGcinsiyet:RadioGroup
   lateinit var radiobuttonErkek:RadioButton
   lateinit var radiobuttonKadin:RadioButton
   lateinit var RGsira:RadioGroup
   lateinit var RB1:RadioButton
   lateinit var RB2:RadioButton
   lateinit var RB3:RadioButton
   lateinit var CBjava:CheckBox
   lateinit var CBphyton:CheckBox
   lateinit var CBkotlin:CheckBox
    lateinit var CBc:CheckBox
    lateinit var TextViewSonucRakam:TextView
    lateinit var buttonAktar: Button
    lateinit var datePicker:DatePicker
    lateinit var textViewDate: TextView

     fun init(){

        editTextAd = findViewById(R.id.editTextAd)
        editTextVize = findViewById(R.id.editTextVize)
        editTextFinal = findViewById(R.id.editTextFinal)
        RGcinsiyet = findViewById(R.id.RGcinsiyet)
       radiobuttonErkek = findViewById(R.id.radiobuttonErkek)
        radiobuttonKadin = findViewById(R.id.radiobuttonKadin)
        RGsira = findViewById(R.id.RGsira)
        RB1 = findViewById(R.id.RB1)
        RB2 = findViewById(R.id.RB2)
        RB3 = findViewById(R.id.RB3)
        CBjava = findViewById(R.id.CBjava)
        CBphyton = findViewById(R.id.CBphyton)
        CBkotlin = findViewById(R.id.CBkotlin)
        CBc = findViewById(R.id.CBc)
        TextViewSonucRakam = findViewById(R.id.textViewSonucRakam)
        buttonAktar = findViewById(R.id.buttonAktar)
         datePicker = findViewById(R.id.datePicker)
         textViewDate = findViewById(R.id.textViewDate)


    }

    var secilenCinsiyetRG = ""
    var secilenSiraRG = ""
    var girilenVize = 0
    var girilenFinal = 0
    var notSonuc = 0
    var CBsecilenDiller = ""

    var java = false; var phyton = false; var kotlin = false; var c = false;

    var NotDurum = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        buttonAktar.setOnClickListener {

            intent = Intent(this@MainActivity,ActivitySonuc::class.java)

            var Ad = editTextAd.text.toString()
            intent.putExtra("isim",Ad)

            // RadioGruplar :

            intent.putExtra("cinsiyet",secilenCinsiyetRG)
            intent.putExtra("sira",secilenSiraRG)

            girilenVize = editTextVize.text.toString().toInt()
            girilenFinal = editTextFinal.text.toString().toInt()
            notSonuc = ((girilenVize*40)/100) + ((girilenFinal*60)/100)

            intent.putExtra("Notsonuc",notSonuc)

            if(25>notSonuc && notSonuc>=0){ NotDurum = "FF" }
           else if(40>notSonuc && notSonuc>=25){ NotDurum = "DD" }
           else if(70>notSonuc && notSonuc>=40){ NotDurum = "CC" }
           else if(100>=notSonuc && notSonuc>=70){ NotDurum = "AA" }

            intent.putExtra("harfNotu",NotDurum)


            if(java){ CBsecilenDiller += "java, "}
            if(phyton){ CBsecilenDiller += "phyton, "}
            if(kotlin){ CBsecilenDiller += "kotlin, "}
            if(c){ CBsecilenDiller += "C#, "}

            intent.putExtra("secilenDiller",CBsecilenDiller)



            startActivity(intent)

        }
        TextViewSonucRakam.text = notSonuc.toString()

        // RadioGroup

        RGcinsiyet.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId==R.id.radiobuttonErkek){ secilenCinsiyetRG = "Erkek" }
            else if(checkedId==R.id.radiobuttonKadin){ secilenCinsiyetRG = "Kadın"}
        }

        RGsira.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId==R.id.RB1){ secilenSiraRG = "100 puan" }
            else if(checkedId==R.id.RB2){ secilenCinsiyetRG = "80 puan"}
            else if(checkedId==R.id.RB3){ secilenCinsiyetRG = "60 puan"}
        }

        CBjava.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){ java = true }
        }
        CBphyton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){ phyton = true }
        }
        CBkotlin.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){ kotlin = true }
        }
        CBc.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){ c = true }
        }

        // API level 24 ve üzerindeki cihazlarda çalışıyor :

        var bugun = Calendar.getInstance()

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            datePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
                textViewDate.text = (bugun.get(Calendar.YEAR) - year).toString()
            }
        }
    }
}