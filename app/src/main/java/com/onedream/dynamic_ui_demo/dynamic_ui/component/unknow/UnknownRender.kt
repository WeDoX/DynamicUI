package com.onedream.dynamic_ui_demo.dynamic_ui.component.unknow

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import com.onedream.dynamic_ui_demo.dynamic_ui.core.render.DynamicUIRender

class UnknownRender : DynamicUIRender {
    override fun createComponent(data: DynamicUIComponentData): @Composable () -> Unit {
        return { UnknownComponent(data) }
    }
}
@Composable
fun UnknownComponent(data: DynamicUIComponentData? = null) {
    Text(
        text = "Unknown component: ${data?.type?.name ?: "null"}",
        color = Color.Red,
        modifier = Modifier.padding(16.dp)
    )
}