/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val dataset = DataSource.dogs
    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val imageView = view?.findViewById<ImageView>(R.id.item_image)
        val nameTextView = view?.findViewById<TextView>(R.id.item_dog_name)
        val ageTextView = view?.findViewById<TextView>(R.id.item_dog_age)
        val hobbiesTextView = view?.findViewById<TextView>(R.id.item_dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.

        if (layout == Layout.GRID) {
            return DogCardViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_list_item, parent, false))
        }

        if (layout == Layout.HORIZONTAL || layout == Layout.VERTICAL) {
            return DogCardViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_horizontal_list_item, parent, false))
        }

        // TODO Inflate the layout

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(null)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val resources = context?.resources
        // TODO: Get the data at the current position
        val dog = dataset[position]
        // TODO: Set the image resource for the current dog
        holder.imageView?.setImageResource(dog.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.nameTextView?.text = dog.name
        // TODO: Set the text for the current dog's age
        holder.ageTextView?.text = resources?.getString(R.string.dog_age, dog.age)
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.hobbiesTextView?.text = resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
