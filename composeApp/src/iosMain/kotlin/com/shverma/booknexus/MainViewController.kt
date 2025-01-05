package com.shverma.booknexus

import androidx.compose.ui.window.ComposeUIViewController
import com.shverma.booknexus.app.App
import com.shverma.booknexus.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }