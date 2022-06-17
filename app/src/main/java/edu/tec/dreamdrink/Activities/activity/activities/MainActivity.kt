package edu.tec.dreamdrink.Activities.activity.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationView
import edu.tec.dreamdrink.Activities.activity.indexFragment
import edu.tec.dreamdrink.Activities.activity.utils.FirebaseUtilis.firebaseAuth
import edu.tec.dreamdrink.R


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var  drawer: DrawerLayout
    private lateinit var toogle:ActionBarDrawerToggle
    //private lateinit var inicioSesion: indexFragment

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toogle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navegation_drawer_open,
            R.string.navegation_drawer_close
        )
        drawer.addDrawerListener(toogle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


    }

    override  fun onNavigationItemSelected(item: MenuItem): Boolean {
        //inicioSesion = indexFragment()
        if (item.itemId == R.id.nav_item_one) {
           findNavController(R.id.contenedor).navigate(R.id.incioSesionFragment)

                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show()
        }
        else if (item.itemId  == R.id.nav_item_four) {

            findNavController(R.id.contenedor).navigate(R.id.indexFragment)
            Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT).show()


        } else if (item.itemId  == R.id.nav_item_seven) {

            logOut()


        }



        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun logOut(){

            firebaseAuth.signOut()
            findNavController(R.id.contenedor).navigate(R.id.indexFragment)

    }



}