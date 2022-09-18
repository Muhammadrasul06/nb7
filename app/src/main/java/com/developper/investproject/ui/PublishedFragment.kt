package com.developper.investproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developper.investproject.R
import com.developper.investproject.databinding.FragmentInvestBinding
import com.developper.investproject.databinding.FragmentPublishedBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PublishedFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentPublishedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPublishedBinding.inflate(layoutInflater)
        return binding.root
    }


}