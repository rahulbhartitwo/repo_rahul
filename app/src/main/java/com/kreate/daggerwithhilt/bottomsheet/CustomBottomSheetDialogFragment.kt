package com.kreate.daggerwithhilt.bottomsheet

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kreate.daggerwithhilt.R
import com.kreate.daggerwithhilt.databinding.LayoutModalBottomSheetBinding

class CustomBottomSheetDialogFragment : BottomSheetDialogFragment() {
lateinit var binding: LayoutModalBottomSheetBinding
    companion object {

        const val TAG = "CustomBottomSheetDialogFragment"

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater , R.layout.layout_modal_bottom_sheet, container, false)
       return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.firstButton.setOnClickListener {
            //handle click event
            Toast.makeText(context, "First Button Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.secondButton.setOnClickListener {
            //handle click event
            Toast.makeText(context, "Second Button Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.thirdButton.setOnClickListener {
            //handle click event
            Toast.makeText(context, "Third Button Clicked", Toast.LENGTH_SHORT).show()
        }

    }
}