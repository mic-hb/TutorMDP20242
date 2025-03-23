package com.example.tutorm4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tutorm4.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtnLogin.setOnClickListener {
            val username = binding.usernameEtLogin.text.toString()

//            findNavController().navigate(R.id.action_loginFragment_to_userFragment)

            val action = LoginFragmentDirections.actionLoginFragmentToUserFragment(username)
            findNavController().navigate(action)
        }
    }
}