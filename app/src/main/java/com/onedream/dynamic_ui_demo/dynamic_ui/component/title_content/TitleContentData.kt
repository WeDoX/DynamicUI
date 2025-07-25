package com.onedream.dynamic_ui_demo.dynamic_ui.component.title_content

import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentType
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData

data class TitleContentData(
    val title: String,
    val content: String
) : DynamicUIComponentData(DynamicUIComponentType.TITLE_CONTENT)