package com.onedream.dynamic_ui_demo

import org.json.JSONArray

// 定义 UI 状态密封类
sealed class MainViewState {
    data object Loading : MainViewState()
    data class Success(val jsonArray: JSONArray) : MainViewState()
    data class Error(val message: String) : MainViewState()
}