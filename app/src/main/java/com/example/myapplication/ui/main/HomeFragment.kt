package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.HomeActivity
import com.example.myapplication.R

class MainFragment : Fragment() {

   /* var layoutManager: RecyclerView.LayoutManager?=null
    var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null*/


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*layoutManager=LinearLayoutManager(this)

        recyclerView.layoutManager=layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter=adapter*/
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.tramData.observe(viewLifecycleOwner, Observer{

            val adapter = MainRecyclerAdapter(requireContext(), it)
            recyclerView.adapter = adapter

        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

}