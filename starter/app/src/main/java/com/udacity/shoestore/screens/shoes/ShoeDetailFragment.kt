package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.shoeDetailCancelBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
        binding.shoeDetailSaveBtn.setOnClickListener { view: View ->
            Toast.makeText(this.context, "TODO: Save Shoe Detail", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}