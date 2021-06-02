package com.anggarad.dev.bangunganku.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anggarad.dev.bangunganku.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    //
//    private lateinit var lastLocation: Location
//    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
//    lateinit var locationManager: LocationManager
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
//
//        setUpLocationPermission()
    }

//    override fun onLocationChanged(location: Location) {
//        TODO("Not yet implemented")
//    }
//
//    private fun setUpLocationPermission() {
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED &&
//            ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(
//                    Manifest.permission.ACCESS_FINE_LOCATION,
//                    Manifest.permission.ACCESS_COARSE_LOCATION
//                ),
//                101
//            )
//
//
//        }
//
//        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)!!
//
//
//    }
//
//    private fun setLocation(currentLatLng: LatLng, location: Location) {
//
//        var geocoder = Geocoder(this, Locale.getDefault())
//        var addresses = geocoder.getFromLocation(location.latitude, location.longitude, 2)
//        var address = addresses[0]
//
//
//        binding..text = "${address.getAddressLine(0)}, ${address.locality}"
//    }
}