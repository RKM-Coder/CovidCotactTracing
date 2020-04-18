package com.goalsr.homequarantineTracker.db.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.goalsr.homequarantineTracker.db.repository.AddressUrbaninfoRepository;
import com.goalsr.homequarantineTracker.db.repository.PatientinfoRepository;
import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistricDB;
import com.goalsr.homequarantineTracker.resposemodel.getPatientinfo.ResPatientInfo;

import java.util.List;

public class AddressUrbanViewmodel extends AndroidViewModel {
    private AddressUrbaninfoRepository patientinfoRepository;
    private LiveData<List<ResStaticMasterDistricDB>> liveData;
    public AddressUrbanViewmodel(@NonNull Application application) {
        super(application);
        patientinfoRepository=new AddressUrbaninfoRepository(application);
        liveData=patientinfoRepository.getListDistLivedata();

    }

    public LiveData<List<ResStaticMasterDistricDB>> getListOfDistLivedata(){
        return liveData;
    }
}
