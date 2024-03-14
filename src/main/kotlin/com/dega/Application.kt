package com.dega

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.io.File

val httpClient = ServiceLocator.get(HttpClient::class.java)

suspend fun main() {
    layers.forEach { getLayer(it) }
}

private suspend fun getLayer(layer:String) {
    val fileName = "json_layers/$layer.json"
    val url = ""
    val response=  httpClient.get(url){
        headers {
            append(HttpHeaders.Authorization, "Basic xx")
        }
    }
    val file = File(fileName)

    // Use PrintWriter to write the string to the file
    file.printWriter().use { out ->
        out.println(response.body<String>())
    }
    println("🔥 file created: $fileName")
}

var layers = listOf("layer1", "layer2")