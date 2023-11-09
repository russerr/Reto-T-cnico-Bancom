import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"


    //const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val runtimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.runtimeCompose}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtimeKtx}"
    //const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    //const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    //const val constraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}"
    const val tracing = "androidx.tracing:tracing-ktx:${Versions.trace}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val accompanistPermission = "com.google.accompanist:accompanist-permissions:${Versions.accompanistPermission}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
    implementation(Dependencies.converterGson)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.hiltNavigationCompose)
    //mplementation(Dependencies.runtimeCompose)
    //mplementation(Dependencies.runtimeKtx)
    implementation(Dependencies.navigationCompose)
    //implementation(Dependencies.tracing)
    //implementation(Dependencies.viewModel)
    //implementation(Dependencies.accompanistPermission)
    debugImplementation(Dependencies.composeUiToolingPreview)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.ModuleCore() {
    implementation(project(":core"))
}

fun DependencyHandler.ModuleCoreUi() {
    implementation(project(":core-ui"))
}

fun DependencyHandler.ModuleOnboardingPresentation() {
    implementation(project(":onboarding:presentation"))
}

fun DependencyHandler.ModuleOnboardingDomain() {
    implementation(project(":onboarding:domain"))
}


fun DependencyHandler.ModuleOnboardingData() {
    implementation(project(":onboarding:data"))
}

fun DependencyHandler.ModuleHomePresentation() {
    implementation(project(":home:presentation"))
}

fun DependencyHandler.ModuleHomeDomain() {
    implementation(project(":home:domain"))
}

fun DependencyHandler.ModuleHomeData() {
    implementation(project(":home:data"))
}
