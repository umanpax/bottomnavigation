package com.compose.utils

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EncryptedData(@SerializedName("cypherText") @Expose var cypherText: ByteArray, @SerializedName("cipherIv") @Expose var cipherIv: ByteArray) : Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EncryptedData

        if (!cypherText.contentEquals(other.cypherText)) return false
        if (!cipherIv.contentEquals(other.cipherIv)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cypherText.contentHashCode()
        result = 31 * result + cipherIv.contentHashCode()
        return result
    }
}