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
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment(){
    private lateinit var shoeListViewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel
        binding.shoeObservable = ShoeObservable()
        binding.lifecycleOwner = this

        binding.shoeDetailCancelBtn.setOnClickListener { view: View ->
            goToShoeList(view)
        }

        shoeListViewModel.newShoeWasAdded.observe(viewLifecycleOwner, Observer { wasAdded ->
            if (wasAdded) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        })

        return binding.root
    }

    private fun goToShoeList(view: View) {
        view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }
}