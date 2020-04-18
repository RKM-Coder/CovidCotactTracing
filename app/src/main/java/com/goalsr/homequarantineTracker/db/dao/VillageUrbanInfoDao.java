package com.goalsr.homequarantineTracker.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistricDB;
import com.goalsr.homequarantineTracker.resposemodel.VillageModel;

import java.util.List;

@Dao
public interface VillageUrbanInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<VillageModel> ndhColorList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(VillageModel item);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateItem(VillageModel item);
    @Query("SELECT * from table_village ")
    List<VillageModel> getListOfDistrict();

  /*  @Query("SELECT * from table_village wher GROUP BY villageName order by dist_name ASC")
    List<VillageModel> getListOfDistrict();

    @Query("SELECT * from table_village GROUP BY dist_name order by dist_name ASC")
    LiveData<List<VillageModel>> getListOfDistrictLivedata();*/

    @Query("SELECT * from table_village where panchayatCode =:districtid GROUP BY villageName order by villageName ASC")
    List<VillageModel> getListOfVilageByPID(String districtid);

    /*@Query("SELECT * from table_village where ksrsac_town_code =:townid")
    List<VillageModel> getListOfWord(String townid);*/

    /*@Query("SELECT * from patient_info  where name not null order by Name ASC")
    List<ResStaticMasterDistricDB> getListAllItemByAdmin();

    @Query("SELECT * from patient_info where name not null order by Name ASC")
    LiveData<List<ResStaticMasterDistricDB>> getListAllItemByAdminLivedata();*/



    //Clear DB DATA
    @Query("DELETE FROM table_mater_address_urban")
    public void clearTable();
    //Clear perticular raw
   /* @Query("DELETE FROM table_mater_address_urban")
    public void clearTableByid(String id);*/
}
