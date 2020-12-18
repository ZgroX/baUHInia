package pl.ioad1.bauhinia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.ioad1.bauhinia.mapeditor.MapEditorMainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runActivity();
    }

    fun runActivity() {
        val intent = Intent(this, MapEditorMainActivity::class.java);
        startActivity(intent);
    }
}