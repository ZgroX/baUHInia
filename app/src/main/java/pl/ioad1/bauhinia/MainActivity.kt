package pl.ioad1.bauhinia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.ioad1.bauhinia.mapviewer.MapsPresentation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        MapsPresentation(MapsPresentation.UserType.USER_RESIDENT, this);
    }
}