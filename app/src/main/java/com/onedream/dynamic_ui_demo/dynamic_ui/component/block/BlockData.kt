package com.onedream.dynamic_ui_demo.dynamic_ui.component.block

import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentType
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData

data class BlockData(
    val children: List<DynamicUIComponentData>
) : DynamicUIComponentData(DynamicUIComponentType.BLOCK)