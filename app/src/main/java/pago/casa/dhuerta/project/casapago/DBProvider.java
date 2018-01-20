package pago.casa.dhuerta.project.casapago;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by dhuerta on 13/01/2018.
 */

public class DBProvider {
    private DBHelper oDB;
    private SQLiteDatabase db;

    public DBProvider(Context context)
    {
        oDB=new DBHelper(context);
    }

    public long executeSQL(String sql, Object[] bindArgs)
    {
        long iRet = 0;
        db = oDB.getReadableDatabase();
        db.execSQL(sql, bindArgs);
        CloseDB();

        return (iRet);
    }

    public Cursor querySQL(String sql, String[] selectionArgs)
    {
        Cursor oRet = null;
        db = oDB.getReadableDatabase();
        oRet = db.rawQuery(sql, selectionArgs);

        return (oRet);
    }

    public void CloseDB()
    {
        if(db.isOpen())
        {
            db.close();
        }
    }

    public boolean OpenDB()
    {
        return (db.isOpen());
    }

    public class DBHelper extends SQLiteOpenHelper {

        public static final String TAG ="DBManager";
        public static final String DATABASE_NAME ="casapagofvv.db";
        public static final int DATABASE_VERSION = 1;

        DBHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.v(TAG, "Actualizacion de bd por la version" + oldVersion + " a la " +newVersion +
                    "de la que se destruira la informacion anterior");

            //db.execSQL("DROP TABLE IF EXISTS " + DBHelper.TABLE_LOGIN);
            onCreate(db);
        }
    }
}
