package com.goalsr.homequarantineTracker.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goalsr.homequarantineTracker.R;
import com.goalsr.homequarantineTracker.adapter.AdressGenericListAdapter;
import com.goalsr.homequarantineTracker.adapter.DistrictListAdapter;
import com.goalsr.homequarantineTracker.adapter.DistrictRuralListAdapter;
import com.goalsr.homequarantineTracker.apiservice.NetworkService;
import com.goalsr.homequarantineTracker.base.BaseActivity;
import com.goalsr.homequarantineTracker.resposemodel.DistrictModel;
import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistricDB;
import com.goalsr.homequarantineTracker.view.edittext.CustomEditText;
import com.goalsr.homequarantineTracker.view.edittext.DrawableClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.RES_DIST;
import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.RES_TOWN;
import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.RES_WORD;
import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.selectaretype;

//import com.amitshekhar.DebugDB;

public class RuralDistGenericListActivity extends BaseActivity implements DistrictRuralListAdapter.OnClickMainView {

    @BindView(R.id.tv_header_fac)
    TextView tvHeaderFac;
    @BindView(R.id.iv_back_fac)
    ImageButton ivBackFac;
    @BindView(R.id.tv_logout)
    TextView tvLogout;
    @BindView(R.id.toolbar_fac)
    Toolbar toolbarFac;
    @BindView(R.id.divider)
    View divider;
    @BindView(R.id.et_searchview)
    CustomEditText etSearchview;
    @BindView(R.id.img_calender)
    ImageView imgCalender;
    @BindView(R.id.search_layout)
    LinearLayout searchLayout;
    @BindView(R.id.rv_view_famillly)
    RecyclerView rvViewFamillly;
    private ArrayList<DistrictModel> listOFdistrict;
    private DistrictRuralListAdapter adapter;
    private NetworkService networkService;
    private String key;
    private String key_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_list);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            key = bundle.getString("key");
            key_id = bundle.getString("key_id");
        }


        initMvp();
        initrecyclerView();
        getDistrict();
       // Log.e("DBaddress", DebugDB.getAddressLog());
        etSearchview.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        etSearchview.setDrawableClickListener(new DrawableClickListener() {
            @Override
            public void onClick(DrawablePosition target) {
                switch (target) {
                    case RIGHT:
                        etSearchview.setText("");
                        break;

                    default:
                        break;
                }
            }
        });
    }

    private void initrecyclerView() {
        adapter = new DistrictRuralListAdapter(this, new ArrayList<DistrictModel>());
        adapter.setOnclickListener(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvViewFamillly.setLayoutManager(manager);
        rvViewFamillly.setAdapter(adapter);
    }


    private void getDistrict() {
       /* String jsonFileString = getCommonApi().getJsonFromAssets(getApplicationContext(), "District.json");
        Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<ResStaticMasterDistricDB>>() {
        }.getType();
        listOFdistrict = new ArrayList<>();
        listOFdistrict = gson.fromJson(jsonFileString, listUserType);
        *//*ResStaticMasterDistricDB item = new ResStaticMasterDistricDB();
        item.setDISTRICT_NAME(" Select District");
        item.setDistrict_code(-1);
        listOFdistrict.add(0, item);*//*
        Collections.sort(listOFdistrict, new Comparator<ResStaticMasterDistricDB>() {
            @Override
            public int compare(ResStaticMasterDistricDB s1, ResStaticMasterDistricDB s2) {
                return s1.getDISTRICT_NAME().compareTo(s2.getDISTRICT_NAME());
            }
        });*/

        if (key.equalsIgnoreCase("dist")) {
            String jsonFileString = getCommonApi().getJsonFromAssets(getApplicationContext(), "District.json");
            Log.i("data", jsonFileString);

            Gson gson = new Gson();
            Type listUserType = new TypeToken<List<DistrictModel>>() {
            }.getType();
            listOFdistrict = new ArrayList<>();
            listOFdistrict = gson.fromJson(jsonFileString, listUserType);
        /*DistrictModel item = new DistrictModel();
        item.setDISTRICT_NAME(" Select District");
        item.setDistrict_code(-1);
        listOFdistrict.add(0, item);*/
            Collections.sort(listOFdistrict, new Comparator<DistrictModel>() {
                @Override
                public int compare(DistrictModel s1, DistrictModel s2) {
                    return s1.getDISTRICT_NAME().compareTo(s2.getDISTRICT_NAME());
                }
            });
            tvHeaderFac.setText("List Of District");
            adapter.addall(listOFdistrict);
            adapter.setType("dist");

        }else if (key.equalsIgnoreCase("town")) {
            tvHeaderFac.setText("List Of Town/City");
           // adapter.addall((ArrayList<DistrictModel>) getAddressUrbaninfoRepository().getListAllItemByDistId(key_id));
            adapter.setType("town");

        }else if (key.equalsIgnoreCase("ward")) {
            tvHeaderFac.setText("List Of Ward");
           // adapter.addall((ArrayList<DistrictModel>) getAddressUrbaninfoRepository().getListAllWordItemByTownId(key_id));
            adapter.setType("ward");
        }
        //makeSpinnerDistrictMethod((ArrayList<ResStaticMasterDistricDB>) listOFdistrict);


    }

    private void initMvp() {
        networkService = new NetworkService();
        networkService.inject(RuralDistGenericListActivity.this);
    }



    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {

    }

    @Override
    public void onClickMain(int position, DistrictModel item) {
        hideSoftKeyboard(RuralDistGenericListActivity.this);
        Intent intent = new Intent();
        if (key.equalsIgnoreCase("dist")) {
            String message = item.getDISTRICT_NAME();
            intent.putExtra("name", message);

            intent.putExtra("name_id",""+ item.getDistrict_code());
            setResult(RES_DIST, intent);
        }else if (key.equalsIgnoreCase("town")) {
          /*  String message = item.getTown_name();
            intent.putExtra("name", message);
            intent.putExtra("name_id", item.getKsrsac_town_code());
            setResult(RES_TOWN, intent);*/
        }else if (key.equalsIgnoreCase("ward")) {
           /* String message = item.getWord_name();
            intent.putExtra("name", message);
            intent.putExtra("name_id", item.getKsrac_word_code());
            setResult(RES_WORD, intent);*/
        }
        finish();//finishing activity
        /*getPatientinfoRepository().clear();

        PreferenceStore.getPrefernceHelperInstace().setIntValue(YelligoApplication.getContext(),PreferenceStore.DISTRICT_ID,item.getDistrict_code());
        PreferenceStore.getPrefernceHelperInstace().setString(YelligoApplication.getContext(),PreferenceStore.DISTRICT_NAME,item.getDISTRICT_NAME());
        if (getCommonApi().isInternetAvailable(AddressGenericListActivity.this)){
            getPatientInfo();
        }else {
            Toast.makeText(YelligoApplication.getContext(),"Please enable internet connection",Toast.LENGTH_LONG).show();
        }*/


    }

    public static void hideSoftKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (activity.getCurrentFocus() != null && inputManager != null) {
                inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
                inputManager.hideSoftInputFromInputMethod(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    @Override
    public void onBackPressed() {
        hideSoftKeyboard(RuralDistGenericListActivity.this);
        Intent intent = new Intent();
        if (key.equalsIgnoreCase("dist")) {
            String message = "";
            intent.putExtra("name", message);
            intent.putExtra("name_id", "");
            setResult(RES_DIST, intent);
        }else if (key.equalsIgnoreCase("town")) {
            String message = "";
            intent.putExtra("name", message);
            intent.putExtra("name_id", "");
            setResult(RES_TOWN, intent);
        }else if (key.equalsIgnoreCase("ward")) {
            String message = "";
            intent.putExtra("name", message);
            intent.putExtra("name_id", "");
            setResult(RES_WORD, intent);
        }
       // finish();
        super.onBackPressed();
    }
}
