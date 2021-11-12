package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentShoeListItemBinding

class ShoeListFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        binding.addShoeFab.setOnClickListener { view: View->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoeList ->
            if (newShoeList?.isNotEmpty() == true) {
                for (shoe in newShoeList) {
                    val shoeListItem = FragmentShoeListItemBinding.inflate(LayoutInflater.from(requireContext()))
                    shoeListItem.shoe = shoe
                    binding.shoeListScrollViewLinearLayout.addView(shoeListItem.root)
                }
            }
        })

        return binding.root
    }
}