package com.yaritzama.spacex.presentation.adapters

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yaritzama.spacex.databinding.ViewItemListBinding
import com.yaritzama.spacex.domain.models.SpaceModel

class LaunchListAdapter(
    private val context: Context?,
    private val onSpaceSelected: (SpaceModel, lastItemPosition: Int?,
                                  currentItemPosition: Int?) -> Unit) :
    ListAdapter<SpaceModel, LaunchListAdapter.SpaceListViewHolder>(DiffUtilCallback())
{
    private var lastItemCheckedId: Int = -1

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
               val isLandscape = context?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE
               if(item.isSelected && isLandscape){
                   myCardView.setCardBackgroundColor(Color.GRAY)
               }
               else{
                   myCardView.setCardBackgroundColor(Color.WHITE)
               }
               val url= item.linkImage
               txtMissionName.text = item.missionName
               txtFlightNumber.text = item.flightNumber.toString()
               Picasso.get().load(url?:"https://img.icons8.com/emoji/344/rocket-emji.png")
                   .into(imgLaunch)
               btnDetails.setOnClickListener{
                   if(isLandscape)
                   {
                       if(lastItemCheckedId != -1){
                           currentList[lastItemCheckedId].isSelected = false
                       }
                       currentList[adapterPosition].isSelected = true
                       val lastSelectedItem = lastItemCheckedId
                       lastItemCheckedId = adapterPosition
                       onSpaceSelected(item, lastSelectedItem, lastItemCheckedId)
                   }
                   else{
                       onSpaceSelected(item, null, null)
                   }

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