package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentShoeListItemBinding
import com.udacity.shoestore.models.Shoe
import org.w3c.dom.Text
import timber.log.Timber

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

        val shoes: List<Shoe>? = viewModel.shoeList.value

        if (shoes?.isNotEmpty() == true) {
            for (shoe in shoes) {
                Timber.w(shoe.name)
                Timber.w(shoe.size.toString())
                Timber.w(shoe.company)
                Timber.w(shoe.description)
                val shoeListItem = FragmentShoeListItemBinding.inflate(LayoutInflater.from(requireContext()))
                shoeListItem.shoe = shoe
                binding.shoeListScrollViewLinearLayout.addView(shoeListItem.root)
            }
        }

        return binding.root
    }
}