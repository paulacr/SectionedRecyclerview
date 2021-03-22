package com.paulacr.sectionedrecyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

class HeaderView@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.HeaderView)
            val title = typedArray.getString(R.styleable.HeaderView_title)
            val textColor = typedArray.getResourceId(R.styleable.HeaderView_textColor, -1)
            val backgroundColor = typedArray.getResourceId(R.styleable.HeaderView_backgroundColor, -1)

            setHeaderAttributes(Header(title.orEmpty(), textColor = ContextCompat.getColor(context, textColor),
                backgroundColor = ContextCompat.getColor(context, backgroundColor)))

            typedArray.recycle()
        }
    }

    private fun setHeaderAttributes(header: Header) {
        text = header.name
        setBackgroundColor(header.backgroundColor)
        setTextColor(header.textColor)
    }
}