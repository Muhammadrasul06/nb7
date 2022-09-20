package com.developper.investproject.ui.helper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.developper.investproject.R
import com.developper.investproject.databinding.FragmentTrade2Binding
import com.developper.investproject.room_Model.Trade.Note_trade
import com.example.room.NoteDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Trade2Fragment : Fragment() {

    lateinit var binding: FragmentTrade2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrade2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_trade2Fragment_to_destination_exchange)
        }

        binding.btnSave.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val percent = binding.edPercent.text.toString().toInt()
                val summa = binding.edSumma.text.toString().toInt()
                val tg_id = binding.idTg.text.toString()
                val time = binding.edClock.text.toString()
                val noteTrade = Note_trade(0, percent, summa, tg_id, time)
                NoteDataBase.DatabaseBuilder.getDatabase(requireContext()).noteDao()
                    .insertTrade(noteTrade)
            }
        }
    }
}