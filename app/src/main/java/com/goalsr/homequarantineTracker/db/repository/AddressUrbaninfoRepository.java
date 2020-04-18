package com.goalsr.homequarantineTracker.db.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.goalsr.homequarantineTracker.db.YellligoRoomDatabase;
import com.goalsr.homequarantineTracker.db.dao.AdresssUrbanInfoDao;
import com.goalsr.homequarantineTracker.db.dao.AdresssUrbanInfoDao;
import com.goalsr.homequarantineTracker.db.model.QHTracker;
import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistricDB;


import java.util.List;

public class AddressUrbaninfoRepository {

    private AdresssUrbanInfoDao mDao;
    private LiveData<List<ResStaticMasterDistricDB>> mListLiveData;
//    private List<QHTracker> mList;

    public AddressUrbaninfoRepository(Application application) {
        YellligoRoomDatabase db = YellligoRoomDatabase.getDataBase(application);
        this.mDao = db.adresssUrbanInfoDaoDao();
        mListLiveData = mDao.getListOfDistrictLivedata();
    }
    public AddressUrbaninfoRepository(Context application) {
        YellligoRoomDatabase db = YellligoRoomDatabase.getDataBase(application);
        this.mDao = db.adresssUrbanInfoDaoDao();
        mListLiveData = mDao.getListOfDistrictLivedata();
    }

    public void insert(List<ResStaticMasterDistricDB> value) {

       new InsertAsynctaskList(mDao, value).execute();
        // mDao.insertItem(value);
    }

    public void insert(ResStaticMasterDistricDB value) {

        new InsertAsynctask(mDao, value).execute();
        // mDao.insertItem(value);
    }

    

    public List<ResStaticMasterDistricDB> getListAllItemByAdmin(){
        return mDao.getListOfDistrict();
    }
    public List<ResStaticMasterDistricDB> getListAllItemByDistId(String id){
        return mDao.getListOfTown(id);
    }
    public List<ResStaticMasterDistricDB> getListAllWordItemByTownId(String disid){
        return mDao.getListOfWord(disid);
    }

    public LiveData<List<ResStaticMasterDistricDB>> getListDistLivedata(){
        return mListLiveData;
    }

   /* public List<String> getTravelListNonSyncImage(){
        return mDao.getListAllItemNonSyncImage(false);
    }*/

    public void update(ResStaticMasterDistricDB value) {

        new UpdateAsynctask(mDao, value).execute();
        // mDao.insertItem(value);
    }

   /* public void updatesyncdata(boolean status, String id) {

        new UpdateAsynctask2(mDao, status, id).execute();
        // mDao.insertItem(value);
    }*/

   /* public void updatesyncdataimagestatus(boolean status, String filename) {

        new UpdateAsynctaskimgestatus(mDao, status, filename).execute();
        // mDao.insertItem(value);
    }*/

   /* public ResStaticMasterDistricDB getItem(String checkinid) {

        return mDao.getItemById(checkinid);
    }*/

    public void clear() {
        mDao.clearTable();
    }

    public void clearbyID(String id) {
        mDao.clearTable();
    }



   /* public List<LocationTrackingModel> getAllItem(){

        return mDao.getListAll();
    }
    public List<LocationTrackingModel> getListAllTaskComplete(){

        return mDao.getListAllTaskComplete("3");
    }*/

    /*public LiveData<List<QHTracker>> getAllItemLivedata() {

        return mDao.getListAllItem();
    }*/

    private class InsertAsynctask extends AsyncTask<Void, Void, Void> {
        ResStaticMasterDistricDB value;
        AdresssUrbanInfoDao mDao;

        public InsertAsynctask(AdresssUrbanInfoDao mDao, ResStaticMasterDistricDB value) {
            this.value = value;
            this.mDao = mDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDao.insertItem(value);
            return null;
        }
    }

    private class InsertAsynctaskList extends AsyncTask<Void, Void, Void> {
        List<ResStaticMasterDistricDB> value;
        AdresssUrbanInfoDao mDao;

        public InsertAsynctaskList(AdresssUrbanInfoDao mDao, List<ResStaticMasterDistricDB> value) {
            this.value = value;
            this.mDao = mDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (ResStaticMasterDistricDB item : value) {
                mDao.insertItem(item);
            }

            return null;
        }
    }

    private class UpdateAsynctask extends AsyncTask<Void, Void, Void> {
        ResStaticMasterDistricDB value;
        AdresssUrbanInfoDao mDao;

        public UpdateAsynctask(AdresssUrbanInfoDao mDao, ResStaticMasterDistricDB value) {
            this.value = value;
            this.mDao = mDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            mDao.updateItem(value);
            return null;
        }
    }

    private class UpdateAsynctask2 extends AsyncTask<Void, Void, Void> {

        AdresssUrbanInfoDao mDao;
        boolean status;
        String id;
        String today;

        public UpdateAsynctask2(AdresssUrbanInfoDao mDao, boolean status, String id) {
            this.mDao = mDao;
            this.status = status;
            this.id = id;
            this.today = today;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            //mDao.update(status,id);
            return null;
        }
    }

    private class UpdateAsynctaskimgestatus extends AsyncTask<Void, Void, Void> {

        AdresssUrbanInfoDao mDao;
        boolean status;
        String filename;
        String today;

        public UpdateAsynctaskimgestatus(AdresssUrbanInfoDao mDao, boolean status, String filename) {
            this.mDao = mDao;
            this.status = status;
            this.filename = filename;
            this.today = today;
        }


        @Override
        protected Void doInBackground(Void... voids) {
           // mDao.updateimgestatus(status,filename);
            return null;
        }
    }
}
