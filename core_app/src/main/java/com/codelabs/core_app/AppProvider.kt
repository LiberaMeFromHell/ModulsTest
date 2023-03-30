package com.codelabs.core_app

import android.content.Context

interface AppProvider {

    fun provideContext(): Context
}