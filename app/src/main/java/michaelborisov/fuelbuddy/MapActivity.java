package michaelborisov.fuelbuddy;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        prepareMap();
        supportActionBarTunning();
        initListeners();

    }

    private void prepareMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void supportActionBarTunning(){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.layout_action_bar);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#330000ff"))
        );
        getSupportActionBar().setStackedBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#550000ff"))
        );
    }


    private void initListeners(){
        ImageView ivProfile = (ImageView)findViewById(R.id.profile);
        setOnClickConfigurer(ivProfile, "Clicked on profile");

        ImageView ivSettings = (ImageView)findViewById(R.id.settings);
        setOnClickConfigurer(ivSettings, "Clicked on settings");

        ImageView ivGeo = (ImageView)findViewById(R.id.ivGeo);
        setOnClickConfigurer(ivGeo, "Clicked on geo");

        ImageView ivPlus = (ImageView)findViewById(R.id.ivPlus);
        setOnClickConfigurer(ivPlus, "Clicked on plus");
    }

    private void setOnClickConfigurer(View v, final String message){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, message, Snackbar.LENGTH_LONG).show();
            }
        });
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
