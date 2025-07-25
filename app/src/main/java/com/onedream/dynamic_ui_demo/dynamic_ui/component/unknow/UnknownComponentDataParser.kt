package com.onedream.dynamic_ui_demo.dynamic_ui.component.unknow

import com.onedream.dynamic_ui_demo.dynamic_ui.core.parser.DynamicUIComponentDataParser
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import org.json.JSONObject

class UnknownComponentDataParser : DynamicUIComponentDataParser {
    override fun parse(json: JSONObject): DynamicUIComponentData {
        return UnknownComponentData(json.toString())
    }
}