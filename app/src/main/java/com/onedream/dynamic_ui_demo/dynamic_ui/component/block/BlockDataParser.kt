package com.onedream.dynamic_ui_demo.dynamic_ui.component.block

import com.onedream.dynamic_ui_demo.dynamic_ui.core.parser.DynamicUIComponentDataParser
import com.onedream.dynamic_ui_demo.dynamic_ui.core.parser.DynamicUIComponentDataParserFactory
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import org.json.JSONArray
import org.json.JSONObject

class BlockDataParser : DynamicUIComponentDataParser {
    override fun parse(json: JSONObject): DynamicUIComponentData {
        val data = json.getJSONObject("data")
        val childrenJson = data.getJSONArray("children") ?: JSONArray()
        val children = mutableListOf<DynamicUIComponentData>()

        for (i in 0 until childrenJson.length()) {
            children.add(DynamicUIComponentDataParserFactory.fromJson(childrenJson.getJSONObject(i)))
        }

        return BlockData(children)
    }
}