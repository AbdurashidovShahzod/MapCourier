package uz.unzosoft.maposmdroiddemo.presentation.ui.activity

import android.os.Bundle
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.compass.CompassOverlay
import uz.unzosoft.maposmdroiddemo.databinding.ActivityMapsBinding
import uz.unzosoft.maposmdroiddemo.presentation.ui.base.BaseActivity

class MapsActivity : BaseActivity<ActivityMapsBinding>() {

    private lateinit var map: org.osmdroid.views.MapView

    override fun bindingActivity(): ActivityMapsBinding {
        return ActivityMapsBinding.inflate(layoutInflater)
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        map = binding.map
        Configuration.getInstance().load(this, getSharedPreferences("couirer", MODE_PRIVATE))
        val mapController = map.controller
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setBuiltInZoomControls(true)
        map.setMultiTouchControls(true)
        mapController.setZoom(19.4 )
        val compassOverlay = CompassOverlay(this,map)
        compassOverlay.enableCompass()
        map.overlays.add(compassOverlay)
        val geoPoint = GeoPoint(41.341010692133864, 69.28675052447048)
        val marker = Marker(map)
        marker.position = geoPoint
        marker.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_CENTER)
        map.overlays.add(marker)
        mapController.animateTo(geoPoint)
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