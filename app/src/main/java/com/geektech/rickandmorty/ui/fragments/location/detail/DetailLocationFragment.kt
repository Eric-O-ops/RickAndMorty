package com.geektech.rickandmorty.ui.fragments.location.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentDetailLocationBinding

class DetailLocationFragment :
    BaseFragment<FragmentDetailLocationBinding, DetailLocationViewModel>(R.layout.fragment_detail_location) {

    override val binding by viewBinding(FragmentDetailLocationBinding::bind)
    override val viewModel: DetailLocationViewModel by viewModels()
    private val args by navArgs<DetailLocationFragmentArgs>()

    override fun setupView() = with(binding) {
        viewModel.fetchDetailLocation(args.id).observe(viewLifecycleOwner) {
            name.text = it.name
            dimension.text = it.dimension
            type.text = it.type
            created.text = it.created
        }
    }
}