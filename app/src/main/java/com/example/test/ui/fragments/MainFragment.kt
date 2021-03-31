package com.example.test.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.ui.adapters.UserAdapter
import com.example.test.utils.hide
import com.example.test.utils.show
import com.example.test.ui.viewmodel.ViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    var userListAdapter: UserAdapter? = null

    private val viewModel: ViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        init()
        getUserList()
    }

    private fun getUserList() {
        progressBar.show()
        rvUser.hide()
        viewModel.getUserMaster(
            success = {
              //  this.activity?.showToast("downloaded")
                setComplaintList()
            }, publishError = { error ->
                progressBar.hide()
                errMsg.show()
                errMsg.text = error
                rvUser.hide()

            })


    }

    private fun setComplaintList() {

        progressBar.hide()
        if (viewModel.userList.size > 0) {
            rvUser.show()
            errMsg.hide()
            userListAdapter?.addAll(viewModel.userList)


        } else {
            errMsg.show()
            rvUser.hide()

        }


    }

    private fun init() {
        userListAdapter = UserAdapter()
        val linearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        rvUser.apply {
            layoutManager = linearLayoutManager
            adapter = userListAdapter

        }

    }


}