package com.richiejk.voyagetales.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.models.UserModel;

import java.net.ContentHandler;

/**
 * Created by richie on 1/16/14.
 */
public class DBHandler {

    SQLiteHelper helper;
    Context context;
    SQLiteDatabase db;
    //int userId;

    public DBHandler(Context context) {
        this.context = context;
        this.helper=new SQLiteHelper(context, Finals.DATABASE_NAME,null, Finals.DB_VERSION);
        this.db=this.helper.getWritableDatabase();
    }

    static String TABLE_USER="tbl_user";
    static class TBL_USER{
        static String _ID="id";
        static String USER_ID="user_id";
        static String EMAIL_ID="email_id";
        static String USER_NAME="user_name";
        static String PROFILE_PICTURE="profile_picture";
        static String TRIPS_COUNT="trips_count";
        static String FRIENDS_COUNT="friends_count";
        static String MESSAGES_COUNT="messages_count";
        static String STATUS="status";
        static String TYPE="type";
    }


    public UserModel getUser(int user_id){
        Cursor cursor=null;
        UserModel response=null;
        String QUERY="SELECT user_id, user_name, email_id, profile_picture, friends_count, messages_count, trips_count, status, type FROM "+TABLE_USER+" WHERE "+TBL_USER.USER_ID+" = "+user_id;
        cursor=db.rawQuery(QUERY,null);
        if(cursor.moveToFirst()){
            do{
                response=new UserModel( cursor.getInt(0),
                                        cursor.getString(1),
                                        cursor.getString(2),
                                        cursor.getString(3),
                                        cursor.getInt(4),
                                        cursor.getInt(5),
                                        cursor.getInt(6),
                                        cursor.getInt(7),
                                        cursor.getInt(8));
            }while (cursor.moveToNext());
        }
        return response;
    }


    public void insertUser(UserModel userModel){
        ContentValues cv= new ContentValues();
        cv.put(TBL_USER.EMAIL_ID,userModel.getEmail_id());
        cv.put(TBL_USER.FRIENDS_COUNT,userModel.getFriends_count());
        cv.put(TBL_USER.MESSAGES_COUNT,userModel.getMessages_count());
        cv.put(TBL_USER.PROFILE_PICTURE,userModel.getProfile_picture());
        cv.put(TBL_USER.STATUS,userModel.getStatus());
        cv.put(TBL_USER.TRIPS_COUNT,userModel.getTrips_count());
        cv.put(TBL_USER.TYPE,userModel.getType());
        cv.put(TBL_USER.USER_ID,userModel.getUser_id());
        cv.put(TBL_USER.USER_NAME,userModel.getUser_name());

        long rowId;

        // First try a blind update
        //       rowId = db.update(TBL_TASKS, cv, " task_id=? AND sync_status=?", new String[]{ taskModel.getTaskId()+"",Finals.SYNC_STATUS_SYNCED+"" });
        rowId = db.update(TABLE_USER, cv, " user_id=? ", new String[]{ userModel.getUser_id()+"" });

        // If no rows are affected, we can insert it as a new record.
        if(rowId == 0){
            rowId = db.insert(TABLE_USER, null, cv);
        }
    }
    /**
     * -----------------------------------------------------------------------
     */
    public class SQLiteHelper extends SQLiteOpenHelper {

        //Context context;
        public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Cursor cursor = null;
            String selectQuery = "CREATE  TABLE \"tbl_user\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"user_id\" INTEGER, \"user_name\" TEXT, \"email_id\" TEXT, \"profile_picture\" TEXT, \"status\" INTEGER DEFAULT 0, \"messages_count\" INTEGER DEFAULT 0 , \"friends_count\" INTEGER DEFAULT 0, \"trips_count\" INTEGER DEFAULT 0, \"type\" INTEGER DEFAULT 0)";
            sqLiteDatabase.execSQL(selectQuery);

/*            selectQuery ="CREATE  TABLE \"tbl_tasks\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"location_name\" TEXT NOT NULL , \"user_id\" INTEGER, \"task_id\" INTEGER NOT NULL , \"pincode\" TEXT, \"street_name\" TEXT, \"job_id\" INTEGER NOT NULL , \"unit\" TEXT, \"street_number\" TEXT, \"street_type\" TEXT, \"city\" TEXT, \"province\" TEXT, \"country\" TEXT, \"status\" INTEGER NOT NULL  DEFAULT 0, \"status_msg\" TEXT NOT NULL , \"visit_count\" INTEGER NOT NULL  DEFAULT 0, \"latitude\" TEXT NOT NULL , \"longitude\" TEXT NOT NULL , \"address\" TEXT, \"sync_status\" INTEGER NOT NULL  DEFAULT 3,\"answers\" TEXT,\"timestamp\" TEXT,\"override_flag\" TEXT NOT NULL,\"survey_id\" INTEGER NOT NULL,\"device_latitude\" TEXT,\"device_longitude\" TEXT)";
            sqLiteDatabase.execSQL(selectQuery);

            selectQuery ="CREATE  TABLE \"tbl_surveys\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"survey_name\" TEXT NOT NULL , \"survey_id\" INTEGER,  \"user_id\" INTEGER, \"status\" INTEGER NOT NULL  DEFAULT 0,\"sync_status\" INTEGER NOT NULL  DEFAULT 0)";
            sqLiteDatabase.execSQL(selectQuery);

            selectQuery ="CREATE  TABLE \"tbl_notifications\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"notification_name\" TEXT NOT NULL , \"log_id\" INTEGER,  \"user_id\" INTEGER,\"job_id\" INTEGER,\"site_id\" INTEGER,\"message\" TEXT, \"status\" INTEGER NOT NULL  DEFAULT 0,\"type\" INTEGER NOT NULL  DEFAULT 0,\"sync_status\" INTEGER NOT NULL  DEFAULT 0)";
            sqLiteDatabase.execSQL(selectQuery);*/

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        }
    }

}