package com.developper.investproject.ui.helper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.developper.investproject.R
import com.developper.investproject.databinding.FragmentInvestBinding
import com.developper.investproject.room_Model.Note
import com.example.room.NoteDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InvestFragment : Fragment() {

    lateinit var binding: FragmentInvestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInvestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {

            val note =
                Note(
                    0,
                    binding.edSumma.text.toString().toInt(),
                    binding.idTg.text.toString(),
                    binding.edClock.text.toString()
                )
            GlobalScope.launch(Dispatchers.IO) {
                NoteDataBase.DatabaseBuilder.getDatabase(requireContext()).noteDao()
                    .insertNote(note)

            }
            Toast.makeText(context, "Успесно приняли сумма $", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_investFragment_to_publishedFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }


    }
}