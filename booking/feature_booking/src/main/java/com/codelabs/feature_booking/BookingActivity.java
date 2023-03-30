package com.codelabs.feature_booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.core_booking_api.repository.BookingRepository;
import com.codelabs.feature_booking.di.BookingComponent;

import javax.inject.Inject;


public class BookingActivity extends AppCompatActivity {

    @Inject
    BookingRepository repository;

    Button search_buses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BookingComponent.Companion.create().inject(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_booking);
        search_buses = findViewById(R.id.search_buses);
        search_buses.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BookingActivity2.class);
            startActivity(intent);
        });
    }
}
