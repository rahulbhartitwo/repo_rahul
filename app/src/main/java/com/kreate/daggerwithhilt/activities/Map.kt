package com.kreate.daggerwithhilt.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kreate.daggerwithhilt.R
import com.kreate.daggerwithhilt.bottomsheet.CustomBottomSheetDialogFragment
import com.kreate.daggerwithhilt.databinding.ActivityMapBinding

class Map : AppCompatActivity() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    lateinit var binding  : ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_map)
        bottomSheetBehavior = BottomSheetBehavior.from(binding.map.bottomSheet)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // handle onSlide
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(
                        this@Map,
                        "STATE_COLLAPSED",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(
                        this@Map,
                        "STATE_EXPANDED",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(
                        this@Map,
                        "STATE_DRAGGING",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(
                        this@Map,
                        "STATE_SETTLING",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(
                        this@Map,
                        "STATE_HIDDEN",
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> Toast.makeText(this@Map, "OTHER_STATE", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.btnBottomSheetPersistent.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            else
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        binding.btnBottomSheetModal.setOnClickListener {
            CustomBottomSheetDialogFragment().apply {
                show(supportFragmentManager, CustomBottomSheetDialogFragment.TAG)
            }
        }

    }
}