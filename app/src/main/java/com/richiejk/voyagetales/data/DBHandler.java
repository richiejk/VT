package com.richiejk.voyagetales.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.richiejk.voyagetales.common.Finals;

/**
 * Created by richie on 1/16/14.
 */
public class DBHandler {

    SQLiteHelper helper;
    Context context;
    SQLiteDatabase db;
    int userId;


    public DBHandler(Context context) {
        this.context = context;
        this.helper=new SQLiteHelper(context, Finals.DATABASE_NAME,null, Finals.DB_VERSION);
        this.db=this.helper.getWritableDatabase();
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
            String selectQuery = "CREATE  TABLE \"tbl_jobs\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"job_id\" TEXT, \"user_id\" INTEGER, \"job_name\" TEXT, \"survey_id\" TEXT, \"status\" INTEGER DEFAULT 0, \"status_msg\" TEXT , \"questions\" TEXT, \"sync_status\" INTEGER DEFAULT 0)";

            //"CREATE  TABLE \"tbl_jobs\" (\"id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"job_id\" TEXT, \"job_name\" TEXT, \"survey_id\" TEXT, \"status\" INTEGER DEFAULT 0, \"status_msg\" TEXT , \"questions\" TEXT, \"sync_status\" INTEGER DEFAULT 1)";
            //"VARCHAR NOT NULL , \"subcategoryName\" VARCHAR NOT NULL , \"title\" VARCHAR NOT NULL , \"itemType\" INTEGER NOT NULL  DEFAULT 0, \"content\" TEXT NOT NULL , \"images\" TEXT, \"status\" INTEGER NOT NULL  DEFAULT 1, \"keywords\" TEXT NOT NULL  )";
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