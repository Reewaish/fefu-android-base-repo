package ru.fefu.hw

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DateActivityHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val ivDate: TextView = itemView.findViewById(R.id.date_activity_card_date)

    fun bind(item: CardAbstract) {
        item as DateActivityData
        ivDate.text = item.date
    }
}