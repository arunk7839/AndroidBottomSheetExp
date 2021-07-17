package com.c1ctech.androidbottomsheetexp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_sheet_dialog.*

class BottomSheetFragment : BottomSheetDialogFragment() {

    companion object {

        const val TAG = "BottomSheetFragment"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bottom_sheet_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rl_edit.setOnClickListener {
            //handle click event
            Toast.makeText(context, "Perform edit operation", Toast.LENGTH_SHORT).show()
        }
        rl_delete.setOnClickListener {
            //handle click event
            Toast.makeText(context, "Perform delete operation", Toast.LENGTH_SHORT).show()
        }
        rl_add.setOnClickListener {
            //handle click event
            Toast.makeText(context, "Perform add operation", Toast.LENGTH_SHORT).show()
        }

    }

}