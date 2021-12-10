package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
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
    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        binding.addShoeFab.setOnClickListener { view: View->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        viewModel.resetNewShoeWasAdded()

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoeList ->
            if (newShoeList?.isNotEmpty() == true) {
                for (shoe in newShoeList) {
                    val shoeListItem = FragmentShoeListItemBinding.inflate(LayoutInflater.from(requireContext()))
                    shoeListItem.shoe = shoe
                    binding.shoeListScrollViewLinearLayout.addView(shoeListItem.root)
                }
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun onLogout() {
        binding.root.findNavController().navigate(R.id.loginFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logoutMenuButton -> onLogout()
        }
        return super.onOptionsItemSelected(item)
    }
}