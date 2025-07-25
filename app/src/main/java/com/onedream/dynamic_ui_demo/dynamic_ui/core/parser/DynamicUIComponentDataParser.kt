package com.onedream.dynamic_ui_demo.dynamic_ui.core.parser

import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import org.json.JSONObject

interface DynamicUIComponentDataParser {
    fun parse(json: JSONObject): DynamicUIComponentData
}