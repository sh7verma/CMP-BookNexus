package com.shverma.booknexus

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.shverma.booknexus.book.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CMP-BookNexus",
    ) {
        App()
    }
}