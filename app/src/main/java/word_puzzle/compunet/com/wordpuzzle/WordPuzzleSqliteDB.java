package word_puzzle.compunet.com.wordpuzzle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by connectors on 1/7/2016.
 */
public class WordPuzzleSqliteDB extends SQLiteOpenHelper {
    public WordPuzzleSqliteDB(Context context)
    {
        super(context, "WordPuzzle", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table word_puzzle " + "(id integer primary key AUTOINCREMENT,word text,hint1 text,hint2 text,hint3 text,score text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS word_puzzle");
        onCreate(db);
    }
    public void insert(String word,String hind1,String hind2,String hind3){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("word", word);
        contentValues.put("hint1", hind1);
        contentValues.put("hint2", hind2);
        contentValues.put("hint3", hind3);
        contentValues.put("score", "0");
        db.insert("word_puzzle", null, contentValues);
    }
    public Cursor select(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM word_puzzle",null);
        return cursor;
    }
    public void update(String score){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("language",score);
        db.update("location", contentValues, "score = ?", new String[]{score});
        select();
    }
}
