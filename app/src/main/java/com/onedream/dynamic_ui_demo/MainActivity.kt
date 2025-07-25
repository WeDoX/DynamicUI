package com.onedream.dynamic_ui_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onedream.dynamic_ui_demo.common_composable.ErrorScreen
import com.onedream.dynamic_ui_demo.common_composable.LoadingScreen
import com.onedream.dynamic_ui_demo.ui.theme.MyApplicationTheme
import com.onedream.dynamic_ui_demo.dynamic_ui.core.DynamicUIScreen
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    // 使用 State 封装 API 数据和加载状态
    private val mViewState = mutableStateOf<MainViewState>(MainViewState.Loading)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(start = 15.dp, end = 15.dp)
                    ) {
                        RenderPage()
                    }
                }
            }
        }
        //
        fetchApiData()
    }

    @Composable
    private fun RenderPage() {
        when (val viewState = mViewState.value) {
            is MainViewState.Loading -> LoadingScreen()
            is MainViewState.Success -> DynamicUIScreen(viewState.jsonArray)
            is MainViewState.Error -> ErrorScreen(viewState.message) { fetchApiData() }
        }
    }

    private fun fetchApiData() {
        mViewState.value = MainViewState.Loading

        // 模拟 API 调用（实际项目中替换为真实的网络请求）
        window.decorView.postDelayed({
            try {
                val json = """
                    {
                    	"data": [{
                    			"type": "block",
                    			"data": {
                    				"children": [{
                    						"type": "title_content",
                    						"data": {
                    							"title": "项目编号：",
                    							"content": "B20240306JU3S"
                    						}
                    					},
                    					{
                    						"type": "title_content",
                    						"data": {
                    							"title": "项目名称",
                    							"content": "升降工具桌"
                    						}
                    					},
                    					{
                    						"type": "title_content",
                    						"data": {
                    							"title": "发起人",
                    							"content": "你真帅"
                    						}
                    					}
                    				]
                    			}
                    		},
                    		{
                    			"type": "block",
                    			"data": {
                    				"children": [{
                    						"type": "title_content",
                    						"data": {
                    							"title": "姓名",
                    							"content": "jdallen_vam_wedox"
                    						}
                    					},
                    					{
                    						"type": "title_content",
                    						"data": {
                    							"title": "年龄",
                    							"content": "30"
                    						}
                    					},
                    					{
                    						"type": "title_content",
                    						"data": {
                    							"title": "联系电话",
                    							"content": "188****1853"
                    						}
                    					},
                                        {
                    						"type": "title_content",
                    						"data": {
                    							"title": "地址",
                    							"content": "广东省汕尾市陆丰市"
                    						}
                    					}
                    				]
                    			}
                    		}
                    	]
                    }
                """.trimIndent()

                // 验证 JSON 是否有效（可选）
                if (json.isEmpty()) {
                    throw IllegalArgumentException("Empty JSON response")
                }
                val jsonObject = JSONObject(json)
                val jsonArray = jsonObject.getJSONArray("data")
                mViewState.value = MainViewState.Success(jsonArray)
            } catch (e: Exception) {
                mViewState.value = MainViewState.Error("加载数据失败: ${e.message}")
                e.printStackTrace()
            }
        }, 1000) // 1秒延迟（测试用）
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}