package com.example.surveyapp

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.example.surveyapp.ui.gallery.GalleryFragment
import com.example.surveyapp.ui.home.HomeFragment
import com.example.surveyapp.ui.send.SendFragment
import com.example.surveyapp.ui.share.ShareFragment
import com.example.surveyapp.ui.slideshow.SlideshowFragment
import com.example.surveyapp.ui.tools.ToolsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            agregar(view)
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun iniciar(view: View){
        val fragment = ShareFragment()
        val home = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.hide(home)
        transaction.commit()
    }

    fun pregunta2(view: View){
        val home = ShareFragment()
        val fragment = ToolsFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.hide(home)
        transaction.commit()
    }

    fun pregunta3(view: View){
        val home = ToolsFragment()
        val fragment = GalleryFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.hide(home)
        transaction.commit()
    }

    fun resultados(view: View){
        val home = GalleryFragment()
        val fragment = SlideshowFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.hide(home)
        transaction.commit()
    }

    fun agregar(view: View){
        val home = HomeFragment()
        val fragment = SendFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.hide(home)
        transaction.commit()
    }

    fun verResp(view: View){
        Toast.makeText(this," ",Toast.LENGTH_SHORT).show()
    }
}
