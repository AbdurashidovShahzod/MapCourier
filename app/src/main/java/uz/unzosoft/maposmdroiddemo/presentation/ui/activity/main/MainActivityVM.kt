package uz.unzosoft.maposmdroiddemo.presentation.ui.activity.main

import android.annotation.SuppressLint
import android.content.Context
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.unzosoft.maposmdroiddemo.presentation.ui.base.BaseViewModel
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 14/12/21 15:09.
 * company QQBank
 * shahzod9933@gmail.com
 */

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class MainActivityVM @Inject constructor(
    @ApplicationContext private val context: Context
) : BaseViewModel() {
    init {

    }
}