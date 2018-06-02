package com.popov.appstarterproxy.model

data class AndroidApp(val name: String, val packageName: String/*, val icon: Drawable*/) {
    override fun toString(): String = name
}