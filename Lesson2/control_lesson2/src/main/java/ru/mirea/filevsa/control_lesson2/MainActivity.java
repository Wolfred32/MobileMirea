package ru.mirea.filevsa.control_lesson2;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.time.Month;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private String showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickShowTimeDialog(View view) {
        MyTimeDialogFragment _timeDialog = new MyTimeDialogFragment(this, (view1, hourOfDay, minute) -> {
            showText = String.format(Locale.getDefault(),
                    "Hours: %d | Minutes: %d", hourOfDay, minute);
            useSnackbar(view, showText);
        }, 17, 52, true);
        _timeDialog.show();
        useSnackbar(view, "Time Picker Opened");
    }

    public void onClickShowDateDialog(View view) {
        MyDateDialogFragment _dateDialog = new MyDateDialogFragment(this, (view1, year, month, dayOfMonth) -> {
            showText = String.format(Locale.getDefault(),
                    "Year: %d | Month: %s | Day: %d", year, Month.of(month + 1), dayOfMonth);
            useSnackbar(view, showText);
        }, 2023, 11, 12);
        _dateDialog.show();
        useSnackbar(view, "Date Picker Opened");
    }

    public void onClickShowProgressDialog(View view) {
        MyProgressDialogFragment _progressDialog = new MyProgressDialogFragment(this);
        _progressDialog.setTitle("Progress Dialog");
        _progressDialog.setMessage("Loading...");
        _progressDialog.show();
        useSnackbar(view, "Progress Dialog Opened");
    }

    private void useSnackbar(View view, String _showTextInfo) {
        Snackbar.make(view, _showTextInfo, Snackbar.LENGTH_LONG).show();
    }
}