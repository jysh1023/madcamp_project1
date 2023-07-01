package com.example.madcamp_project1.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.madcamp_project1.databinding.ItemContactBinding


class RecyclerViewAdapter(private val contact:Contact) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(), Filterable {

    var contactFiltered: ArrayList<ContactData> = ArrayList()

    class ViewHolder(private val binding: ItemContactBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: ContactData){
            with(binding) {
                userName.text = data.name
                userContact.text = data.contact
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(contact[position])
    }

    override fun getItemCount(): Int {
        return contact.size
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charString = p0.toString()
                if (charString.isEmpty()){
                    contactFiltered = contact
                } else{
                    if (contact != null) {
                        for (user in contact) {

                            if (user.name.lowercase().contains(charString.lowercase())) {
                                contactFiltered.add(user)
                            }
                        }
                    }
                }

                val filterResults = FilterResults()
                filterResults.values = contactFiltered

                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                if (p1 != null) {
                    contactFiltered = p1.values as ArrayList<ContactData>
                    notifyDataSetChanged()
                }
            }

        }
    }
}