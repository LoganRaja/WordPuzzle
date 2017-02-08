package word_puzzle.compunet.com.wordpuzzle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class LevelTypeActivity extends ActionBarActivity {

Button beginner, intermediate,expert;
    WordPuzzleSqliteDB sqllite;

    Animation myAnim;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_types);
        sqllite=new WordPuzzleSqliteDB(this);

        beginner =(Button)findViewById(R.id.beginner);
        intermediate =(Button)findViewById(R.id.intermediate);
        expert=(Button)findViewById(R.id.expert);


        myAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink_to_middle);
        beginner.startAnimation(myAnim);
        intermediate.startAnimation(myAnim);
        expert.startAnimation(myAnim);

        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelTypeActivity.this, LevelsActivity.class);
                intent.putExtra("level_type","Beginner");
                startActivity(intent);
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelTypeActivity.this, LevelsActivity.class);
                intent.putExtra("level_type","Intermediate");
                startActivity(intent);
            }
        });
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelTypeActivity.this, LevelsActivity.class);
                intent.putExtra("level_type","Expert");
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

