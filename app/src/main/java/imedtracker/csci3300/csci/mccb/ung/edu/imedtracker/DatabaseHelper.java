package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "iMedTrackerDB";

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Table Names
    private static final String TABLE_USER = "user";
    private static final String TABLE_MED = "med";

    //  create  Tables for User
    private static final String CREATE_TABLE_USER = "CREATE TABLE "  + TABLE_USER+ " (USERID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, EMAIL TEXT, PASSWORD TEXT)";
    private static final String CREATE_TABLE_MED = "CREATE TABLE "  + TABLE_MED+ " (MEDID INTEGER PRIMARY KEY AUTOINCREMENT, MEDNAME TEXT, DOSECOUNT INT, DOESFREQUENCY INT)";

    // Link by Username

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // creating required tables
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(CREATE_TABLE_MED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MED);
        // create new tables
        onCreate(sqLiteDatabase);
    }

    // USER TABLE METHODS //

    public String getSecurePassword(String passwordToHash, String messageSalt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(messageSalt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public boolean insertUser(UserModel user) {
        String password;
        password= getSecurePassword(user.getPassword(),    "iMedTracker");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FIRSTNAME", user.getFirstName());
        values.put("LASTNAME", user.getLastName());
        values.put("EMAIL", user.getEmail());
        values.put("PASSWORD", password);
        long result  = db.insert(TABLE_USER, null, values );
        if(result == -1)
            return false;
        else

            return true;
    }

    public Boolean getLoginInfo(UserModel user) {
        SQLiteDatabase db = this.getReadableDatabase();
        String password;
        password= getSecurePassword(user.getPassword(),    "iMedTracker");
        String query = "Select EMAIL, PASSWORD FROM " + TABLE_USER + " WHERE EMAIL = '"+user.getEmail() +"' AND PASSWORD= '"+password+"'";
        Cursor resultSet = db.rawQuery(query, null);
        if(resultSet.getCount()== 0)
            return false;
        else
            return true;
    }

    // MED TABLE METHODS //

    public boolean insertMed(MedModel med) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MEDNAME", med.getMedName());
        values.put("DOSECOUNT", med.getDoseCount());
        values.put("DOSEFREQUENCY", med.getDoseFrequency());
        long result = db.insert(TABLE_MED, null, values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Boolean getMedInfo(MedModel med) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select MEDNAME, DOSECOUNT, DOSEFREQUENCY FROM " + TABLE_MED + " WHERE MEDNAME = '"+med.getMedName()+"'";
        Cursor resultSet = db.rawQuery(query, null);
        if(resultSet.getCount()== 0)
            return false;
        else
            return true;
        //resultSet.close();
    }

    public List<MedModel> getAllMeds() {
        List<MedModel> medList = new ArrayList<MedModel>();
        String selectQuery = "SELECT  * FROM " + TABLE_MED;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultSet = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (resultSet.moveToFirst()) {
            do {
                MedModel med = new MedModel();
                med.setMedId((resultSet.getInt(resultSet.getColumnIndex("MEDID"))));
                med.setMedName((resultSet.getString(resultSet.getColumnIndex("MEDNAME"))));
                med.setDoseCount((resultSet.getInt(resultSet.getColumnIndex("DOSECOUNT"))));
                med.setDoseFrequency((resultSet.getInt(resultSet.getColumnIndex("DOSEFREQUENCY"))));
                // adding to med list
                medList.add(med);
            } while (resultSet.moveToNext());
        }

        return medList;
    }
}