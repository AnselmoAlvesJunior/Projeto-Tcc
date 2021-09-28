package com.example.projetotcc.view.ui.fragment;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.projetotcc.R;
import com.example.projetotcc.view.ui.adapter.PostAdapter


class PostFragment : Fragment() {

    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val view= inflater.inflate(R.layout.fragment_post,container,false)

        val recycler=view.findViewById<RecyclerView>(R.id.recycler_post)

        recycler.layoutManager=LinearLayoutManager(context)

        recycler.adapter=PostAdapter()

        return view
    }
}
