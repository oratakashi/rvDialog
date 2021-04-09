package com.oratakashi.rvdialog.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oratakashi.rvdialog.databinding.SampleItemBinding
import com.oratakashi.rvdialog.model.SampleModel
import com.oratakashi.viewbinding.core.ViewHolder
import com.oratakashi.viewbinding.core.viewBinding

class SampleAdapter : RecyclerView.Adapter<ViewHolder<SampleItemBinding>>() {

    private val data: MutableList<SampleModel> = ArrayList()

    fun submitItem(data: List<SampleModel>) {
        this.data.clear()
        this.data.addAll(data)
        Log.e("debug", "debug: ${this.data}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder<SampleItemBinding> = viewBinding(parent)

    override fun onBindViewHolder(holder: ViewHolder<SampleItemBinding>, position: Int) {
        with(holder.binding) {
            text.text = data[position].title
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}