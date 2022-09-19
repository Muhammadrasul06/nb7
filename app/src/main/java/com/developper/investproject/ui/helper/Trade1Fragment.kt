package com.developper.investproject.ui.helper

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.developper.investproject.R
import com.developper.investproject.`class`.Constants
import com.developper.investproject.databinding.FragmentTrade1Binding
import com.developper.investproject.room_Model.Note
import com.example.room.NoteDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Trade1Fragment : Fragment() {

    lateinit var binding: FragmentTrade1Binding
    lateinit var preferences: SharedPreferences


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
//SharedPreferencce boshi
        binding.btnNext.setOnClickListener {
            val summa = binding.edSumma.text.toString()
            val telegram = binding.edTelegram.text.toString()
            if (summa.isNullOrEmpty()) {

                binding.edSumma.setHintTextColor(
                    ContextCompat.getColor(
                        requireActivity(),
                        R.color.red
                    )
                )
            } else if (telegram.isNullOrEmpty()) {
                binding.edTelegram.setHintTextColor(
                    ContextCompat.getColor(
                        requireActivity(), R.color.red
                    )
                )
            } else {
                saveUser(summa, telegram)
                Toast.makeText(requireContext(), "saveUser(100.to, 1234567890.toString())", Toast.LENGTH_SHORT).show()
            }
        }
        //SharedPreference oxriri

//Room boshi
        binding.btnNext.setOnClickListener {

            val note =
                Note(
                    0,
                    binding.edSumma.text.toString().toInt(),
                    binding.edTelegram.text.toString(),
                    binding.edTime.text.toString()
                )
            GlobalScope.launch(Dispatchers.IO) {
                NoteDataBase.DatabaseBuilder.getDatabase(requireContext()).noteDao()
                    .insertNote(note)

            }

            //Room oxiri

            findNavController().navigate(R.id.action_trade1Fragment_to_paymentsFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    fun saveUser(summa: String, telegram: String) {
        val myEdit: SharedPreferences.Editor = preferences.edit()
        myEdit.putString(Constants.key_Summa, summa)
        myEdit.putString(Constants.key_Telegram, telegram)

        myEdit.apply()
        //requireActivity().finish()
    }
}