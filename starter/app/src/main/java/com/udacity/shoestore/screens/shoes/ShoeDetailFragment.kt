package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment(){
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.shoeDetailCancelBtn.setOnClickListener { view: View ->
            goToShoeList(view)
        }

        binding.shoeDetailSaveBtn.setOnClickListener { view: View ->
            val newShoe = Shoe(
                name = binding.editTextShoeName.text.toString(),
                company = binding.editTextShoeCompany.text.toString(),
                size = binding.editTextShoeSize.text.toString().toDouble(),
                description = binding.editTextShoeDescription.text.toString()
            )
            viewModel.addShoe(newShoe)
            goToShoeList(view)
        }

        return binding.root
    }

    private fun goToShoeList(view: View) {
        view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }
}