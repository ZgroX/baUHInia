package pl.ioad1.bauhinia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pl.ioad1.bauhinia.mapviewer.MapViewerMainActivity
import pl.ioad1.bauhinia.mapviewer.MapsPresentation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MapsPresentation(MapsPresentation.UserType.USER_RESIDENT, this);
    }
}