package com.anggarad.dev.bangunganku.ui.service.building

import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anggarad.dev.bangunganku.data.UserPreferences
import com.anggarad.dev.bangunganku.databinding.ActivityServiceReportBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.util.*

class ServiceReportActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceReportBinding
    private lateinit var userPref: UserPreferences

    companion object {
        const val TYPE_BUILDING = "type_building"
        const val EXTRA_LOCATION = "extra_location"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val viewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.NewInstanceFactory()
//        )[ServiceReportViewModel::class.java]
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        userPref = UserPreferences(this)
        val type = intent.getStringExtra(TYPE_BUILDING)
        val location = intent.getParcelableExtra<Location>(EXTRA_LOCATION)

        val name = runBlocking { userPref.getUserName.first() }
        binding.tvNameReport.text = name

        setLocation(location)

        if (type.equals("menu1", ignoreCase = true)) {
            supportActionBar?.title = "Report Damaged Building"

        }

        if (type.equals("menu2", ignoreCase = true)) {
            supportActionBar?.title = "Report Damaged Road"


        }


    }

    private fun setLocation(location: Location?) {

        var geocoder = Geocoder(this, Locale.getDefault())
        var addresses =
            location?.let { geocoder.getFromLocation(it.latitude, location.longitude, 2) }
        var address = addresses?.get(0)


        binding.tvAddressReport.text = "${address?.getAddressLine(0)}"

    }

    fun buildingRecognize(processToken: String) {

    }
}