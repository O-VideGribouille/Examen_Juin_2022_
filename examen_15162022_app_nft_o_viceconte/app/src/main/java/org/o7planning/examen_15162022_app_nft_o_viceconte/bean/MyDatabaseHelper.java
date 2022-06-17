package org.o7planning.examen_15162022_app_nft_o_viceconte.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Game_Element";

    // Table name: User.
    private static final String TABLE_USER = "T_User";

    private static final String COLUMN_USER_ID ="User_Id";
    private static final String COLUMN_USER_NAME ="User_Name";
    private static final String COLUMN_USER_MP = "User_MP";
    private static final String COLUMN_USER_NB_TICKET = "User_Nb_Ticket";

    // Table name: Cat.
    private static final String TABLE_CAT = "T_Cat";

    private static final String COLUMN_CAT_ID ="Cat_Id";
    private static final String COLUMN_CAT_NAME ="Cat_Name";
    private static final String COLUMN_CAT_PRC_EUR = "Cat_Price_eur";
    private static final String COLUMN_CAT_PRC_ET = "Cat_Price_et";
    private static final String COLUMN_CAT_PRC_BTC = "Cat_Price_btc";
    private static final String COLUMN_CAT_NB_IMG = "Cat_Nb_Image";
    private static final String COLUMN_CAT_VALUE = "Cat_Value";
    private static final String COLUMN_CAT_ADOPT = "Cat_Adopt";


    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate OK ");
        // Script USER
        String scriptU = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_MP + " TEXT,"
                + COLUMN_USER_NB_TICKET + " INTEGER" + ")";

        //Script Cat
        String scriptC = "CREATE TABLE " + TABLE_CAT + "("
                + COLUMN_CAT_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_CAT_NAME + " TEXT,"
                + COLUMN_CAT_PRC_EUR + " REAL,"
                + COLUMN_CAT_PRC_ET + " REAL,"
                + COLUMN_CAT_PRC_BTC + " REAL,"
                + COLUMN_CAT_NB_IMG + " INTEGER,"
                + COLUMN_CAT_VALUE + " INTEGER,"
                + COLUMN_CAT_ADOPT + " INTEGER" + ")";


        // Execute Script.
        db.execSQL(scriptU);
        db.execSQL(scriptC);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "MyDatabaseHelper.onUpgrade Up! ");
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAT);

        // Create tables again
        onCreate(db);
    }


    // Si le tableau est vide
    // ajout valeur par défaut
    public void createDefaultUserIfNeed()  {
        int count = this.getUsersCount();
        if(count ==0 ){
            //USER
            User user1 = new User(1,"Egerie","a111", 1);
            User user2 = new User(2,"Lamentin68", "b222", 0);
            User user3 = new User(3,"Merlin", "c333", 10);
            this.addUser(user1);
            this.addUser(user2);
            this.addUser(user3);

            //CAT
        /*    NFT_Cat cat1 = new NFT_Cat("Botté",0,0,0, 1, 1, false);
            NFT_Cat cat2 = new NFT_Cat("Rominagrobis", 0,0,0, 2, 1, false);
            NFT_Cat cat3 = new NFT_Cat("Saha", 0,0,0, 3, 1, false);
            NFT_Cat cat4 = new NFT_Cat("Arsene", 0,0,0, 4, 4, false);
            NFT_Cat cat5 = new NFT_Cat("Dina", 0,0,0, 5, 5, false);
            this.addCat(cat1);
            this.addCat(cat2);
            this.addCat(cat3);
            this.addCat(cat4);
            this.addCat(cat5);*/
        }
    }
    //USER
    public void addUser(User user) {
        Log.i(TAG, "MyDatabaseHelper.addUser ... " + user.getUserName());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, user.getUserId());
        values.put(COLUMN_USER_NAME, user.getUserName());
        values.put(COLUMN_USER_MP, user.getUserMP());
        values.put(COLUMN_USER_NB_TICKET, user.getUserNbTicket() );

        // Inserting Row
        db.insert(TABLE_USER, null, values);

        // Closing database connection
        db.close();
    }
    //CAT
    public void addCat(NFT_Cat cat) {
        Log.i(TAG, "MyDatabaseHelper.addCat ... " + cat.getCatName());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CAT_NAME, cat.getCatName());
        values.put(COLUMN_CAT_PRC_EUR, cat.getCatPrice_Eur());
        values.put(COLUMN_CAT_PRC_ET, cat.getCatPrice_Et());
        values.put(COLUMN_CAT_PRC_BTC, cat.getCatPrice_BTC());
        values.put(COLUMN_CAT_VALUE, cat.getCatValue() );
        values.put(COLUMN_CAT_NB_IMG, cat.getCatNbimage() );
        values.put(COLUMN_CAT_ADOPT, cat.getCatAdopt() );

        // Inserting Row
        db.insert(TABLE_CAT, null, values);

        // Closing database connection
        db.close();
    }
    //USER
    public User getUser(int id) {
        Log.i(TAG, "MyDatabaseHelper.getUser ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[] { COLUMN_USER_ID,
                        COLUMN_USER_NAME, COLUMN_USER_MP, COLUMN_USER_NB_TICKET }, COLUMN_USER_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));
        // return user
        return user;
    }
    //CAT
    public NFT_Cat getCat(int id) {
        Log.i(TAG, "MyDatabaseHelper.getCat ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CAT, new String[] { COLUMN_CAT_ID,
                        COLUMN_CAT_NAME, COLUMN_CAT_PRC_EUR, COLUMN_CAT_PRC_ET, COLUMN_CAT_PRC_BTC, COLUMN_CAT_VALUE, COLUMN_CAT_NB_IMG, COLUMN_CAT_ADOPT }, COLUMN_CAT_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        NFT_Cat cat = new NFT_Cat(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Double.parseDouble(cursor.getString(2)), Double.parseDouble(cursor.getString(3)), Double.parseDouble(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Boolean.parseBoolean(cursor.getString(7)));
        // return cat
        return cat;
    }

    //USER
    public List<User> getAllUsers() {
        Log.i(TAG, "MyDatabaseHelper.getAllUser ... " );

        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));
               // user.setUserId(Integer.parseInt(cursor.getString(0)));
               // user.setUserName(cursor.getString(1));
               // user.setUserMP(cursor.getString(2));
                // Adding user to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return user list
        return userList;
    }

    //Cat
    public List<NFT_Cat> getAllCats() {
        Log.i(TAG, "MyDatabaseHelper.getAllCat ... " );

        List<NFT_Cat> catList = new ArrayList<NFT_Cat>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CAT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                NFT_Cat cat = new NFT_Cat(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Double.parseDouble(cursor.getString(2)), Double.parseDouble(cursor.getString(3)), Double.parseDouble(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Boolean.parseBoolean(cursor.getString(7)));

                // Adding user to list
                catList.add(cat);
            } while (cursor.moveToNext());
        }

        // return cat list
        return catList;
    }

    //User
    public int getUsersCount() {
        Log.i(TAG, "MyDatabaseHelper.getUsersCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }

    //Cat
    public int getCatsCount() {
        Log.i(TAG, "MyDatabaseHelper.getCatsCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_CAT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }

    //User
    public int updateUser(User user) {
        Log.i(TAG, "MyDatabaseHelper.updateUser ... "  + user.getUserName());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUserName());
        values.put(COLUMN_USER_MP, user.getUserMP());

        // updating row
        return db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getUserId())});
    }

    //Cat
    public int updateCat(NFT_Cat cat) {
        Log.i(TAG, "MyDatabaseHelper.updateCat ... "  + cat.getCatName());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CAT_NAME, cat.getCatName());
        values.put(COLUMN_CAT_PRC_EUR, cat.getCatPrice_Eur());
        values.put(COLUMN_CAT_PRC_ET, cat.getCatPrice_Et());
        values.put(COLUMN_CAT_PRC_BTC, cat.getCatPrice_BTC());
        values.put(COLUMN_CAT_VALUE, cat.getCatValue());
        values.put(COLUMN_CAT_NB_IMG, cat.getCatNbimage());
        values.put(COLUMN_CAT_ADOPT, cat.getCatAdopt());

        // updating row
        return db.update(TABLE_CAT, values, COLUMN_CAT_ID + " = ?",
                new String[]{String.valueOf(cat.getCatId())});
    }


    //User
    public void deleteUser(User user) {
        Log.i(TAG, "MyDatabaseHelper.updateUser ... " + user.getUserName() );

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[] { String.valueOf(user.getUserId()) });
        db.close();
    }

    //Cat
    public void deleteCat(NFT_Cat cat) {
        Log.i(TAG, "MyDatabaseHelper.updateCat ... " + cat.getCatName() );

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CAT, COLUMN_CAT_ID + " = ?",
                new String[] { String.valueOf(cat.getCatId()) });
        db.close();
    }

}
