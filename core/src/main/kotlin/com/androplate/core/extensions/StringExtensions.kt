package com.androplate.core.extensions

import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import android.util.Base64
import java.security.KeyFactory
import java.security.PublicKey
import java.security.spec.X509EncodedKeySpec
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale
import javax.crypto.Cipher

/**
 * Replaces all non digits from string
 */
fun String.replaceNonDigits(): String {
    return replace("[^\\d.]".toRegex(), "")
}

fun String.getCountryFlagDrawableName() = "country_flag_$this"

fun String?.getNullIfEmpty(): String? {
    return if (isNullOrEmpty()) null else this
}

fun String?.getEmptyIfNull(): String {
    return if (isNullOrEmpty()) "" else this
}

fun String?.asSpannedHtml(): Spanned {
    return when {
        this == null -> {
            SpannableString("")
        }

        else -> {
            Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
        }
    }
}


fun String.encryptRSA(publicKey: String): String {
    var encoded = ""
    var encrypted: ByteArray? = null
    try {
        val publicBytes: ByteArray = Base64.decode(publicKey, Base64.NO_WRAP)
        val keySpec = X509EncodedKeySpec(publicBytes)
        val keyFactory: KeyFactory = KeyFactory.getInstance("RSA")
        val pubKey: PublicKey = keyFactory.generatePublic(keySpec)
        val cipher: Cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING") //or try with "RSA"
        cipher.init(Cipher.ENCRYPT_MODE, pubKey)
        encrypted = cipher.doFinal(this.toByteArray())
        encoded = Base64.encodeToString(encrypted, Base64.NO_WRAP)
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }
    return encoded
}


fun String.capitaliseName(): String {
    val collect = split(" ").toTypedArray()
    var returnName = ""
    for (i in collect.indices) {
        collect[i] = collect[i].trim { it <= ' ' }.lowercase(Locale.getDefault())
        if (collect[i].isNotEmpty()) {
            returnName = returnName + collect[i].substring(0, 1)
                .uppercase(Locale.getDefault()) + collect[i].substring(1) + " "
        }
    }
    return returnName.trim { it <= ' ' }
}

fun String.capitaliseOnlyFirstLetter(): String {
    return substring(0, 1).uppercase(Locale.getDefault()) + substring(1)
}


fun String.isValidIban(): Boolean {
    if (!"^[0-9A-Z]*\$".toRegex().matches(this)) {
        return false
    }

    val symbols = this.trim { it <= ' ' }
    if (symbols.length < 15 || symbols.length > 34) {
        return false
    }
    val swapped = symbols.substring(4) + symbols.substring(0, 4)
    return swapped.toCharArray()
        .map { it.code }
        .fold(0) { previousMod: Int, _char: Int ->
            val value = Integer.parseInt(_char.toChar().toString(), 36)
            val factor = if (value < 10) 10 else 100
            (factor * previousMod + value) % 97
        } == 1
}

fun String.formatToAmount(): String {
    val locale: Locale = Locale.UK
    val currency = Currency.getInstance(locale)
    val cleanString = this.replace("[${currency.symbol},.]".toRegex(), "")
    val parsed = cleanString.toDouble()
    return NumberFormat.getCurrencyInstance(locale).format(parsed / 100)
        .replace("[${currency.symbol}]".toRegex(), "")
}

fun String.addPlus(): String {
    return "+$this"
}

fun String.removeWhitespaces() = this.filter { !it.isWhitespace() }

@Suppress("DEPRECATED_IDENTITY_EQUALS")
fun String.checkCharCountIfMoreThanTwice(): Boolean {
    for (i in indices) {
        var count = 1
        for (j in i + 1 until this.length) {
            if (this[i] === this[j] && this[i] != ' ')
                count++
        }
        if (count > 2)
            return true
    }
    return false
}

@Suppress("DEPRECATED_IDENTITY_EQUALS")
fun String.removeZeros(): String {
    var init = 0
    while (init < this.length && this[init] === '0') init++
    val sb = StringBuffer(this)
    sb.replace(0, init, "")
    return sb.toString()
}

fun String.doubleFormat(): String {
    val string = this.filter { it.isDigit() || it == '.' }
    if (string.isEmpty()) return "0.00"
    return string
}

fun String.getFullNameFirstCharacter(): String {
    // split name and surname
    val nameFirstCharacter: String = if (this.isNotEmpty() && this.contains(" ")) {
        val nameList = this.split(" ")
        if (nameList.size > 1) "${
            nameList[0].firstOrNull() ?: ""
        }${nameList[1].firstOrNull() ?: ""}" else ""
    } else {
        "${this.firstOrNull() ?: ""}".uppercase()
    }

    return nameFirstCharacter
}

fun String.removeStar(): String {
    return this.replace("*", "")
}
