package com.example.studikasustokoonline.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.studikasustokoonline.R
import com.example.studikasustokoonline.model.Produk
import com.inyongtisto.tutorial.adapter.AdapterSlider
import kotlinx.android.synthetic.main.item_slider.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var vpSlider: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slide1)
        arrSlider.add(R.drawable.slide2)
        arrSlider.add(R.drawable.slide3)
        arrSlider.add(R.drawable.slide4)
        arrSlider.add(R.drawable.slide5)
        arrSlider.add(R.drawable.slide6)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider
        return view
    }
    val arrProduk: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1= Produk()
        p1.nama = "HP core I5 8GbRam"
        p1.harga = "Rp. 6.800.000"
        p1.gambar = R.drawable.slide2

        val p2= Produk()
        p2.nama = "HP core I7 8GbRam"
        p2.harga = "Rp. 8.500.000"
        p2.gambar = R.drawable.hp_14_bs749tu

        val p3= Produk()
        p3.nama = "HP core I3 4GbRam"
        p3.harga = "Rp. 3.900.000"
        p3.gambar = R.drawable.hp_envy_13_aq0019tx

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)



        return arr
    }


}