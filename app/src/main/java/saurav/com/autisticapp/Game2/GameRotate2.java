package saurav.com.autisticapp.Game2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

import saurav.com.autisticapp.Model.ModelFamily;
import saurav.com.autisticapp.R;
import saurav.com.autisticapp.Util.DBHelperRashed;
import saurav.com.autisticapp.Util.SharedPrefDatabase;

public class GameRotate2 extends AppCompatActivity {

    int GAME_TYPE, COUNTER = 0, a;

    TextView txtQuestion, txtTitle;
    ImageView imgGameRoateimg, qusImgSound;
    ImageButton imgRotateLeft, imgRotateOk, imgRotateRight;
    DBHelperRashed dbHelper;

    ArrayList<ModelFamily> modelFamilies = new ArrayList<>();
    ArrayList<Integer> aCounter = new ArrayList<>();
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeFull);
        setContentView(R.layout.activity_game_rotate2);

        init();
    }

    private void init() {


        GAME_TYPE = getIntent().getExtras().getInt("GAME_TYPE");
        dbHelper = new DBHelperRashed(this);
        modelFamilies = dbHelper.getAllFamilyMembersNew();

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        qusImgSound = (ImageView) findViewById(R.id.qusImgSound);

        imgGameRoateimg = (ImageView) findViewById(R.id.imgGameRoateimg);

        imgRotateLeft = (ImageButton) findViewById(R.id.imgRotateLeft);
        imgRotateOk = (ImageButton) findViewById(R.id.imgRotateOk);
        imgRotateRight = (ImageButton) findViewById(R.id.imgRotateRight);

        txtTitle = findViewById(R.id.txtTitle);

        if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("BN")) {
            txtTitle.setText(R.string.games_bn_5);
        } else if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("EN")) {
            txtTitle.setText(R.string.games_en_5);
        }


        qusImgSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaySound();
            }
        });

        actionEvent();
    }

    private void actionEvent() {

        a = getRandomNumber(modelFamilies);
        if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("BN")) {
            txtQuestion.setText(R.string.games_fix_bn);
        } else if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("EN")) {
            txtQuestion.setText(R.string.games_fix_en);
        }

        PlaySound();

        int imgResource = getResources().getIdentifier(modelFamilies.get(a).image, "drawable", getPackageName());
        imgGameRoateimg.setImageResource(imgResource);
        imgGameRoateimg.setRotation(135);


        imgRotateLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGameRoateimg.setRotation(imgGameRoateimg.getRotation() + 45);
            }
        });

        imgRotateRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGameRoateimg.setRotation(imgGameRoateimg.getRotation() - 45);
            }
        });


        imgRotateOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgGameRoateimg.getRotation() == 0 || (imgGameRoateimg.getRotation() % 360) == 0) {
                    playRightAnswerSound();
                } else {
                    playWrongAnswerSound();
                }
            }
        });

    }


    public void playRightAnswerSound() {
        if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("BN")) {
            actionEventSound(getApplicationContext(), "right_ans_bn.mp3");
            showDialogSuccess(getApplicationContext(), getResources().getString(R.string.ans_comments_bn),getResources().getString(R.string.ans_right_bn));
        } else if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("EN")) {
            actionEventSound(getApplicationContext(), "right_ans_en.mp3");
            showDialogSuccess(getApplicationContext(), getResources().getString(R.string.ans_comments_en),getResources().getString(R.string.ans_right_en));
        }
    }
    public void playWrongAnswerSound() {
        if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("BN")) {
            actionEventSound(getApplicationContext(), "wrong_ans_bn.mp3");
            showDialogFail(getApplicationContext(), getResources().getString(R.string.ans_comments_bn),getResources().getString(R.string.ans_wrong_bn));
        } else if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("EN")) {
            actionEventSound(getApplicationContext(), "wrong_ans_en.mp3");
            showDialogFail(getApplicationContext(), getResources().getString(R.string.ans_comments_en),getResources().getString(R.string.ans_wrong_en));
        }
    }


    public void PlaySound() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {

            AssetFileDescriptor descriptor = getAssets().openFd("a_who_is_en_2.mpeg");

            if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("BN")) {
                descriptor = getAssets().openFd("a_fix_bn.mpeg");
            } else if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("EN")) {
                descriptor = getAssets().openFd("a_fix_en.mpeg");
            }

            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.release();
            }
        });
    }

    private void actionEventSound(Context context,  final String Sound_s ) {

        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor descriptor = context.getAssets().openFd(Sound_s);
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.release();
            }
        });

    }


    public void showDialogSuccess(final Context context, final String title, String message) {
        new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme_AppCompat))
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        a++;
                        COUNTER++;
                        aCounter.add(a);

                        if (COUNTER >= modelFamilies.size()) {
                            COUNTER = 0;
                            dialog.dismiss();
                            if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("BN")) {
                                showDialogComplete(context, title, getResources().getString(R.string.game_complete_bn));
                            } else if (new SharedPrefDatabase(getApplicationContext()).RetriveLanguage().equals("EN")) {
                                showDialogComplete(context, title, getResources().getString(R.string.game_complete_en));
                            }
                        } else {
                            dialog.dismiss();
                            actionEvent();
                        }
                    }
                })
                .setIcon(android.R.drawable.btn_star_big_on)
                .show();
    }


    public void showDialogFail(Context context, String title,  String message) {
        new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme_AppCompat))
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_notification_clear_all)
                .show();
    }


    public void showDialogComplete(Context context, String title,  String message) {
        new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme_AppCompat))
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .setIcon(android.R.drawable.star_on)
                .show();
    }

    public int getRandomNumber(ArrayList<ModelFamily> list) {
        double randomDouble = Math.random();
        randomDouble = randomDouble * list.size();
        int randomInt = (int) randomDouble;
        /*if (aCounter.contains(randomInt)) {
            getRandomNumber(list);
        } else {
            return randomInt;
        }*/
        return randomInt;
    }
}
