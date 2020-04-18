package com.goalsr.homequarantineTracker.db.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.goalsr.homequarantineTracker.db.YellligoRoomDatabase;
import com.goalsr.homequarantineTracker.db.dao.VillageUrbanInfoDao;
import com.goalsr.homequarantineTracker.resposemodel.VillageModel;
import com.goalsr.homequarantineTracker.resposemodel.VillageModel;

import java.util.List;

public class VillageinfoRepository {

    private VillageUrbanInfoDao mDao;
    private LiveData<List<VillageModel>> mListLiveData;
//    private List<QHTracker> mList;

    public VillageinfoRepository(Application application) {
        YellligoRoomDatabase db = YellligoRoomDatabase.getDataBase(application);
        this.mDao = db.villageUrbanInfoDaoDao();
        //mListLiveData = mDao.getListOfDistrictLivedata();
    }
    public VillageinfoRepository(Context application) {
        YellligoRoomDatabase db = YellligoRoomDatabase.getDataBase(application);
        this.mDao = db.villageUrbanInfoDaoDao();
        //mListLiveData = mDao.getListOfDistrictLivedata();
    }

    public void insert(List<VillageModel> value) {

       new InsertAsynctaskList(mDao, value).execute();
        // mDao.insertItem(value);
    }

    public void insert(VillageModel value) {

        new InsertAsynctask(mDao, value).execute();
        // mDao.insertItem(value);
    }

    

    public List<VillageModel> getListAllItemByAdmin(){
        return mDao.getListOfDistrict();
    }
    public List<VillageModel> getListAllItemByDistId(String id){
        return mDao.getListOfVilageByPID(id);
    }
    /*public List<VillageModel> getListAllWordItemByTownId(String disid){
        return mDao.getListOfWord(disid);
    }
*/
    /*public LiveData<List<VillageModel>> getListDistLivedata(){
        return mListLiveData;
    }*/

   /* public List<String> getTravelListNonSyncImage(){
        return mDao.getListAllItemNonSyncImage(false);
    }*/

    public void update(VillageModel value) {

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

   /* public VillageModel getItem(String checkinid) {

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
        VillageModel value;
        VillageUrbanInfoDao mDao;

        public InsertAsynctask(VillageUrbanInfoDao mDao, VillageModel value) {
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
        List<VillageModel> value;
        VillageUrbanInfoDao mDao;

        public InsertAsynctaskList(VillageUrbanInfoDao mDao, List<VillageModel> value) {
            this.value = value;
            this.mDao = mDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (VillageModel item : value) {
                mDao.insertItem(item);
            }

            return null;
        }
    }

    private class UpdateAsynctask extends AsyncTask<Void, Void, Void> {
        VillageModel value;
        VillageUrbanInfoDao mDao;

        public UpdateAsynctask(VillageUrbanInfoDao mDao, VillageModel value) {
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

        VillageUrbanInfoDao mDao;
        boolean status;
        String id;
        String today;

        public UpdateAsynctask2(VillageUrbanInfoDao mDao, boolean status, String id) {
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

        VillageUrbanInfoDao mDao;
        boolean status;
        String filename;
        String today;

        public UpdateAsynctaskimgestatus(VillageUrbanInfoDao mDao, boolean status, String filename) {
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
