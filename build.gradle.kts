// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

    // Agrega el plugin de Hilt sin aplicarlo automáticamente
    id("com.google.dagger.hilt.android") version "2.48" apply false


}