package word_puzzle.compunet.com.wordpuzzle;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by welcome on 2/18/2016.
 */
public class HomeScreenActivity extends ActionBarActivity {

    WordPuzzleSqliteDB sqllite;
    String levelstring="",wordstring="",hint1string="",hint2string="",hint3string="",scorestring="",wordhint="";
    TextView level,hint1,hint2,hint3,word,score;
    Button id1,id2,id3,id4,id5,previous,next,submit;
    EditText editText;
    int count=1;
    LinearLayout full_layout,letter_layout;

    Button  letter_a,letter_b,letter_c,letter_d,letter_e,letter_f,
            letter_g,letter_h,letter_i,letter_j,letter_k,letter_l,
            letter_m,letter_n,letter_o,letter_p,letter_q,letter_r,
            letter_s,letter_t,letter_u,letter_v,letter_w,letter_x,
            letter_y,letter_z;
    Cursor cursor=null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        level=(TextView)findViewById(R.id.level);
        hint1=(TextView)findViewById(R.id.hint1);
        hint2=(TextView)findViewById(R.id.hint2);
        hint3=(TextView)findViewById(R.id.hint3);
        score=(TextView)findViewById(R.id.score);
        word=(TextView)findViewById(R.id.word);

        editText=(EditText)findViewById(R.id.edit_text);

        id1=(Button)findViewById(R.id.id1);
        id2=(Button)findViewById(R.id.id2);
        id3=(Button)findViewById(R.id.id3);
        id4=(Button)findViewById(R.id.id4);
        id5=(Button)findViewById(R.id.id5);


        letter_a=(Button)findViewById(R.id.letter_a);
        letter_b=(Button)findViewById(R.id.letter_b);
        letter_c=(Button)findViewById(R.id.letter_c);
        letter_d=(Button)findViewById(R.id.letter_d);
        letter_e=(Button)findViewById(R.id.letter_e);
        letter_f=(Button)findViewById(R.id.letter_f);
        letter_g=(Button)findViewById(R.id.letter_g);
        letter_h=(Button)findViewById(R.id.letter_h);
        letter_i=(Button)findViewById(R.id.letter_i);
        letter_j=(Button)findViewById(R.id.letter_j);
        letter_k=(Button)findViewById(R.id.letter_k);
        letter_l=(Button)findViewById(R.id.letter_l);
        letter_m=(Button)findViewById(R.id.letter_m);
        letter_n=(Button)findViewById(R.id.letter_n);
        letter_o=(Button)findViewById(R.id.letter_o);
        letter_p=(Button)findViewById(R.id.letter_p);
        letter_q=(Button)findViewById(R.id.letter_q);
        letter_r=(Button)findViewById(R.id.letter_r);
        letter_s=(Button)findViewById(R.id.letter_s);
        letter_t=(Button)findViewById(R.id.letter_t);
        letter_u=(Button)findViewById(R.id.letter_u);
        letter_v=(Button)findViewById(R.id.letter_v);
        letter_w=(Button)findViewById(R.id.letter_w);
        letter_x=(Button)findViewById(R.id.letter_x);
        letter_y=(Button)findViewById(R.id.letter_y);
        letter_z=(Button)findViewById(R.id.letter_z);




        previous=(Button)findViewById(R.id.previous);
        next=(Button)findViewById(R.id.next);

        full_layout=(LinearLayout)findViewById(R.id.full_layout);
        letter_layout=(LinearLayout)findViewById(R.id.letter_layout);


        sqllite=new WordPuzzleSqliteDB(this);
         cursor= sqllite.select();
        if(getIntent().getStringExtra("level_type")!=null){
            if(getIntent().getStringExtra("level_type").equals("Beginner"))
            cursor.moveToPosition(Integer.parseInt(getIntent().getStringExtra("level"))-1+0);
            else if(getIntent().getStringExtra("level_type").equals("Intermediate"))
            {
                id4.setVisibility(View.GONE);
                id5.setVisibility(View.GONE);
                cursor.moveToPosition(Integer.parseInt(getIntent().getStringExtra("level")) - 1 + 15);
            }
            else if(getIntent().getStringExtra("level_type").equals("Expert"))
            {
                id3.setVisibility(View.GONE);
                id4.setVisibility(View.GONE);
                id5.setVisibility(View.GONE);
                cursor.moveToPosition(Integer.parseInt(getIntent().getStringExtra("level"))-1+30);
            }

            if(getIntent().getStringExtra("level").equals("1"))
            {
                previous.setVisibility(View.GONE);
            }
            else if(getIntent().getStringExtra("level").equals("15"))
            {
                next.setVisibility(View.GONE);
            }

            wordstring = cursor.getString(cursor.getColumnIndex("word")).trim();
            hint1string = cursor.getString(cursor.getColumnIndex("hint1")).trim();
            hint2string = cursor.getString(cursor.getColumnIndex("hint2")).trim();
            hint3string = cursor.getString(cursor.getColumnIndex("hint3")).trim();
            scorestring = cursor.getString(cursor.getColumnIndex("score")).trim();

            hint1.setText(hint1string);

            hint2.setText(hint2string);

            hint3.setText(hint3string);

            score.setText("High Score  "+scorestring);

            word.setText("The word length is " + wordstring.length());

            level.setText(getIntent().getStringExtra("level_type") + " " + getIntent().getStringExtra("level"));
        }



       /*for(int i=0;i<wordstring.length();i++)
       {
           //if(Character.toString(wordhint.charAt(i)).equals("_"))
          if(Character.toString(wordstring.charAt(i)).equals("s"))
          {
              StringBuilder myName = new StringBuilder("domanokz");
              myName.setCharAt(4, 'x');

          }
           else
          {
              wordhint.concat("_");
          }
       }*/


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip_3d_reverse);
                anim.setTarget(full_layout);
                anim.setDuration(3000);
                anim.start();
                cursor.moveToPrevious();
                wordstring = cursor.getString(cursor.getColumnIndex("word"));
                hint1string = cursor.getString(cursor.getColumnIndex("hint1"));
                hint2string = cursor.getString(cursor.getColumnIndex("hint2"));
                hint3string = cursor.getString(cursor.getColumnIndex("hint3"));
                scorestring = cursor.getString(cursor.getColumnIndex("score"));

                hint1.setText(hint1string);

                hint2.setText(hint2string);

                hint3.setText(hint3string);

                score.setText("High Score  "+scorestring);

                word.setText("The word length is "+wordstring.length());

                level.setText(getIntent().getStringExtra("level_type")+" "+(cursor.getPosition()+1));
                if(getIntent().getStringExtra("level_type").equals("Beginner"))
                {
                    if((cursor.getPosition()+1)==0)
                    {
                        previous.setVisibility(View.GONE);
                    }
                }
                else if(getIntent().getStringExtra("level_type").equals("Intermediate"))
                {
                    if((cursor.getPosition()+1)==16)
                    {
                        previous.setVisibility(View.GONE);
                    }
                }
                if(getIntent().getStringExtra("level_type").equals("Expert"))
                {
                    if((cursor.getPosition()+1)==31)
                    {
                        previous.setVisibility(View.GONE);
                    }
                }
                if(next.getVisibility()==View.GONE)
                {
                    next.setVisibility(View.VISIBLE);
                }
                editText.setText("");
                hint2.setVisibility(View.GONE);
                hint3.setVisibility(View.GONE);
                id1.setBackgroundResource(R.drawable.round);
                id2.setBackgroundResource(R.drawable.round);
                id3.setBackgroundResource(R.drawable.round);
                id4.setBackgroundResource(R.drawable.round);
                id5.setBackgroundResource(R.drawable.round);
                count=1;
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip_3d);
                anim.setTarget(full_layout);
                anim.setDuration(3000);
                anim.start();
                cursor.moveToNext();
                wordstring = cursor.getString(cursor.getColumnIndex("word"));
                hint1string = cursor.getString(cursor.getColumnIndex("hint1"));
                hint2string = cursor.getString(cursor.getColumnIndex("hint2"));
                hint3string = cursor.getString(cursor.getColumnIndex("hint3"));
                scorestring = cursor.getString(cursor.getColumnIndex("score"));

                hint1.setText(hint1string);

                hint2.setText(hint2string);

                hint3.setText(hint3string);

                score.setText("High Score  "+scorestring);

                word.setText("The word length is "+wordstring.length());

                level.setText(getIntent().getStringExtra("level_type")+" "+(cursor.getPosition()+1));



                if(getIntent().getStringExtra("level_type").equals("Beginner"))
                {
                    if((cursor.getPosition()+1)==15)
                    {
                        next.setVisibility(View.GONE);
                    }
                }
                else if(getIntent().getStringExtra("level_type").equals("Intermediate"))
                {
                    if((cursor.getPosition()+1)==30)
                    {
                        next.setVisibility(View.GONE);
                    }
                }
                if(getIntent().getStringExtra("level_type").equals("Expert"))
                {
                    if((cursor.getPosition()+1)==45)
                    {
                        next.setVisibility(View.GONE);
                    }
                }

                if(previous.getVisibility()==View.GONE)
                {
                    previous.setVisibility(View.VISIBLE);
                }
                editText.setText("");
                hint2.setVisibility(View.GONE);
                hint3.setVisibility(View.GONE);
                id1.setBackgroundResource(R.drawable.round);
                id2.setBackgroundResource(R.drawable.round);
                id3.setBackgroundResource(R.drawable.round);
                id4.setBackgroundResource(R.drawable.round);
                id5.setBackgroundResource(R.drawable.round);
                count=1;
            }
        });

        id1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==1) {
                    showLetterLayout();
                    id1.setBackgroundResource(R.drawable.round_red);
                    count++;
                }
            }
        });

        id2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==2) {
                    showLetterLayout();
                    id2.setBackgroundResource(R.drawable.round_red);
                    count++;
                    hint2.setVisibility(View.VISIBLE);
                }
            }
        });
        id3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==3) {
                    showLetterLayout();
                    id3.setBackgroundResource(R.drawable.round_red);
                    count++;
                }
            }
        });
        id4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==4) {
                    showLetterLayout();
                    id4.setBackgroundResource(R.drawable.round_red);
                    count++;
                    hint3.setVisibility(View.VISIBLE);
                }
            }
        });

        id5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==5) {
                    showLetterLayout();
                    id5.setBackgroundResource(R.drawable.round_red);
                    count++;
                }
            }
        });


        letter_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_a.getText().toString());
            }
        });
        letter_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_b.getText().toString());
            }
        });
        letter_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_c.getText().toString());
            }
        });
        letter_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_d.getText().toString());
            }
        });
        letter_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_e.getText().toString());
            }
        });
        letter_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_f.getText().toString());
            }
        });
        letter_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_g.getText().toString());
            }
        });
        letter_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_h.getText().toString());
            }
        });
        letter_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_i.getText().toString());
            }
        });
        letter_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_j.getText().toString());
            }
        });
        letter_k.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            hideLetterLayout(letter_k.getText().toString());
        }
    });
        letter_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_l.getText().toString());
            }
        });
        letter_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_m.getText().toString());
            }
        });
        letter_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_n.getText().toString());
            }
        });
        letter_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_o.getText().toString());
            }
        });
        letter_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_p.getText().toString());
            }
        });
        letter_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_q.getText().toString());
            }
        });
        letter_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_r.getText().toString());
            }
        });

        letter_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_s.getText().toString());
            }
        });
        letter_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_t.getText().toString());
            }
        });
        letter_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_u.getText().toString());
            }
        });
        letter_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_v.getText().toString());
            }
        });
        letter_w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_w.getText().toString());
            }
        });
        letter_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_x.getText().toString());
            }
        });
        letter_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_y.getText().toString());
            }
        });
        letter_z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideLetterLayout(letter_z.getText().toString());
            }
        });




        submit=(Button)findViewById(R.id.summit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().trim().equalsIgnoreCase(wordstring))
                {
                    if((getIntent().getStringExtra("level_type").equals("Beginner")&&(cursor.getPosition()+1)==15)
                            ||(getIntent().getStringExtra("level_type").equals("Intermediate")&&(cursor.getPosition()+1)==30)
                            ||(getIntent().getStringExtra("level_type").equals("Expert")&&(cursor.getPosition()+1)==45))
                    {
                        new AlertDialog.Builder(HomeScreenActivity.this)
                                .setTitle("congratulations")
                                .setMessage("you finish this level")
                                .setIcon(R.drawable.smile)
                                .setNegativeButton(" OK", null).show().setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog)
                            {
                            dialog.dismiss();
                            }
                        });
                    }
                    else
                    {
                        final AlertDialog alertDialog = new AlertDialog.Builder(HomeScreenActivity.this).create(); //Read Update
                        alertDialog.setTitle("Congratulations");
                        alertDialog.setIcon(R.drawable.smile);
                        alertDialog.setMessage("You finish this level ..");
                        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip_3d);
                                anim.setTarget(full_layout);
                                anim.setDuration(3000);
                                anim.start();
                                cursor.moveToNext();
                                wordstring = cursor.getString(cursor.getColumnIndex("word"));
                                hint1string = cursor.getString(cursor.getColumnIndex("hint1"));
                                hint2string = cursor.getString(cursor.getColumnIndex("hint2"));
                                hint3string = cursor.getString(cursor.getColumnIndex("hint3"));
                                scorestring = cursor.getString(cursor.getColumnIndex("score"));

                                hint1.setText(hint1string);

                                hint2.setText(hint2string);

                                hint3.setText(hint3string);

                                score.setText("High Score  " + scorestring);

                                word.setText("The word length is " + wordstring.length());

                                level.setText(getIntent().getStringExtra("level_type") + " " + (cursor.getPosition() + 1));


                                if (getIntent().getStringExtra("level_type").equals("Beginner")) {
                                    if ((cursor.getPosition() + 1) == 15) {
                                        next.setVisibility(View.GONE);
                                    }
                                } else if (getIntent().getStringExtra("level_type").equals("Intermediate")) {
                                    if ((cursor.getPosition() + 1) == 30) {
                                        next.setVisibility(View.GONE);
                                    }
                                }
                                if (getIntent().getStringExtra("level_type").equals("Expert")) {
                                    if ((cursor.getPosition() + 1) == 45) {
                                        next.setVisibility(View.GONE);
                                    }
                                }

                                if (previous.getVisibility() == View.GONE) {
                                    previous.setVisibility(View.VISIBLE);
                                }
                                editText.setText("");
                                hint2.setVisibility(View.GONE);
                                hint3.setVisibility(View.GONE);
                                id1.setBackgroundResource(R.drawable.round);
                                id2.setBackgroundResource(R.drawable.round);
                                id3.setBackgroundResource(R.drawable.round);
                                id4.setBackgroundResource(R.drawable.round);
                                id5.setBackgroundResource(R.drawable.round);
                                count=1;
                            }

                        });
                        alertDialog.show();

                    }

                } else {
                    Toast.makeText(getApplicationContext(), " Your guess is wrong ,Thing different ",Toast.LENGTH_SHORT).show();

                }

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }






    void showLetterLayout()
    {
        full_layout.setVisibility(View.GONE);
        letter_layout.setVisibility(View.VISIBLE);
    }

    void hideLetterLayout(String letter) {

        full_layout.setVisibility(View.VISIBLE);
        letter_layout.setVisibility(View.GONE);
        String temp = "", temp_verify = "";

        if (word.getText().toString().contains("The word length is ")) {
            for (int i = 0; i < wordstring.length(); i++) {
                temp = temp.concat("_ ");
            }
            temp_verify = temp;

        } else {
            temp = word.getText().toString();
        }

        for (int i = 0; i < wordstring.length(); i++) {
            if (letter.equalsIgnoreCase(String.valueOf(wordstring.charAt(i)))) {
                temp = temp.substring(0, (2 * i)) + letter + temp.substring((2 * i) + 1);
            }
        }
        if (!temp.equals(temp_verify)) {
            temp_verify = temp.replace(" ", "");
            if (temp_verify.equalsIgnoreCase(wordstring)) {
                word.setText(temp_verify);
                if((getIntent().getStringExtra("level_type").equals("Beginner")&&(cursor.getPosition()+1)==15)
                        ||(getIntent().getStringExtra("level_type").equals("Intermediate")&&(cursor.getPosition()+1)==30)
                        ||(getIntent().getStringExtra("level_type").equals("Expert")&&(cursor.getPosition()+1)==45))
                {
                    new AlertDialog.Builder(HomeScreenActivity.this)
                            .setTitle("congratulations")
                            .setMessage("you finish this level")
                            .setIcon(R.drawable.smile)
                            .setNegativeButton(" OK", null).show().setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog)
                        {
                            dialog.dismiss();
                        }
                    });
                }
                else
                {
                    final AlertDialog alertDialog = new AlertDialog.Builder(HomeScreenActivity.this).create(); //Read Update
                    alertDialog.setTitle("Congratulations");
                    alertDialog.setIcon(R.drawable.smile);
                    alertDialog.setMessage("You finish this level ..");
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Next Level", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip_3d);
                            anim.setTarget(full_layout);
                            anim.setDuration(3000);
                            anim.start();
                            cursor.moveToNext();
                            wordstring = cursor.getString(cursor.getColumnIndex("word"));
                            hint1string = cursor.getString(cursor.getColumnIndex("hint1"));
                            hint2string = cursor.getString(cursor.getColumnIndex("hint2"));
                            hint3string = cursor.getString(cursor.getColumnIndex("hint3"));
                            scorestring = cursor.getString(cursor.getColumnIndex("score"));

                            hint1.setText(hint1string);

                            hint2.setText(hint2string);

                            hint3.setText(hint3string);

                            score.setText("High Score  " + scorestring);

                            word.setText("The word length is " + wordstring.length());

                            level.setText(getIntent().getStringExtra("level_type") + " " + (cursor.getPosition() + 1));


                            if (getIntent().getStringExtra("level_type").equals("Beginner")) {
                                if ((cursor.getPosition() + 1) == 15) {
                                    next.setVisibility(View.GONE);
                                }
                            } else if (getIntent().getStringExtra("level_type").equals("Intermediate")) {
                                if ((cursor.getPosition() + 1) == 30) {
                                    next.setVisibility(View.GONE);
                                }
                            }
                            if (getIntent().getStringExtra("level_type").equals("Expert")) {
                                if ((cursor.getPosition() + 1) == 45) {
                                    next.setVisibility(View.GONE);
                                }
                            }

                            if (previous.getVisibility() == View.GONE) {
                                previous.setVisibility(View.VISIBLE);
                            }
                            editText.setText("");
                            hint2.setVisibility(View.GONE);
                            hint3.setVisibility(View.GONE);
                            id1.setBackgroundResource(R.drawable.round);
                            id2.setBackgroundResource(R.drawable.round);
                            id3.setBackgroundResource(R.drawable.round);
                            id4.setBackgroundResource(R.drawable.round);
                            id5.setBackgroundResource(R.drawable.round);
                            count=1;
                        }

                    });
                    alertDialog.show();

                }


                }
        else {
                    word.setText(temp);
                }
            }


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
