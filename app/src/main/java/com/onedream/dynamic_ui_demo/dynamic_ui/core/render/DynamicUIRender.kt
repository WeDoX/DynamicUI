package com.onedream.dynamic_ui_demo.dynamic_ui.core.render

import androidx.compose.runtime.Composable
import com.onedream.dynamic_ui_demo.dynamic_ui.core.data.DynamicUIComponentData

// 组件工厂接口
interface DynamicUIRender {
    // 方法1：创建单个组件（推荐）
    fun createComponent(data: DynamicUIComponentData): @Composable () -> Unit

    // 方法2：创建组件列表（如果需要批量处理）
    fun createComponents(dataList: List<DynamicUIComponentData>): @Composable () -> Unit {
        return {
            dataList.forEach { data ->
                val component = createComponent(data)
                component()
            }
        }
    }
}







