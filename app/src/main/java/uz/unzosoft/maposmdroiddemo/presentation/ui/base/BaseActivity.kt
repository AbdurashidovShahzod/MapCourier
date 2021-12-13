package uz.unzosoft.maposmdroiddemo.presentation.ui.base

import android.app.Dialog
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewbinding.ViewBinding


/**
 * Created by Abdurashidov Shahzod on 10/09/21 00:12.
 * company QQBank
 * shahzod9933@gmail.com
 */

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    private var _binding: ViewBinding? = null
    lateinit var binding: T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingActivity()
        binding = _binding as T
        setContentView(binding.root)
        onCreated(savedInstanceState)
    }

    abstract fun bindingActivity(): T

    abstract fun onCreated(savedInstanceState: Bundle?)


    fun showYesNoDialog(
        title: String,
        leftButton: String,
        rightButton: String,
        isLeftClicked: ((Boolean) -> Unit)
    ) {
        val dialog = AlertDialog.Builder(this)
        dialog.setMessage(title)
        dialog.setNegativeButton(leftButton) { d, _ ->
            d.dismiss()
            isLeftClicked(true)
        }
        dialog.setPositiveButton(rightButton) { d, _ ->
            d.dismiss()
            isLeftClicked(false)

        }
        dialog.show()
    }

}