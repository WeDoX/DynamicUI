package com.onedream.dynamic_ui_demo.dynamic_ui.component.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import com.onedream.dynamic_ui_demo.dynamic_ui.core.render.DynamicUIRender
import com.onedream.dynamic_ui_demo.dynamic_ui.core.render.DynamicUIRenderFactory


class  BlockRender : DynamicUIRender {
    override fun createComponent(data: DynamicUIComponentData): @Composable () -> Unit {
        return { BlockComponent(data as BlockData) }
    }
}

// Block 组件
@Composable
fun BlockComponent(data: BlockData) {
    Column(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        data.children.forEach { childData ->
            val childComponent = DynamicUIRenderFactory.createComponent(childData)
            childComponent()
        }
    }
}