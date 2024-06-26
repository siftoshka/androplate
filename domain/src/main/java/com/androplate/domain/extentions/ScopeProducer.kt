package com.androplate.domain.extentions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

fun scopeIoProduce() = CoroutineScope(Dispatchers.IO + SupervisorJob())
fun scopeMainProduce() = CoroutineScope(Dispatchers.Main + SupervisorJob())
fun scopeDefaultProduce() = CoroutineScope(Dispatchers.Default + SupervisorJob())