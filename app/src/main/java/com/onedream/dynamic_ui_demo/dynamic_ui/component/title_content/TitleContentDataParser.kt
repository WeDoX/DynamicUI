package com.onedream.dynamic_ui_demo.dynamic_ui.component.title_content

import com.onedream.dynamic_ui_demo.dynamic_ui.core.parser.DynamicUIComponentDataParser
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import org.json.JSONObject


class TitleContentDataParser : DynamicUIComponentDataParser {
    override fun parse(json: JSONObject): DynamicUIComponentData {
        val data = json.getJSONObject("data")
        val title = data.getString("title")
        val content = data.getString("content")
        return TitleContentData(title, content)
    }
}