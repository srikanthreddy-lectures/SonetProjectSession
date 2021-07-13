package com.example.sonetprojectsession.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.sonetprojectsession.R
import com.example.sonetprojectsession.data.User
import com.example.sonetprojectsession.data.UserData
import com.example.sonetprojectsession.databinding.FragmentAddBinding
import com.example.sonetprojectsession.databinding.FragmentListBinding

class FragmentAdd : Fragment() {
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // var add_btn = activity?.findViewById<Button>(R.id.add_btn)
        binding.addBtn.setOnClickListener(View.OnClickListener {

           // val firstname = activity?.findViewById<EditText>(R.id.addFirstName_et)
           // val lastname = activity?.findViewById<EditText>(R.id.addLastName_et)
           // val age = activity?.findViewById<EditText>(R.id.addAge_et)

            var user = User(0,binding.addFirstNameEt.text.toString(),binding.addLastNameEt.text.toString(),binding.addAgeEt.text.toString().toInt());

            UserData.addUser(user)

            val fm = activity?.supportFragmentManager
            val ft = fm?.beginTransaction()
            ft?.replace(R.id.fragment,FragmentList())
            ft?.commit()
        })
    }
}