package com.alexleventer.slack.utils

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

open class HTTPUtil {
    private val client = OkHttpClient()

    fun post(url:String, json:String): String {
        val body: RequestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
        val request = Request.Builder()
                .url(url)
                .post(body)
                .build()
        val response = client.newCall(request).execute()
        response.close()
        return response.body().toString()
    }
}
