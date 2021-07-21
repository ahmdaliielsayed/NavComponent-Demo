package com.example.navcomponentdemo.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navcomponentdemo.R
import com.google.android.material.textfield.TextInputEditText

class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.next_btn -> {
                if (!TextUtils.isEmpty(requireView().findViewById<TextInputEditText>(R.id.input_recipient).text)) {
                    val bundle = bundleOf("recipient" to requireView().findViewById<TextInputEditText>(R.id.input_recipient).text.toString())
                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle)
                }  else {
                    Toast.makeText(activity, "Enter an recipient!", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> requireActivity().onBackPressed()
        }
    }
}