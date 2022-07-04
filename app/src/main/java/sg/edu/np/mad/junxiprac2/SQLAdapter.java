package sg.edu.np.mad.junxiprac2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SQLAdapter extends SQLiteOpenHelper {

    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_FOLLOWED = "Followed";

    public SQLAdapter(Context c)
    {
        super(c, "Users.db", null, 21);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlcreate = "CREATE TABLE Users (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, DESCRIPTION TEXT, FOLLOWED TEXT)";
        db.execSQL(sqlcreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void addUser(user user)
    {
        ContentValues values = insertUser(user);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USERS, null,values);
        db.close();

    }

    @NonNull
    private ContentValues insertUser(user user)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_DESCRIPTION, user.getDesc());
        values.put(COLUMN_FOLLOWED, user.getFollowStatus());
        return values;
    }

    public ArrayList<user> getUsers() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<user> user1 = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);


        while (cursor.moveToNext()) {
            user user = new user();
            user.id = cursor.getInt(0);
            user.name = cursor.getString(1);
            user.description = cursor.getString(2);
            user.followed = (cursor.getInt(3) == 1);

            user1.add(user);
        }

        cursor.close();

        return user1;
    }

    public void updateUser(user user) {
        String UPDATE = "UPDATE USERS SET Followed = \"" + ((user.followed)?1:0)  + "\" WHERE ID = \"" + user.id + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(UPDATE);
        db.close();
    }



}
