package com.developper.investproject.ui.helper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.developper.investproject.R
import com.developper.investproject.databinding.FragmentTrade1Binding
import com.developper.investproject.room_Model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Trade1Fragment : Fragment() {

    lateinit var binding: FragmentTrade1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentTrade1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {

            val note =
                Note(
                    0,
                    binding.edSumma.text.toString().toInt(),
                    binding.edTelegram.text.toString(),
                    binding.edTime.text.toString()
                )
            GlobalScope.launch(Dispatchers.IO) {
                NoteDatabaseTrade.DatabaseBuilderTrade.getDatabaseTrade(requireContext()).noteDoa_trade()
                    .insertNote_trade(note)

            }
            findNavController().navigate(R.id.action_investFragment_to_publishedFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}