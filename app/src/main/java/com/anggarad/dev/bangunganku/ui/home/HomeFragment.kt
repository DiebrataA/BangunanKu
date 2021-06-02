package com.anggarad.dev.bangunganku.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.anggarad.dev.bangunganku.databinding.FragmentHomeBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class HomeFragment : Fragment(), LocationListener {

    private lateinit var lastLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationManager: LocationManager
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        setUpLocationPermission()
    }

    override fun onLocationChanged(location: Location) {
        TODO("Not yet implemented")
    }

    private fun setUpLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                101
            )


        }

        locationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)!!

        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                lastLocation = location
                setLocation(location)
            }
        }
    }

    private fun setLocation(location: Location) {

        var geocoder = Geocoder(requireContext(), Locale.getDefault())
        var addresses = geocoder.getFromLocation(location.latitude, location.longitude, 2)
        var address = addresses[0]


        binding.tvLocation.text = "${address.getAddressLine(0)}, ${address.locality}"
    }
}