package com.example.sonetprojectsession.utility

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetprojectsession.R
import com.example.sonetprojectsession.data.User

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    var userList = emptyList<User>()
    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var currentPos = userList[position]
        var id = holder.itemView.findViewById<TextView>(R.id.id_txt)
        id.text=currentPos.id.toString()

        var firstname = holder.itemView.findViewById<TextView>(R.id.firstName_txt)
        firstname.text=currentPos.firstname.toString()

        var lastname = holder.itemView.findViewById<TextView>(R.id.lastName_txt)
        lastname.text=currentPos.lastname.toString()

        var age = holder.itemView.findViewById<TextView>(R.id.age_txt)
        age.text=currentPos.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setUserData(user:List<User>){
        userList = user
        notifyDataSetChanged()
    }

}