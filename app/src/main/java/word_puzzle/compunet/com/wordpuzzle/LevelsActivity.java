package word_puzzle.compunet.com.wordpuzzle;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;


public class LevelsActivity extends ActionBarActivity {
    LinearLayout full_layout;
    Animation myAnim;

     Button level_1,level_2,level_3,level_4,level_5,level_6,level_7,level_8,level_9,
             level_10,level_11,level_12,level_13,level_14,level_15;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        full_layout=(LinearLayout)findViewById(R.id.full_layout);

        level_1=(Button)findViewById(R.id.level_1);
        level_2=(Button)findViewById(R.id.level_2);
        level_3=(Button)findViewById(R.id.level_3);
        level_4=(Button)findViewById(R.id.level_4);
        level_5=(Button)findViewById(R.id.level_5);
        level_6=(Button)findViewById(R.id.level_6);
        level_7=(Button)findViewById(R.id.level_7);
        level_8=(Button)findViewById(R.id.level_8);
        level_9=(Button)findViewById(R.id.level_9);
        level_10=(Button)findViewById(R.id.level_10);
        level_11=(Button)findViewById(R.id.level_11);
        level_12=(Button)findViewById(R.id.level_12);
        level_13=(Button)findViewById(R.id.level_13);
        level_14=(Button)findViewById(R.id.level_14);
        level_15=(Button)findViewById(R.id.level_15);






        myAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        full_layout.startAnimation(myAnim);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        level_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","1");
                startActivity(intent);
            }
        });

        level_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","2");
                startActivity(intent);
            }
        });

        level_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","3");
                startActivity(intent);
            }
        });

        level_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","4");
                startActivity(intent);
            }
        });

        level_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","5");
                startActivity(intent);
            }
        });

        level_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","6");
                startActivity(intent);
            }
        });

        level_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","7");
                startActivity(intent);
            }
        });

        level_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","8");
                startActivity(intent);
            }
        });

        level_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","9");
                startActivity(intent);
            }
        });

        level_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","10");
                startActivity(intent);
            }
        });

        level_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","11");
                startActivity(intent);
            }
        });

        level_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","12");
                startActivity(intent);
            }
        });

        level_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","13");
                startActivity(intent);
            }
        });

        level_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","14");
                startActivity(intent);
            }
        });

        level_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeScreenActivity.class);
                intent.putExtra("level_type",getIntent().getStringExtra("level_type"));
                intent.putExtra("level","15");
                startActivity(intent);
            }
        });

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
