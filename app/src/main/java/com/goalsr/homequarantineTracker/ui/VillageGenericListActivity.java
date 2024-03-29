package com.goalsr.homequarantineTracker.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.goalsr.homequarantineTracker.adapter.VillageGenericListAdapter;
import com.goalsr.homequarantineTracker.apiservice.NetworkService;
import com.goalsr.homequarantineTracker.base.BaseActivity;
import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistricDB;
import com.goalsr.homequarantineTracker.resposemodel.VillageModel;
import com.goalsr.homequarantineTracker.view.edittext.CustomEditText;
import com.goalsr.homequarantineTracker.view.edittext.DrawableClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.RES_DIST;
import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.RES_TOWN;
import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.RES_VILLAGE;
import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.RES_WORD;
import static com.goalsr.homequarantineTracker.ui.AddnewPatientActivity.selectaretype;

//import com.amitshekhar.DebugDB;

public class VillageGenericListActivity extends BaseActivity implements VillageGenericListAdapter.OnClickMainView {

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
    private ArrayList<ResStaticMasterDistricDB> listOFdistrict;
    private VillageGenericListAdapter adapter;
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
        adapter = new VillageGenericListAdapter(this, new ArrayList<VillageModel>());
        adapter.setOnclickListener(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvViewFamillly.setLayoutManager(manager);
        rvViewFamillly.setAdapter(adapter);
    }


    private void getDistrict() {

        tvHeaderFac.setText("List Of Village");
        adapter.addall((ArrayList<VillageModel>) getVillageinfoRepository().getListAllItemByDistId(key_id));
        //adapter.setType("dist");
       /* if (key.equalsIgnoreCase("dist")) {
            tvHeaderFac.setText("List Of District");
            adapter.addall((ArrayList<ResStaticMasterDistricDB>) getAddressUrbaninfoRepository().getListAllItemByAdmin());
            adapter.setType("dist");

        }else if (key.equalsIgnoreCase("town")) {
            tvHeaderFac.setText("List Of Town/City");
            adapter.addall((ArrayList<ResStaticMasterDistricDB>) getAddressUrbaninfoRepository().getListAllItemByDistId(key_id));
            adapter.setType("town");

        }else if (key.equalsIgnoreCase("ward")) {
            tvHeaderFac.setText("List Of Ward");
            adapter.addall((ArrayList<ResStaticMasterDistricDB>) getAddressUrbaninfoRepository().getListAllWordItemByTownId(key_id));
            adapter.setType("ward");
        }*/


    }

    private void initMvp() {
        networkService = new NetworkService();
        networkService.inject(VillageGenericListActivity.this);
    }



    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {

    }

    @Override
    public void onClickMain(int position, VillageModel item) {
        hideSoftKeyboard(VillageGenericListActivity.this);
        Intent intent = new Intent();
        String message = item.getVillageName();
        intent.putExtra("name", message);
        intent.putExtra("name_id", item.getVillageCode());
        setResult(RES_VILLAGE, intent);
       /* if (key.equalsIgnoreCase("dist")) {
            String message = item.getDist_name();
            intent.putExtra("name", message);
            if (selectaretype==1) {
                intent.putExtra("name_id", item.getKsrsac_dist_code());
            }else if (selectaretype==2) {
                intent.putExtra("name_id", item.getRdrp_dist_code());
            }
            setResult(RES_DIST, intent);
        }else if (key.equalsIgnoreCase("town")) {
            String message = item.getTown_name();
            intent.putExtra("name", message);
            intent.putExtra("name_id", item.getKsrsac_town_code());
            setResult(RES_TOWN, intent);
        }else if (key.equalsIgnoreCase("ward")) {
            String message = item.getWord_name();
            intent.putExtra("name", message);
            intent.putExtra("name_id", item.getKsrac_word_code());
            setResult(RES_WORD, intent);
        }*/
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
        hideSoftKeyboard(VillageGenericListActivity.this);
        Intent intent = new Intent();
        String message = "";
        intent.putExtra("name", message);
        intent.putExtra("name_id", "");
        setResult(RES_VILLAGE, intent);
       // finish();
        super.onBackPressed();
    }
}
