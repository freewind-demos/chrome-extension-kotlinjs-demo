package example

import chrome.tabs.QueryInfo
import kotlinjs.common.JsObj
import kotlin.browser.window

fun main(args: Array<String>) {
    getCurrentTabUrl { url ->
        window.alert("current url is: $url")
    }
}

private fun getCurrentTabUrl(callback: (String) -> Unit) {
    val queryInfo = JsObj<QueryInfo>().apply {
        active = true
        currentWindow = true
    }
    chrome.tabs.query(queryInfo) { tabs ->
        tabs.firstOrNull()?.url?.run(callback)
    }
}

