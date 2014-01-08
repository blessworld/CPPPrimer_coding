package com.eptal.wyn_android.dao.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

     private static final String NAME = "wyn_android.db";
     private static final Integer version = 3;

     public DatabaseHelper(Context context) {
          super(context, NAME, null, version);
     }

     public DatabaseHelper(Context context, String name, CursorFactory factory,
               int version) {
          super(context, name, factory, version);
          // TODO Auto-generated constructor stub
     }

     @Override
     public void onCreate(SQLiteDatabase db) {
          // TODO Auto-generated method stub

          //用户表
          String accountSql = "create table account(AccountID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "AccountName VARCHAR(18),"
                    + "Password VARCHAR(40),"
                    + "AccountRoleID INTEGER,"
                    + "UserID INTEGER)";
          db.execSQL(accountSql);
         
          //质检任务表
          String qualitychecktaskSql = "create table qualitychecktask(QualityCheckTaskID INTEGER PRIMARY KEY,"
                    + "HotelCode INTEGER,"
                    + "QualityStandardID INTEGER,"
                    + "StdPackageId INTEGER"
                    + "IsFinished INTEGER"
                    + "DeadlineTime DATETIME"
                    + "CompleteTime DATETIME"
                    + "QualityResID INTEGER"
                    + "UpdateDate DATETIME)";
          db.execSQL(qualitychecktaskSql);

          //质检标准包表
          String standard_packageSql = "create table standard_package(StdPackageId INTEGER PRIMARY KEY,"
                    + "PackageName VARCHAR(10),"
                    + "PackageDes TEXT(100),"
                    + "PackageType INTEGER,"
                    + "InsertBy INTEGER"
                    + "InsertDate DATETIME"
                    + "UpdateDate DATETIME)";
          db.execSQL(standard_packageSql);
         
          //质检标准表
          String qualitystandardSql = "create table qualitystandard(QualityStandardID INTEGER PRIMARY KEY,"
                    + "Deleted BIT,"
                    + "StandardName VARCHAR(50),"
                    + "StandardType INTEGER,"
                    + "StandardDescribe VARCHAR(100)," 
                    + "InsertBy INTEGER"
                    + "InsertDate DATETIME"
                    + "UpdateDate DATETIME)";
          db.execSQL(qualitystandardSql);
         
          //得分制打分表
          String getscoreSql = "create table getscore(QualityStandardID INTEGER PRIMARY KEY,"
                    + "Xuhao INTEGER,"
                    + "Jianchadian VARCHAR(10),"
                    + "Fenzhi DOUBLE,"
                    + "Quanzhong INTEGER,"
                    + "Defen INTEGER"
                    + "Tupian VARCHAR(100)"
                    + "Beizhu VARCHAR(100))";
          db.execSQL(getscoreSql);
         
          //质检结果表
          String qualitycheckresSql = "create table qualitycheckres(QualityCheckResID INTEGER PRIMARY KEY,"
                    + "Deleted BIT,"
                    + "AnswerBy INTEGER,"
                    + "CheckBy INTEGER,"
                    + "AnswerDate DATETIME,"
                    + "RoomCode INTEGER,"
                    + "HotelCode INTEGER,"
                    + "QualityStandardID INTEGER,"
                    + "UpdateDate DATETIME)";
          db.execSQL(qualitycheckresSql);
     }

     @Override
     public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
          // TODO Auto-generated method stub
          if (arg1 == 2 && arg2 == 3) {
//               String addTrueName = "alter table message add trueName text";
//               db.execSQL(addTrueName);
          }

     }
}
