package com.codelabs.feature_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.codelabs.core_booking_api.repository.BookingNavigationMediator
import com.codelabs.core_login_api.repository.LoginRepository
import com.codelabs.feature_login.di.LoginComponent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var loginRepository: LoginRepository

    @Inject
    lateinit var bookingNavigationMediator: BookingNavigationMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        LoginComponent.create().inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LoginScreen(::navigateToBooking) {}
            }
        }
    }

    private fun navigateToBooking() {
        bookingNavigationMediator.navigateToBookingActivity(this)
    }
}
