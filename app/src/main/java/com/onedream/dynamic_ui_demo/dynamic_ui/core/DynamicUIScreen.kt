package com.onedream.dynamic_ui_demo.dynamic_ui.core

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.onedream.dynamic_ui_demo.dynamic_ui.core.parser.DynamicUIComponentDataParserFactory
import com.onedream.dynamic_ui_demo.dynamic_ui.core.render.DynamicUIRenderFactory
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun DynamicUIScreen(jsonObject: JSONObject) {
    val context = LocalContext.current

    val rootComponentData = remember {
        try {
            DynamicUIComponentDataParserFactory.fromJson(jsonObject)
        } catch (e: Exception) {
            Log.e("DynamicUIScreen", "Failed to parse UI", e)
            null
        }
    }

    rootComponentData?.let { componentData ->
        val ui = DynamicUIRenderFactory.createComponent(componentData)
        ui()
    } ?: run {
        Text("Failed to load UI", color = Color.Red)
    }
}


@Composable
fun DynamicUIScreen(jsonArray: JSONArray) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        (0 until jsonArray.length()).map { index ->
            DynamicUIScreen(jsonArray.getJSONObject(index))
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}