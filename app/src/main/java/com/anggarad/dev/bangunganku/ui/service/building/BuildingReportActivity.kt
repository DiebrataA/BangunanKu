package com.anggarad.dev.bangunganku.ui.service.building

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anggarad.dev.bangunganku.databinding.ActivityBuildingReportBinding

class BuildingReportActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBuildingReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildingReportBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}