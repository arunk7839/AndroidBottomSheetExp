package com.c1ctech.androidbottomsheetexp

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.*


class MainActivity : AppCompatActivity() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // handle onSlide
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(
                        this@MainActivity,
                        "STATE_COLLAPSED",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(
                        this@MainActivity,
                        "STATE_EXPANDED",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(
                        this@MainActivity,
                        "STATE_DRAGGING",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(
                        this@MainActivity,
                        "STATE_SETTLING",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(
                        this@MainActivity,
                        "STATE_HIDDEN",
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> Toast.makeText(this@MainActivity, "OTHER_STATE", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })

        btnBottomSheet.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

            }
        }

        btnBottomSheetDialog.setOnClickListener {
            showBottomSheetDialog()
        }

        btnBottomSheetDialogFragment.setOnClickListener {
            showBottomSheetDialogFragment()
        }

    }

    private fun showBottomSheetDialogFragment() {
        BottomSheetFragment().show(getSupportFragmentManager(), BottomSheetFragment.TAG);
    }

    private fun showBottomSheetDialog() {

        val dialog = BottomSheetDialog(this)

        dialog.setContentView(R.layout.layout_bottom_sheet_dialog)

        val RLEdit = dialog.findViewById<RelativeLayout>(R.id.rl_edit)
        val RLDelete = dialog.findViewById<RelativeLayout>(R.id.rl_delete)
        val RLAdd = dialog.findViewById<RelativeLayout>(R.id.rl_add)

        RLEdit?.setOnClickListener {  //handle click event
            Toast.makeText(this, "Perform edit operation", Toast.LENGTH_SHORT).show()
        }
        RLDelete?.setOnClickListener {  //handle click event
            Toast.makeText(this, "Perform delete operation", Toast.LENGTH_SHORT).show()
        }
        RLAdd?.setOnClickListener {  //handle click event
            Toast.makeText(this, "Perform add operation", Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }


}

