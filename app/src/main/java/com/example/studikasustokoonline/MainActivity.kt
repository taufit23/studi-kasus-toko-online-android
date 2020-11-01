package com.example.studikasustokoonline

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.studikasustokoonline.fragment.AkunFragment
import com.example.studikasustokoonline.fragment.HomeFragment
import com.example.studikasustokoonline.fragment.KeranjangFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    val fragmentHome: Fragment = HomeFragment()
    val FragmentKeranjang: Fragment = KeranjangFragment()
    val fragmentAkun: Fragment = AkunFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuitem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpBottomNav()

    }

    fun setUpBottomNav() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, FragmentKeranjang).hide(FragmentKeranjang)
            .commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuitem = menu.getItem(0)
        menuitem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_home -> {
                    calfragment(0, fragmentHome)
                }
                R.id.navigation_keranjang -> {
                    calfragment(1, FragmentKeranjang)
                }
                R.id.navigation_akun -> {
                    calfragment(2, fragmentAkun)
                }
            }
            false
        }
    }

    fun calfragment(int: Int, fragment: Fragment) {
        menuitem = menu.getItem(int)
        menuitem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}