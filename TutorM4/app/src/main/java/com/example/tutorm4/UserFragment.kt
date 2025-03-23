package com.example.tutorm4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.tutorm4.databinding.FragmentRegisterBinding
import com.example.tutorm4.databinding.FragmentUserBinding


class UserFragment : Fragment() {
    lateinit var binding: FragmentUserBinding
    val args by navArgs<UserFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNama.text = "Hello, ${args.activeUser}"
    }
}