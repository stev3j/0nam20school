package com.yeongnam.webbrowser

import android.content.Context
import android.content.Intent
import android.net.Uri
import javax.security.auth.Subject

class Extention {
}

fun Context.sendSMS(number: String, text: String = "") : Boolean {
    return try {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("sms:$number")
        )
        intent.putExtra("sms_body", text)
        startActivity(intent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

fun Context.sendEmail(email: String, subject: String = "", text: String = "") : Boolean {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:")
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    if (subject.isNotEmpty())
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    if (text.isNotEmpty())
        intent.putExtra(Intent.EXTRA_TEXT, text)
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        return true
    }
    return false
}

fun Context.browse(url: String, newTask: Boolean = false) : Boolean {
    return try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        if (newTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        true
    } catch (e : Exception) {
        e.printStackTrace()
        false
    }
}