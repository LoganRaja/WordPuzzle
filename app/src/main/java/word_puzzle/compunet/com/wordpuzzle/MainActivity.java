package word_puzzle.compunet.com.wordpuzzle;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity {

Button play_now,exit;
    WordPuzzleSqliteDB sqllite;

    String insert[];
    Animation myAnim;
    String id="id",word="word",hind1="hind1",hind2="hind2",hind3="hind3";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_now=(Button)findViewById(R.id.play_now);
        exit=(Button)findViewById(R.id.exit);


        sqllite=new WordPuzzleSqliteDB(this);
        Cursor cursor= sqllite.select();
        if(cursor.getCount()==0)
        {

            try {
                JSONArray mJsonArray = new JSONArray(loadJSONFromAsset());
                JSONObject mJsonObject = new JSONObject();
                for (int i = 0; i < mJsonArray.length(); i++)
                {
                    mJsonObject = mJsonArray.getJSONObject(i);
                    sqllite.insert(mJsonObject.getString(word),mJsonObject.getString(hind1),mJsonObject.getString(hind2),mJsonObject.getString(hind3));
                }
            } catch (JSONException e) {
                Log.e("catch", String.valueOf(e));
            }

        }

        myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.grow_from_middle);
        play_now.startAnimation(myAnim);
        exit.startAnimation(myAnim);



        play_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(MainActivity.this,LevelTypeActivity.class);
                startActivity(mainIntent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });




    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("question.json");
            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            Log.e("catch", String.valueOf(ex));
            return null;
        }
        return json;


    }
}
