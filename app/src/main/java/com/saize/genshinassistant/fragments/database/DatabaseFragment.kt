package com.saize.genshinassistant.fragments.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.saize.genshinassistant.ButtonParams
import com.saize.genshinassistant.R
import com.saize.genshinassistant.ToolbarConfig
import com.saize.genshinassistant.base.BaseFragment
import com.saize.genshinassistant.databinding.FragmentDatabaseBinding
import com.saize.genshinassistant.util.mainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DatabaseFragment : BaseFragment<FragmentDatabaseBinding>() {

    override val viewModel by viewModels<DatabaseViewModel>()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDatabaseBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.updateToolbar(
            ToolbarConfig(
                "Database",
                backButtonEnabled = true,
                additionalButtonParams = ButtonParams(
                    R.drawable.ic_toolbar_settings
                ) {
                    Toast.makeText(this, "ЫЫЫЫO", Toast.LENGTH_SHORT).show()
                }
            )
        )
    }
}