package com.example.sonetprojectsession.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetprojectsession.R
import com.example.sonetprojectsession.data.User
import com.example.sonetprojectsession.utility.UserListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentList:Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var add_btn = activity?.findViewById<FloatingActionButton>(R.id.floating_add_button)
        add_btn?.setOnClickListener(View.OnClickListener {
            val fm = activity?.supportFragmentManager
            val ft = fm?.beginTransaction()
            ft?.replace(R.id.fragment,FragmentAdd())
            ft?.commit()
        })

        var rcv = activity?.findViewById<RecyclerView>(R.id.rcv)

        var userAdapter = UserListAdapter()

        Log.i("----->","test")

        var user = User(12,"Ranjan","Reddy",32)

        userAdapter.setUserData(listOf<User>(user))

        rcv?.adapter = userAdapter


    }
}