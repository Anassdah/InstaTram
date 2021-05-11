package com.example.myapplication.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.data.TramRepository

class HomeViewModel(app: Application) : AndroidViewModel(app){
    private val dataRepo = TramRepository(app)
    val tramData= dataRepo.tramData
}