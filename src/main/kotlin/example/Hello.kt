package example

import chrome.tabs.QueryInfo
import kotlinjs.common.jsonAs
import kotlin.browser.window

fun main(args: Array<String>) {
    getCurrentTabUrl { url ->
        window.alert("current url is: $url")
    }
}

private fun getCurrentTabUrl(callback: (String) -> Unit) {
    chrome.tabs.query(jsonAs<QueryInfo>().apply {
        active = true
        currentWindow = true
    }) { tabs ->
        tabs.firstOrNull()?.url?.run(callback)
    }
}

