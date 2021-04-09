package com.oratakashi.rvdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.oratakashi.rvdialog.adapter.SampleAdapter
import com.oratakashi.rvdialog.core.RecyclerViewDialog
import com.oratakashi.rvdialog.databinding.ActivityMainBinding
import com.oratakashi.rvdialog.model.SampleModel
import com.oratakashi.viewbinding.core.tools.onClick
import com.oratakashi.viewbinding.core.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    private val adapter: SampleAdapter by lazy {
        SampleAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            root.onClick {
                RecyclerViewDialog(this@MainActivity)
                        .setNegativeButton("Close")
                        .setTransparancy(0.5f)
                        .show {
                            it.adapter = adapter
                            it.layoutManager = LinearLayoutManager(this@MainActivity)
                        }
            }
            val data: MutableList<SampleModel> = ArrayList()
            repeat(20) {
                data.add(SampleModel("Sample : $it"))
            }
            adapter.submitItem(data)
            RecyclerViewDialog(this@MainActivity)
                    .setPositiveButton("OK")
                    .setNegativeButton("Cancel")
                    .setTitle("Help")
                    .show {
                        it.adapter = adapter
                        it.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
        }
    }
}