package com.saize.genshinassistant.util

import androidx.fragment.app.Fragment
import com.saize.genshinassistant.MainActivity

fun interface ViewEvent : (Fragment) -> Unit

val Fragment.mainActivity get() = requireActivity() as MainActivity