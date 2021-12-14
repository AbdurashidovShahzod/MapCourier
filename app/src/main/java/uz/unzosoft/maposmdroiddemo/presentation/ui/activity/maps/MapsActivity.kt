package uz.unzosoft.maposmdroiddemo.presentation.ui.activity.maps

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.OverlayItem
import org.osmdroid.views.overlay.compass.CompassOverlay
import uz.unzosoft.maposmdroiddemo.databinding.ActivityMapsBinding
import uz.unzosoft.maposmdroiddemo.presentation.ui.base.BaseActivity


class MapsActivity : BaseActivity<ActivityMapsBinding>() {

    private val viewModel: MapActivityVM by viewModels()
    private lateinit var map: org.osmdroid.views.MapView
    var currentLocationOverlay: ItemizedIconOverlay<OverlayItem>? = null


    override fun bindingActivity(): ActivityMapsBinding {
        return ActivityMapsBinding.inflate(layoutInflater)
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreated(savedInstanceState: Bundle?) {
        map = binding.map
        Configuration.getInstance().load(this, getSharedPreferences("couirer", MODE_PRIVATE))
        val mapController = map.controller
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setBuiltInZoomControls(true)
        map.setMultiTouchControls(true)
        mapController.setZoom(19.4)
        val compassOverlay = CompassOverlay(this, map)
        compassOverlay.enableCompass()
        map.overlays.add(compassOverlay)
        val geoPoint = GeoPoint(41.341010692133864, 69.28675052447048)
        val marker = Marker(map)
        marker.position = geoPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
        map.overlays.add(marker)


        val currentLocation = GeoPoint(41.341010692133864, 69.28675052447048)
        val currentLocation2 = GeoPoint(41.342785252244624, 69.28698977855444)
        var myLocationOverlayItem = OverlayItem("Shahzod", "Current Position", currentLocation)
        var myCurrentLocationMarker = this.resources.getDrawable(R.drawable.sym_action_call)
        myLocationOverlayItem.setMarker(myCurrentLocationMarker)

        val items = ArrayList<OverlayItem>()
        items.add(myLocationOverlayItem)



        myLocationOverlayItem = OverlayItem("Shohruh", "Current Position", currentLocation2)
        myCurrentLocationMarker = resources.getDrawable(R.drawable.sym_action_call)
        myLocationOverlayItem.setMarker(myCurrentLocationMarker)



        items.add(myLocationOverlayItem)



        currentLocationOverlay = ItemizedIconOverlay<OverlayItem>(
            items, object : OnItemGestureListener<OverlayItem> {
                override fun onItemSingleTapUp(index: Int, item: OverlayItem?): Boolean {
                    return true
                }

                override fun onItemLongPress(index: Int, item: OverlayItem?): Boolean {
                    return true
                }

            }, this
        )
        map.overlays.add(this.currentLocationOverlay)



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