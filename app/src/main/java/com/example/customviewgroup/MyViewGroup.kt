package com.example.customviewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

class MyViewGroup:ViewGroup {
    private val space = 30 //间距

    //xml
    constructor(context: Context,attrs:AttributeSet?):super(context,attrs){

    }

    //测量子View 确定自己的最终尺寸
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //先预测量一下 自己的限制
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val child = getChildAt(0)

        //获取预测量之后自己的宽和高
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        val parentHeight = MeasureSpec.getSize(heightMeasureSpec)

        //计算子控件的宽和高
        //MeasureSpec  mode size
        val childWidth = parentWidth - 2*space
        val childHeight = parentHeight - 2*space

        //获取子控件测量室需要的spec
        val widthSpec = MeasureSpec.makeMeasureSpec(childWidth,MeasureSpec.EXACTLY)
        val heightSpec = MeasureSpec.makeMeasureSpec(childHeight,MeasureSpec.EXACTLY)

        child.measure(widthSpec,heightSpec)
    }

    //按照规则来对自己的子控件进行布局
    /**
     getChildAt(0)
     getChildCount
     */
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val child = getChildAt(0)
        child.layout(space,space,
            child.measuredWidth+space,
            child.measuredHeight+space
        )
    }

}