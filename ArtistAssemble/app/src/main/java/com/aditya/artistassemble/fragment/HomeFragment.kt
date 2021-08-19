package com.aditya.artistassemble.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aditya.artistassemble.R
import com.aditya.artistassemble.adapter.DashboardRecyclerAdapter
import com.aditya.artistassemble.model.Drawing

class HomeFragment : Fragment() {

    lateinit var recyclerhome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: DashboardRecyclerAdapter
    val artInfoList = arrayListOf(
        Drawing(1, "Aditya", "5.0", R.drawable.kill, "Rs. 600", "Kill Bill"),
        Drawing(2, "Dr. Ravi Bhushan", "4.9", R.drawable.school, "Rs. 700", "Netrahaat Memories"),
        Drawing(3, "Dr. Ravi Bhushan", "4.5", R.drawable.meena, "Rs. 500", "Paakiza"),
        Drawing(4, "Tulika", "3.9", R.drawable.pikachu, "Rs. 400", "Pikachu Pickles"),
        Drawing(5, "Aditya", "4.9", R.drawable.breaking, "Rs. 600", "Breaking Bad"),
        Drawing(6, "Aditya", "4.3", R.drawable.bond, "Rs. 500", "From Russia with love"),
        Drawing(7, "Dr. Ravi Bhushan","4.2",R.drawable.farming,"Rs. 500","Farmers of West Bihar"),
        Drawing(8,"Dr. Ravi Bhushan","4.0",R.drawable.village,"Rs. 500","In the laps of Nature"),
        Drawing(9, "Tulika", "4.0", R.drawable.mango, "Rs. 400", "Mango Love"),
        Drawing(10, "Tulika", "4.9", R.drawable.peacocklady, "Rs. 400", "Peacock Lady"),
        Drawing(11, "Aditya", "5.0", R.drawable.harrypotter, "Rs. 600", "Harry Potter"),
        Drawing(12, "Aditya", "4.9", R.drawable.scarface, "Rs. 700", "Scarface"),
        Drawing(13, "Tulika", "4.5", R.drawable.scooter, "Rs. 500", "Shooter Scooter"),
        Drawing(14, "Tulika", "3.9", R.drawable.girl, "Rs. 300", "Mad Angles"),
        Drawing(15, "Aditya", "4.5", R.drawable.anakin, "Rs. 300", "Anakin"),
        Drawing(16, "Aditya", "5.0", R.drawable.johnwick, "Rs. 600", "John Wick"),
        Drawing(17, "Aditya", "4.9", R.drawable.starwars, "Rs. 700", "Star Wars"),
        Drawing(18, "Aditya", "4.7", R.drawable.yojimbo, "Rs. 600", "Yojimbo"),
        Drawing(19, "Aditya", "4.9", R.drawable.lotr, "Rs. 700", "Lord of the Rings"),
        Drawing(20, "Aditya", "3.9", R.drawable.pulp, "Rs. 300", "5$ milkshake"),
        Drawing(21, "Aditya", "4.2", R.drawable.hansolo, "Rs. 300", "Han Solo")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerhome = view.findViewById(R.id.recyclerhome)
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, artInfoList)
        recyclerhome.adapter = recyclerAdapter
        recyclerhome.layoutManager = layoutManager

        recyclerhome.addItemDecoration(
            DividerItemDecoration(
                recyclerhome.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )
        return view
    }


}
