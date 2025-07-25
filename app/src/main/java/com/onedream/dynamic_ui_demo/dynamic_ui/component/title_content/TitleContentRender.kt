package com.onedream.dynamic_ui_demo.dynamic_ui.component.title_content

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import com.onedream.dynamic_ui_demo.dynamic_ui.core.render.DynamicUIRender

class  TitleContentRender : DynamicUIRender {
    override fun createComponent(data: DynamicUIComponentData): @Composable () -> Unit {
        return  { TitleContentComponent(data as TitleContentData) }
    }
}

@Composable
private fun TitleContentComponent(data: TitleContentData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = data.title,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "：",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = data.content,
            style = MaterialTheme.typography.bodyMedium.copy(Color(0xFF666666))
        )
    }
}