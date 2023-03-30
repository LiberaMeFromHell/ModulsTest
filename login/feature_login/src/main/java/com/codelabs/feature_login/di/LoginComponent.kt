package com.codelabs.feature_login.di

import com.codelabs.core_booking.CoreBookingComponent
import com.codelabs.core_login.CoreLoginComponent
import com.codelabs.feature_login.MainActivity
import dagger.Component

@Component(
    dependencies = [CoreLoginComponent::class, CoreBookingComponent::class]
)
interface LoginComponent {
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun coreLoginComponent(component: CoreLoginComponent): Builder
        fun coreBookingComponent(component: CoreBookingComponent): Builder
        fun create(): LoginComponent
    }

    companion object {
        fun create(): LoginComponent =
            DaggerLoginComponent
                .builder()
                .coreLoginComponent(CoreLoginComponent.create())
                .coreBookingComponent(CoreBookingComponent.create())
                .create()
    }
}