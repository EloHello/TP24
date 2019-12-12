package ca.elohello.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.BoringLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {

    ImageButton boutonCompte;
    ImageButton boutonMessages;
    ImageView imageSwipe;
    public static final int CODE_RETOUR = 1;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonCompte = (ImageButton) findViewById(R.id.compte);

        boutonCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, AccountInfo.class);
                startActivity(intent);
                getSharedPreferences();
            }
        });

        boutonMessages = (ImageButton) findViewById(R.id.messagerie);

        boutonMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, TopImages.class);
                startActivity(intent);
            }
        });

        ImageAdapter adapter = new ImageAdapter(this); //Here we are defining the Imageadapter object

        imageSwipe = (ImageView) findViewById(R.id.photoSwipe);

        imageSwipe.setOnTouchListener(new OnSwipeTouchListener(MainPage.this) {
            public void onSwipeTop() {
                Toast.makeText(MainPage.this, "top", Toast.LENGTH_SHORT).show();
                System.out.println("top");
            }
            public void onSwipeRight() {
                Toast.makeText(MainPage.this, "right", Toast.LENGTH_SHORT).show();
                System.out.println("right");
            }
            public void onSwipeLeft() {
                Toast.makeText(MainPage.this, "left", Toast.LENGTH_SHORT).show();
                System.out.println("left");
            }
            public void onSwipeBottom() {
                System.out.println("bottom");
                Toast.makeText(MainPage.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getSharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainPage.this);
        Boolean theme = prefs.getBoolean("switch_preference_1", true);
        String listPrefs = prefs.getString("liste","-1");

        StringBuilder builder = new StringBuilder();
        builder.append("theme: " + theme + "\n");
        builder.append("List preference: " + listPrefs);
        System.out.println(builder.toString());
    }
}