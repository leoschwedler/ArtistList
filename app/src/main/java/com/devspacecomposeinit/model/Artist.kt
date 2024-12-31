package com.devspacecomposeinit.model

import androidx.annotation.DrawableRes

data class Artist(
    val name: String,
    val lastSeeOnline: String,
    @DrawableRes val imageAutor: Int,
    @DrawableRes val imagePicture: Int

)
