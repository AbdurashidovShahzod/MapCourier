package uz.unzosoft.maposmdroiddemo.presentation.ui.activity

import android.os.Bundle
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import uz.unzosoft.maposmdroiddemo.databinding.ActivityMapsBinding
import uz.unzosoft.maposmdroiddemo.presentation.ui.base.BaseActivity

class MapsActivity : BaseActivity<ActivityMapsBinding>() {

    lateinit var map: org.osmdroid.views.MapView

    override fun bindingActivity(): ActivityMapsBinding {
        return ActivityMapsBinding.inflate(layoutInflater)
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        map = org.osmdroid.views.MapView(this)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setBuiltInZoomControls(true)
        map.setMultiTouchControls(true)
        val mapController = map.controller
        mapController.setZoom(9.5)
        val geoPoint = GeoPoint(41.341010692133864, 69.28675052447048)
        mapController.setCenter(geoPoint)
    }

    override fun onResume() {
        super.onResume()
        binding.map.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.map.onPause()
    }

}