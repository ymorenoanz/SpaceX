package com.yaritzama.spacex.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yaritzama.spacex.databinding.ViewItemListBinding
import com.yaritzama.spacex.domain.models.SpaceModel

class LaunchListAdapter(
    private val onSpaceSelected: (SpaceModel) -> Unit) :
    ListAdapter<SpaceModel, LaunchListAdapter.SpaceListViewHolder>(DiffUtilCallback())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceListViewHolder {
        return SpaceListViewHolder(ViewItemListBinding.inflate(LayoutInflater.from(parent.context),
       parent, false ))
    }

    override fun onBindViewHolder(holder: SpaceListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SpaceListViewHolder(
        private val itemListBinding: ViewItemListBinding
        ):RecyclerView.ViewHolder(itemListBinding.root)
    {
        fun bind(item: SpaceModel)
        {
           with(itemListBinding){
               val url: String = item.linkImage.toString()
               txtMissionName.text = item.missionName
               txtFlightNumber.text = item.flightNumber.toString()
               Picasso.get().load(url).into(imgLaunch)
               if(url == "null")
               {
                   Picasso.get().load("https://img.icons8.com/emoji/344/rocket-emji.png").into(imgLaunch)
               }
               btnDetails.setOnClickListener{
                   onSpaceSelected(item)
               }
           }
        }

    }

    private class DiffUtilCallback: DiffUtil.ItemCallback<SpaceModel>(){
        override fun areItemsTheSame(oldItem: SpaceModel, newItem: SpaceModel): Boolean {
            return oldItem.missionId == newItem.missionId
        }

        override fun areContentsTheSame(oldItem: SpaceModel, newItem: SpaceModel): Boolean {
            return oldItem == newItem
        }

    }

}