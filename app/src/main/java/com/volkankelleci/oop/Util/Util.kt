package com.volkankelleci.oop.Util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.volkankelleci.oop.R

//Util Kotlin Dosyası içerisine bunlar yazılır.
fun ImageView.gorselIndır(url:String?,placeHolder:CircularProgressDrawable){
    val options= RequestOptions().placeholder(placeHolder).error(R.mipmap.ic_launcher_round)
    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)
}
fun placeHolderYap(context:Context):CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth=8f //görünümün kalınlığı "progress barın"
        centerRadius=40f //çapı
        start() //başlatmak için
    }
}