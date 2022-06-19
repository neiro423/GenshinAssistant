package com.saize.genshinassistant

import android.app.Activity
import androidx.annotation.IdRes

class ToolbarConfig(
    val title: String,
    val backButtonEnabled: Boolean = false,
    val additionalButtonParams: ButtonParams? = null
)

class ButtonParams(
    @IdRes val iconId: Int,
    val onClickAction: Activity.() -> Unit
)