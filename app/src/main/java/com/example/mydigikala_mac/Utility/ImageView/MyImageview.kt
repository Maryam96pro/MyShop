package com.example.mydigikala_mac.Utility.ImageView

import android.content.Context
import android.util.AttributeSet
import com.facebook.drawee.generic.GenericDraweeHierarchy
import com.facebook.drawee.view.SimpleDraweeView

class MyImageview:SimpleDraweeView {
    constructor(context: Context,hierarchy: GenericDraweeHierarchy):super(context,hierarchy)
    constructor(context: Context):super(context)
    constructor(context: Context,attrs: AttributeSet):super(context,attrs)
    constructor(context: Context,attrs: AttributeSet,defStyle:Int):super(context,attrs,defStyle)
    constructor(context: Context,attrs: AttributeSet,defStyleAttr:Int,defStyleRes: Int):super(context,attrs,defStyleAttr,defStyleRes)
}