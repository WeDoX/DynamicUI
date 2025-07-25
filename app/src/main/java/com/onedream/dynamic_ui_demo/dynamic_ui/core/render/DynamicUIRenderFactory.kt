package com.onedream.dynamic_ui_demo.dynamic_ui.core.render

import androidx.compose.runtime.Composable
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentType
import com.onedream.dynamic_ui_demo.dynamic_ui.component.block.BlockRender
import com.onedream.dynamic_ui_demo.dynamic_ui.component.title_content.TitleContentRender
import com.onedream.dynamic_ui_demo.dynamic_ui.component.unknow.UnknownRender

object DynamicUIRenderFactory{

    // 使用 HashMap 存储渲染器，key 为 ComponentType
    private val renders = HashMap<DynamicUIComponentType, DynamicUIRender>()

    init {
        // 预注册一些默认的解析器
        registerRender(DynamicUIComponentType.BLOCK, BlockRender())
        registerRender(DynamicUIComponentType.TITLE_CONTENT, TitleContentRender())
        registerRender(DynamicUIComponentType.UNKNOWN, UnknownRender())
    }

    // 注册渲染器
    fun registerRender(type: DynamicUIComponentType, render: DynamicUIRender) {
        renders[type] = render
    }

    // 根据 JSON 自动匹配解析器并解析
    fun createComponent(data: DynamicUIComponentData): @Composable () -> Unit {
        val render = renders[data.type] ?: return UnknownRender().createComponent(data)
        return render.createComponent(data)
    }
}