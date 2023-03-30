package com.codelabs.feature_booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.codelabs.core_booking_api.repository.BookingRepository;
import com.codelabs.feature_booking.di.BookingComponent;

import javax.inject.Inject;


public class BookingActivity2 extends AppCompatActivity {

    @Inject
    BookingRepository repository;

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BookingComponent.Companion.create().inject(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_booking2);
        cardView = findViewById(R.id.cardView);
        cardView.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BookingActivity3.class);
            startActivity(intent);

        });
    }
}
