package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivitySonuc : AppCompatActivity() {

    lateinit var TextViewAd:TextView
    lateinit var TextViewCinsiyet:TextView
    lateinit var TextViewDiller:TextView
    lateinit var TextViewPuan:TextView
    lateinit var TextViewNotSonuc:TextView
    lateinit var TextViewHarfNotu:TextView

    fun init(){

        TextViewAd = findViewById(R.id.textViewAd)
        TextViewCinsiyet = findViewById(R.id.textViewCinsiyet)
        TextViewDiller = findViewById(R.id.textViewDiller)
        TextViewPuan = findViewById(R.id.textViewPuan)
        TextViewNotSonuc = findViewById(R.id.textViewNotSonuc)
        TextViewHarfNotu = findViewById(R.id.textViewHarfNotu)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        init()

        var bundle : Bundle
        bundle=intent.extras!!

        var ad = bundle?.get("isim")
        TextViewAd.text = ad.toString()

        var cns = bundle?.get("cinsiyet")
        TextViewCinsiyet.text = cns.toString()

        var dil = bundle?.get("secilenDiller")
        TextViewDiller.text = dil.toString()

        var puan = bundle?.get("sira")
        TextViewPuan.text = puan.toString()

        var not = bundle?.get("Notsonuc")
        TextViewNotSonuc.text = not.toString()

        var Harf = bundle?.get("harfNotu")
        TextViewHarfNotu.text = Harf.toString()




    }
}