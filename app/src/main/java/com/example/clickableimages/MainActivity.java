package com.example.clickableimages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    public static final String EXTRA_MESSAGE =
//            "com.example.clickableimages.droidcafe.extra.MESSAGE";
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    public String mOrderMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                displayToast("You choose The Setting");
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                displayToast("You choose The Favouries");

                return true;
            case R.id.action_contact:
                displayToast("You choose The Contact");
                return true;
            case R.id.action_order:
                displayToast("You choose The order");
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }

    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);

    }

    public void showFroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);

    }
}