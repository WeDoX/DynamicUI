package com.onedream.dynamic_ui_demo.dynamic_ui.core.parser

import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentType
import com.onedream.dynamic_ui_demo.dynamic_ui.component.block.BlockDataParser
import com.onedream.dynamic_ui_demo.dynamic_ui.component.title_content.TitleContentDataParser
import com.onedream.dynamic_ui_demo.dynamic_ui.component.unknow.UnknownComponentData
import com.onedream.dynamic_ui_demo.dynamic_ui.component.unknow.UnknownComponentDataParser
import org.json.JSONObject

object DynamicUIComponentDataParserFactory {

    // 使用 HashMap 存储解析器，key 为 ComponentType
    private val parsers = HashMap<DynamicUIComponentType, DynamicUIComponentDataParser>()

    init {
        // 预注册一些默认的解析器
        registerParser(DynamicUIComponentType.BLOCK, BlockDataParser())
        registerParser(DynamicUIComponentType.TITLE_CONTENT, TitleContentDataParser())
        registerParser(DynamicUIComponentType.UNKNOWN, UnknownComponentDataParser())
    }

    // 注册解析器
    fun registerParser(type: DynamicUIComponentType, parser: DynamicUIComponentDataParser) {
        parsers[type] = parser
    }

    // 根据 JSON 自动匹配解析器并解析
    fun fromJson(json: JSONObject): DynamicUIComponentData {
        val type = try {
            DynamicUIComponentType.valueOf(json.getString("type").uppercase())
        } catch (e: Exception) {
            DynamicUIComponentType.UNKNOWN
        }
        val parser = parsers[type] ?: return UnknownComponentData("该type=[$type]没有注册")
        return parser.parse(json)
    }
}