package com.shverma.booknexus

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.shverma.booknexus.app.App
import com.shverma.booknexus.di.initKoin


fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookpedia",
        ) {
            App()
        }
    }
}