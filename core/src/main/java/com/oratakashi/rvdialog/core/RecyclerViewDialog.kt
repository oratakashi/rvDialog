package com.oratakashi.rvdialog.core

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oratakashi.rvdialog.core.databinding.LayoutDialogBinding
import com.oratakashi.viewbinding.core.tools.gone
import com.oratakashi.viewbinding.core.tools.onClick
import com.oratakashi.viewbinding.core.tools.visible
import com.oratakashi.viewbinding.core.viewBinding

class RecyclerViewDialog(context : Context) : Dialog(context, R.style.PauseDialog) {

    private val binding : LayoutDialogBinding by viewBinding()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    fun setPositiveButton(text: String, event : () -> Unit = {}) : RecyclerViewDialog{
        with(binding){
            if(btnNegative.isVisible && !verticalDivider.isVisible){
                verticalDivider.visible()
                btnPositive.also {
                    it.text = text
                    it.visible()
                    it.onClick {
                        event.invoke()
                        dismiss()
                    }
                }
            }else{
                verticalDivider.gone()
                btnPositive.also {
                    it.text = text
                    it.visible()
                    it.onClick {
                        event.invoke()
                        dismiss()
                    }
                }
            }
        }
        return this
    }

    fun setNegativeButton(text: String, event : () -> Unit = {}) : RecyclerViewDialog{
        with(binding){
            if(btnPositive.isVisible || !verticalDivider.isVisible){
                verticalDivider.visible()
                btnNegative.also {
                    it.text = text
                    it.visible()
                    it.onClick {
                        event.invoke()
                        dismiss()
                    }
                }
            }else{
                verticalDivider.gone()
                btnNegative.also {
                    it.text = text
                    it.visible()
                    it.onClick {
                        event.invoke()
                        dismiss()
                    }
                }
            }
        }
        return this
    }

    fun setTitle(text : String) : RecyclerViewDialog {
        binding.tvTitle.also {
            it.text = text
            it.visible()
        }
        return this
    }

    fun setTransparancy(transparent : Float) : RecyclerViewDialog{
        if(transparent in 0.0..1.0){
            binding.root.alpha = transparent
        }else{
            throw TypeCastException()
        }
        return this
    }

    fun show(adapter : (RecyclerView) -> Unit) {
        adapter.invoke(binding.rvDialog)
        super.show()
    }
}