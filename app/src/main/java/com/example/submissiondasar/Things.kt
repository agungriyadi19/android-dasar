package com.example.submissiondasar

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Things(
    var country: String,
    var photo: String,
    var capital: String,
    var currency: String,
    var language: String,
    var description: String,
) : Parcelable
