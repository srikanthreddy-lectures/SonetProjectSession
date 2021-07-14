package com.example.sonetprojectsession.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetprojectsession.R
import com.example.sonetprojectsession.data.User
import com.example.sonetprojectsession.data.UserData
import com.example.sonetprojectsession.data.UserDatabase
import com.example.sonetprojectsession.databinding.FragmentListBinding
import com.example.sonetprojectsession.repository.UserViewModel
import com.example.sonetprojectsession.utility.UserListAdapter
import kotlinx.coroutines.launch

class FragmentList:Fragment() {
    var userAdapter = UserListAdapter()
    lateinit var viewModel:UserViewModel
    lateinit var binding:FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //var add_btn = activity?.findViewById<FloatingActionButton>(R.id.floating_add_button)
        binding.floatingAddButton.setOnClickListener(View.OnClickListener {
            val fm = activity?.supportFragmentManager
            val ft = fm?.beginTransaction()
            ft?.replace(R.id.fragment,FragmentAdd())
            ft?.commit()
        })

       // var rcv = activity?.findViewById<RecyclerView>(R.id.rcv)

        binding.rcv.layoutManager = LinearLayoutManager(activity)

        //Log.i("----->","test")

        //var user = User(12,"Ranjan","Reddy",32)

        //var userDao = UserDatabase.getDatabase(requireContext()).userDao()
        //lifecycleScope.launch {
        //    userAdapter.setUserData(userDao.readAllData())
       // }

        viewModel.readAllData.observe(this, Observer { user ->
            userAdapter.setUserData(user)
        })


        //userAdapter.setUserData(UserData.userList)

        binding.rcv.adapter = userAdapter


    }
}