package saim.com.autisticapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import saim.com.autisticapp.Util.SharedPrefDatabase;

public class ActivityBlog extends AppCompatActivity {

    TextView txtTitle;
    Button btnBlog, btnForum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeFull);
        setContentView(R.layout.activity_parents);

        init();
    }

    private void init() {
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        btnBlog = (Button) findViewById(R.id.btnCapture);
        btnForum = (Button) findViewById(R.id.btnAlbum);


        if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("BN")) {
            txtTitle.setText(R.string.parents_mode_bd_1);
            btnBlog.setText(R.string.parents_mode_bd_2);
            btnForum.setText(R.string.parents_mode_bd_3);
        } else if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("EN")) {
            txtTitle.setText(R.string.parents_mode_en_1);
            btnBlog.setText(R.string.parents_mode_en_2);
            btnForum.setText(R.string.parents_mode_en_3);
        }

        actionEvent();
    }


    private void actionEvent() {

        btnBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivityParentsCapture.class));
            }
        });

        btnForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivityParentsAlbum2.class));
            }
        });
    }
}
