package com.onedream.dynamic_ui_demo.dynamic_ui.component.unknow

import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentType
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData

data class UnknownComponentData(val unknownReason: String) : DynamicUIComponentData(
    DynamicUIComponentType.UNKNOWN)