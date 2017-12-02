package roughcode.farmersmart

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.widget.ExpandableListView



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var listAdapter: ExpandableListAdapter
    private lateinit var expListView: ExpandableListView
    private lateinit var listDataHeader: ArrayList<String>
    private lateinit var listDataChild: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the listview
        expListView = (findViewById(R.id.list) as? ExpandableListView)!!

        // preparing list data
        prepareListData()

        listAdapter = ExpandableListAdapter(this, listDataHeader, listDataChild)

        // setting list adapter
        expListView!!.setAdapter(listAdapter);

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item_name clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    /*
    * Preparing the list data
    */
    private fun prepareListData() {
        listDataHeader = ArrayList()
        listDataChild = hashMapOf()

        // Adding child data
        listDataHeader.add("Top 250")
        listDataHeader.add("Now Showing")
        listDataHeader.add("Coming Soon..")

        // Adding child data
        val top250 = ArrayList<String>()
        top250.add("The Shawshank Redemption")
        top250.add("The Godfather")
        top250.add("The Godfather: Part II")
        top250.add("Pulp Fiction")
        top250.add("The Good, the Bad and the Ugly")
        top250.add("The Dark Knight")
        top250.add("12 Angry Men")

        val nowShowing = ArrayList<String>()
        nowShowing.add("The Conjuring")
        nowShowing.add("Despicable Me 2")
        nowShowing.add("Turbo")
        nowShowing.add("Grown Ups 2")
        nowShowing.add("Red 2")
        nowShowing.add("The Wolverine")

        val comingSoon = ArrayList<String>()
        comingSoon.add("2 Guns")
        comingSoon.add("The Smurfs 2")
        comingSoon.add("The Spectacular Now")
        comingSoon.add("The Canyons")
        comingSoon.add("Europa Report")

        listDataChild.put(listDataHeader[0], top250) // Header, Child data
        listDataChild.put(listDataHeader[1], nowShowing)
        listDataChild.put(listDataHeader[2], comingSoon)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item_name clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
