package com.tibame.tip101.group_02.healthhelp_v2.components.attr.button.squarebutton

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tibame.tip101.group_02.healthhelp_v2.components.attr.button.basebutton.BaseButtonAttr

data class SquareButtonAttr(
    override val onClick : ()->Unit,
    override val modifier: Modifier = Modifier,
    override val contentPadding: PaddingValues = PaddingValues(0.dp),
    override val colors: ButtonColors = ButtonColors(Color.Blue,Color.White,Color.White,Color.White),
): BaseButtonAttr(
    onClick = onClick,
    shape = RoundedCornerShape(ZeroCornerSize),
    modifier = modifier,
    contentPadding = contentPadding,
    colors = colors,
)