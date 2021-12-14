package uz.unzosoft.maposmdroiddemo.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
/**
 * Created by Abdurashidov Shahzod on 14/09/21 14:21.
 * company QQBank
 * shahzod9933@gmail.com
 */
abstract class BaseScreen<T : ViewBinding>() : Fragment() {

    protected val TAG: String = "TAG"


    protected var _binding: T? = null
    protected lateinit var binding: T

    companion object {
        val DATA_ID = "_ID"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingScreen(inflater, container)
        binding = _binding as T
        return binding.root
    }

    abstract fun bindingScreen(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?
    ): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreate(view, savedInstanceState)
    }

    abstract fun onViewCreate(view: View, savedInstanceState: Bundle?)


    inline fun <T : ViewBinding> Fragment.viewBinding(
        crossinline bindingInflater: (LayoutInflater) -> T
    ) = lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    fun getBaseString(resId: Int): String {

        return resources.getString(resId)

    }

    fun getBaseColor(resId: Int): Int {

        return resources.getColor(resId)

    }

}
