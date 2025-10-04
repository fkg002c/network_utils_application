package com.fkg002c.networkutils.app.ui.cell

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fkg002c.networkutils.app.databinding.FragmentCellBinding

class CellFragment : Fragment() {

    private var _binding: FragmentCellBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cellViewModel =
            ViewModelProvider(this).get(CellViewModel::class.java)

        _binding = FragmentCellBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCell
        cellViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}