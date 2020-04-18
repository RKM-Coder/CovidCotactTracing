package com.goalsr.homequarantineTracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goalsr.homequarantineTracker.R;
import com.goalsr.homequarantineTracker.Utils.AppConstants;
import com.goalsr.homequarantineTracker.Utils.PreferenceStore;
import com.goalsr.homequarantineTracker.YelligoApplication;
import com.goalsr.homequarantineTracker.adapter.SpinAdapter;
import com.goalsr.homequarantineTracker.adapter.SymptomListAdapter;
import com.goalsr.homequarantineTracker.base.BaseActivity;
import com.goalsr.homequarantineTracker.dialog.CustomDialogGeneric;
import com.goalsr.homequarantineTracker.fragment.DatePickerFragment;
import com.goalsr.homequarantineTracker.resposemodel.ModelSymptomGVT;
import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistric;
import com.goalsr.homequarantineTracker.resposemodel.ResStaticMasterDistricDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddnewPatientActivity extends BaseActivity implements SymptomListAdapter.CheckedListener, DatePickerFragment.OnFragmentInteractionListener {

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
    @BindView(R.id.et_customer_name)
    EditText etCustomerName;
    @BindView(R.id.sp_gender)
    Spinner spGender;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_customer_mobile)
    EditText etCustomerMobile;
    @BindView(R.id.et_customer_email)
    EditText etCustomerEmail;
    @BindView(R.id.txt_DOA)
    TextView txtDOA;
    @BindView(R.id.txt_qurantinedate)
    TextView txtQurantinedate;
    @BindView(R.id.et_poorigin)
    EditText etPoorigin;
    @BindView(R.id.et_poarrival)
    EditText etPoarrival;
    @BindView(R.id.sp_areatype)
    Spinner spAreatype;
    @BindView(R.id.et_houseno)
    EditText etHouseno;
    @BindView(R.id.et_building)
    EditText etBuilding;
    @BindView(R.id.et_street)
    EditText etStreet;

    @BindView(R.id.llurban)
    LinearLayout llurban;

    @BindView(R.id.ll_rural)
    LinearLayout llRural;
    /*@BindView(R.id.chk_box_txt1)
    TextView chkBoxTxt1;
    @BindView(R.id.chk_box1)
    CheckBox chkBox1;
    @BindView(R.id.chk_box_txt2)
    TextView chkBoxTxt2;
    @BindView(R.id.chk_box2)
    CheckBox chkBox2;
    @BindView(R.id.chk_box_txt3)
    TextView chkBoxTxt3;
    @BindView(R.id.chk_box3)
    CheckBox chkBox3;
    @BindView(R.id.chk_box_txt4)
    TextView chkBoxTxt4;
    @BindView(R.id.chk_box4)
    CheckBox chkBox4;
    @BindView(R.id.chk_box_txt5)
    TextView chkBoxTxt5;
    @BindView(R.id.chk_box5)
    CheckBox chkBox5;
    @BindView(R.id.chk_box_txt6)
    TextView chkBoxTxt6;
    @BindView(R.id.chk_box6)
    CheckBox chkBox6;
    @BindView(R.id.imageicon7)
    ImageView imageicon7;
    @BindView(R.id.chk_box_txt7)
    TextView chkBoxTxt7;
    @BindView(R.id.chk_box7)
    CheckBox chkBox7;
    @BindView(R.id.imageicon)
    ImageView imageicon;
    @BindView(R.id.chk_box_txt8)
    TextView chkBoxTxt8;*/
   /* @BindView(R.id.ll_chk)
    LinearLayout llChk;
    @BindView(R.id.chk_box8)
    CheckBox chkBox8;*/
    @BindView(R.id.submit_btn)
    Button submitBtn;
    @BindView(R.id.txt_104)
    TextView txt104;
    @BindView(R.id.txt_08046848600)
    TextView txt08046848600;
    @BindView(R.id.txt_9745697456)
    TextView txt9745697456;
    @BindView(R.id.txt_08066692000)
    TextView txt08066692000;
    @BindView(R.id.ll_call)
    LinearLayout llCall;
    @BindView(R.id.helptechnical)
    CardView helptechnical;
    @BindView(R.id.ll_lelp)
    LinearLayout llLelp;
    @BindView(R.id.helpcovid)
    CardView helpcovid;
    @BindView(R.id.activity_main_rl)
    RelativeLayout activityMainRl;
    ArrayList<ResStaticMasterDistric> listOfurbandata;


    @BindView(R.id.txt_dist_spin)
    TextView txtDistSpin;
    @BindView(R.id.lladdress)
    LinearLayout lladdress;
    @BindView(R.id.txt_city_spin)
    TextView txtCitySpin;
    @BindView(R.id.txt_word_spin)
    TextView txtWordSpin;
    @BindView(R.id.txt_taluk_spin)
    TextView txtTalukSpin;
    @BindView(R.id.txt_grampanchyate_spin)
    TextView txtGrampanchyateSpin;
    @BindView(R.id.txt_village_spin)
    TextView txtVillageSpin;
    @BindView(R.id.txt_startdate_heading)
    TextView txtStartdateHeading;
    @BindView(R.id.txt_end_heading)
    TextView txtEndHeading;
    @BindView(R.id.chk_box_txt11)
    TextView chkBoxTxt11;
    @BindView(R.id.chk_box12)
    CheckBox chkBox12;
    @BindView(R.id.chk_box_txt13)
    TextView chkBoxTxt13;
    @BindView(R.id.chk_box13)
    CheckBox chkBox13;
    @BindView(R.id.chk_box_txt14)
    TextView chkBoxTxt14;
    @BindView(R.id.chk_box14)
    CheckBox chkBox14;
    @BindView(R.id.txt_DOA11)
    TextView txtDOA11;
    @BindView(R.id.rv_view)
    RecyclerView rvView;

    private String selctedDistId = "-1";
    private String selctedCityId = "-1";
    private String selctedWordId = "-1";
    private String selctedpanchyateId = "-1";
    private String selctedvillageId = "-1";
    private String selctedtalukid = "-1";

    public static int RES_DIST = 5951;
    public static int RES_TOWN = 5952;
    public static int RES_WORD = 5953;
    public static int RES_TALUK = 5954;
    public static int RES_PANCHYATE = 5955;
    public static int RES_VILLAGE = 5956;

    private SymptomListAdapter adapter;
    private ArrayList<String> selectedString;

    String startdate = "", enddate = "",dateofsymtom = "", daovvalue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew_patient);
        ButterKnife.bind(this);

        //  Log.e("UUID", UUID.randomUUID().toString());
        Bundle bundle = getIntent().getExtras();
        tvHeaderFac.setText("Person Details");
        /*if (bundle != null) {
            if (bundle.getString("key").equalsIgnoreCase("self")) {
                tvHeaderFac.setText("Person Details");

            } else if (bundle.getString("key").equalsIgnoreCase("family")) {
                tvHeaderFac.setText("Family 1 Info");
                //getPatientFamilyByid();
            }
        }*/
        String areaytypearray[] = getResources().getStringArray(R.array.areatype);
        List<String> areatypelist = new ArrayList<>();
        areatypelist = new ArrayList<>(Arrays.asList(areaytypearray));
        makeSpinnerAreaType((ArrayList<String>) areatypelist);
        listOfurbandata = new ArrayList<>();

        initSymptomView();
        //listOfurbandata=getCommonApi().getDistrictUrban(getApplicationContext());

        // List<ResStaticMasterDistricDB> listOfurbandataDistrict=getAddressUrbaninfoRepository().getListAllItemByAdmin();


        getAddressUrbanViewmodel().getListOfDistLivedata().observe(this, new Observer<List<ResStaticMasterDistricDB>>() {
            @Override
            public void onChanged(List<ResStaticMasterDistricDB> listOfurbandataDistrict) {
                //makeSpinnerDistrictMethod((ArrayList<ResStaticMasterDistricDB>) listOfurbandataDistrict);
            }
        });

        if (!PreferenceStore.getPrefernceHelperInstace().getFlag(YelligoApplication.getContext(), PreferenceStore.PERSIONTYPE)) {

            txtStartdateHeading.setText("Start Date of Observation");
            txtEndHeading.setText("End Date of Observation");
        } else {
            txtStartdateHeading.setText("Start Date of Quarntine *");
            txtEndHeading.setText("End Date of Quarntine *");
        }


        String genderarray[] = getResources().getStringArray(R.array.gender);
        List<String> genderlist = new ArrayList<>();
        genderlist = new ArrayList<>(Arrays.asList(genderarray));

       /* String genderarray[] = getResources().getStringArray(R.array.gender);
        ArrayList<String> genderlist=new ArrayList<>();
        genderlist= (ArrayList<String>) Arrays.asList(genderarray);*/
        makeSpinnerGenderMethod((ArrayList<String>) genderlist);

    }

    private void makeSpinnerGenderMethod(final ArrayList<String> list) {
        SpinAdapter<String> adapter =
                new SpinAdapter(getApplicationContext(), 0, 0, list, "");
//        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapter);
        spGender.setSelection(0);
        adapter.notifyDataSetChanged();
        spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //selectedgender = position;
                /*if (position != 0) {
                    selectedgender = list.get(position).toString();
                } else {
                    selectedgender = "";
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initSymptomView() {
        adapter = new SymptomListAdapter(this, new ArrayList<ModelSymptomGVT>());
        adapter.setListener(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvView.setLayoutManager(manager);
        rvView.setAdapter(adapter);
        selectedString = new ArrayList<>();
        adapter.setValue(getList());
    }

    private ArrayList<ModelSymptomGVT> getList() {
      /*  ArrayList<String> listString = new ArrayList<>();
        listString.add("Fever");
        listString.add("cough");
        listString.add("Cold");
        listString.add("Tiredness");
        listString.add("Other");*/
        return getCommonApi().getListOdSymtomByGVT();
    }

    public static int selectaretype = 0;

    private void makeSpinnerAreaType(final ArrayList<String> list) {
        SpinAdapter<String> adapter =
                new SpinAdapter(getApplicationContext(), 0, 0, list, "");
//        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spAreatype.setAdapter(adapter);
        spAreatype.setSelection(0);
        adapter.notifyDataSetChanged();
        spAreatype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //selectedgender = position;
                switch (position) {
                    case 0:
                        llRural.setVisibility(View.GONE);
                        llurban.setVisibility(View.GONE);
                        lladdress.setVisibility(View.GONE);
                        resetView();
                        selectaretype = 0;
                        break;
                    case 1:
                        llRural.setVisibility(View.GONE);
                        llurban.setVisibility(View.VISIBLE);
                        lladdress.setVisibility(View.VISIBLE);
                        resetView();
                        selectaretype = 1;
                        break;
                    case 2:
                        llRural.setVisibility(View.VISIBLE);
                        llurban.setVisibility(View.GONE);
                        lladdress.setVisibility(View.VISIBLE);
                        resetView();
                        selectaretype = 2;
                        break;
                    default:
                        llRural.setVisibility(View.GONE);
                        llurban.setVisibility(View.GONE);
                        lladdress.setVisibility(View.VISIBLE);
                        resetView();
                        selectaretype = 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void resetView() {
        txtDistSpin.setText("Selct District");
        txtCitySpin.setText("Selct City");
        txtWordSpin.setText("Selct Word");

        txtTalukSpin.setText("Selct Taluk/Block");
        txtGrampanchyateSpin.setText("Selct Panchyate");
        txtVillageSpin.setText("Selct Village");
        selctedDistId = "-1";
        selctedCityId = "-1";
        selctedWordId = "-1";
        selctedpanchyateId = "-1";
        selctedvillageId = "-1";
        selctedtalukid = "-1";
    }

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {

    }

    @OnClick({R.id.txt_dist_spin, R.id.txt_city_spin, R.id.txt_word_spin, R.id.txt_taluk_spin, R.id.txt_grampanchyate_spin, R.id.txt_village_spin, R.id.submit_btn, R.id.tv_logout, R.id.txt_DOA, R.id.txt_qurantinedate, R.id.txt_DOA11})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_dist_spin:
                Bundle bundle = new Bundle();
                bundle.putString("key", "dist");
                bundle.putString("key_id", "0");
                //resetView();
                Intent intent = new Intent(getApplicationContext(), AddressGenericListActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, RES_DIST);

                break;
            case R.id.txt_city_spin:

                if (!selctedDistId.equalsIgnoreCase("-1")){
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("key", "town");
                    bundle1.putString("key_id", selctedDistId);

               /* txtCitySpin.setText("Selct City");
                txtWordSpin.setText("Selct Word");

                txtTalukSpin.setText("Selct Taluk/Block");
                txtGrampanchyateSpin.setText("Selct Panchyate");
                txtVillageSpin.setText("Selct Village");*/
                    Intent intent1 = new Intent(getApplicationContext(), AddressGenericListActivity.class);
                    intent1.putExtras(bundle1);
                    startActivityForResult(intent1, RES_TOWN);
                }else {
                    Toast.makeText(YelligoApplication.getContext(),"Please select district",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.txt_word_spin:
                if (!selctedCityId.equalsIgnoreCase("-1")){
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key", "ward");
                    bundle2.putString("key_id", selctedCityId);

              /*  txtWordSpin.setText("Selct Word");

                txtTalukSpin.setText("Selct Taluk/Block");
                txtGrampanchyateSpin.setText("Selct Panchyate");
                txtVillageSpin.setText("Selct Village");*/
                    Intent intent2 = new Intent(getApplicationContext(), AddressGenericListActivity.class);
                    intent2.putExtras(bundle2);
                    startActivityForResult(intent2, RES_WORD);
                }else {
                    Toast.makeText(YelligoApplication.getContext(),"Please select City/Town",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.txt_taluk_spin:
                if (!selctedDistId.equalsIgnoreCase("-1")){
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("key", "taluk");

               /* txtTalukSpin.setText("Selct Taluk/Block");
                txtGrampanchyateSpin.setText("Selct Panchyate");
                txtVillageSpin.setText("Selct Village");*/
                    bundle3.putString("key_id", selctedDistId);
                    Intent intent3 = new Intent(getApplicationContext(), TalukListActivity.class);
                    intent3.putExtras(bundle3);
                    startActivityForResult(intent3, RES_TALUK);
                }else {
                    Toast.makeText(YelligoApplication.getContext(),"Please select district",Toast.LENGTH_LONG).show();
                }


                break;
            case R.id.txt_grampanchyate_spin:
                if (!selctedtalukid.equalsIgnoreCase("-1")){
 /* txtGrampanchyateSpin.setText("Selct Panchyate");
                txtVillageSpin.setText("Selct Village");*/
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("key", "panchyate");
                    bundle4.putString("key_id", "" + selctedtalukid);
                    Intent intent4 = new Intent(getApplicationContext(), PanchyateListActivity.class);
                    intent4.putExtras(bundle4);
                    startActivityForResult(intent4, RES_PANCHYATE);
                }else {
                    Toast.makeText(YelligoApplication.getContext(),"Please select Taluk",Toast.LENGTH_LONG).show();
                }


                break;
            case R.id.txt_village_spin:
                if (!selctedpanchyateId.equalsIgnoreCase("-1")){
                    // txtVillageSpin.setText("Selct Village");
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("key", "village");
                    bundle5.putString("key_id", "" + selctedpanchyateId);
                    Intent intent5 = new Intent(getApplicationContext(), VillageGenericListActivity.class);
                    intent5.putExtras(bundle5);
                    startActivityForResult(intent5, RES_VILLAGE);
                }else {
                    Toast.makeText(YelligoApplication.getContext(),"Please select Panchyate",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.tv_logout:
                finish();
                break;

            case R.id.txt_DOA:
                DatePickerFragment newFragment = new DatePickerFragment();
                daovvalue = "dao";
                Bundle args = new Bundle();

                args.putString("datefrom", "");
                newFragment.setArguments(args);
                // set the targetFragment to receive the results, specifying the request code
                //  newFragment.setTargetFragment(newFragment, REQUEST_CODE);
                // show the datePicker
                newFragment.show(getSupportFragmentManager(), "datePicker");
                break;

            case R.id.txt_DOA11:
                DatePickerFragment newFragment3 = new DatePickerFragment();
                daovvalue = "dfs";
                Bundle args3 = new Bundle();

                args3.putString("datefrom", "");
                newFragment3.setArguments(args3);
                // set the targetFragment to receive the results, specifying the request code
                //  newFragment.setTargetFragment(newFragment, REQUEST_CODE);
                // show the datePicker
                newFragment3.show(getSupportFragmentManager(), "datePicker");
                break;
            case R.id.txt_qurantinedate:
                if (startdate.equalsIgnoreCase("")) {
                    showDialogInMsg("Please add start date");
                } else {
                    daovvalue = "qao";
                    DatePickerFragment newFragment2 = new DatePickerFragment();
                    Bundle args1 = new Bundle();

                    args1.putString("datefrom", startdate);
                    newFragment2.setArguments(args1);
                    // set the targetFragment to receive the results, specifying the request code
                    //  newFragment.setTargetFragment(newFragment, REQUEST_CODE);
                    // show the datePicker
                    newFragment2.show(getSupportFragmentManager(), "datePicker");
                }
                break;
        }
    }

    private void showDialogInMsg(String message) {
        if (!isFinishing()) {
            CustomDialogGeneric dialog = new CustomDialogGeneric(AddnewPatientActivity.this, "",
                    new CustomDialogGeneric.OnButtonClickListener() {
                        @Override
                        public void onLeftButtonClick(CustomDialogGeneric dialog) {
                            dialog.dismiss();
                            // Toast.makeText(getActivity(),"Customer created successfully",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                        @Override
                        public void onRightButtonClick(CustomDialogGeneric dialog, String notes) {
                            dialog.dismiss();

                        }


                    });
            dialog.setCancelable(false);
            dialog.setRightButtonText("Retry");
            dialog.setRightButtonVisibility(View.GONE);
            dialog.setLeftButtonVisibility(View.VISIBLE);
            dialog.setLeftButtonText("OK");
            dialog.setDialogType(CustomDialogGeneric.TYPE_ALERT);
            dialog.setDescription("" + message);
            dialog.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RES_DIST) {
            String name = data.getStringExtra("name");
            if (!data.getStringExtra("name_id").equalsIgnoreCase("")) {
                if (!data.getStringExtra("name_id").equalsIgnoreCase(selctedDistId)) {


                    txtCitySpin.setText("Selct City");
                    txtWordSpin.setText("Selct Word");

                    txtTalukSpin.setText("Selct Taluk/Block");
                    txtGrampanchyateSpin.setText("Selct Panchyate");
                    txtVillageSpin.setText("Selct Village");

                    //selctedDistId = "-1";
                    selctedCityId = "-1";
                    selctedWordId = "-1";
                    selctedpanchyateId = "-1";
                    selctedvillageId = "-1";
                    selctedtalukid = "-1";

                    selctedDistId = data.getStringExtra("name_id");
                    txtDistSpin.setText(name);
                    txtDistSpin.requestFocus();
                }
            }

        } else if (requestCode == RES_TOWN) {
            if (!data.getStringExtra("name_id").equalsIgnoreCase("")) {
                if (!data.getStringExtra("name_id").equalsIgnoreCase(selctedCityId)) {


                    //txtCitySpin.setText("Selct City");
                    txtWordSpin.setText("Selct Word");

                    txtTalukSpin.setText("Selct Taluk/Block");
                    txtGrampanchyateSpin.setText("Selct Panchyate");
                    txtVillageSpin.setText("Selct Village");
                    // selctedDistId = "-1";
                    //selctedCityId = "-1";
                    selctedWordId = "-1";
                    selctedpanchyateId = "-1";
                    selctedvillageId = "-1";
                    selctedtalukid = "-1";
                    String name = data.getStringExtra("name");
                    selctedCityId = data.getStringExtra("name_id");
                    txtCitySpin.setText(name);
                    txtCitySpin.requestFocus();
                }
            }

        } else if (requestCode == RES_WORD) {

            if (!data.getStringExtra("name_id").equalsIgnoreCase("")) {


                txtTalukSpin.setText("Selct Taluk/Block");
                txtGrampanchyateSpin.setText("Selct Panchyate");
                txtVillageSpin.setText("Selct Village");
                // selctedDistId = "-1";
                // selctedCityId = "-1";
                // selctedWordId = "-1";
                selctedpanchyateId = "-1";
                selctedvillageId = "-1";
                selctedtalukid = "-1";
                String name = data.getStringExtra("name");
                selctedWordId = data.getStringExtra("name_id");
                txtWordSpin.setText(name);
                txtWordSpin.requestFocus();
            }
        } else if (requestCode == RES_TALUK) {

            if (!data.getStringExtra("name_id").equalsIgnoreCase("")) {

               /* txtCitySpin.setText("Selct City");
                txtWordSpin.setText("Selct Word");

                txtTalukSpin.setText("Selct Taluk/Block");*/
                txtGrampanchyateSpin.setText("Selct Panchyate");
                txtVillageSpin.setText("Selct Village");
                // selctedDistId = "-1";
                // selctedCityId = "-1";
                //selctedWordId = "-1";
                selctedpanchyateId = "-1";
                selctedvillageId = "-1";
                // selctedtalukid = "-1";
                String name = data.getStringExtra("name");
                selctedtalukid = data.getStringExtra("name_id");
                txtTalukSpin.setText(name);
            }
            //txtWordSpin.requestFocus();
        } else if (requestCode == RES_PANCHYATE) {
            if (!data.getStringExtra("name_id").equalsIgnoreCase("")) {

               /* txtCitySpin.setText("Selct City");
                txtWordSpin.setText("Selct Word");

                txtTalukSpin.setText("Selct Taluk/Block");*/
                //txtGrampanchyateSpin.setText("Selct Panchyate");
                txtVillageSpin.setText("Selct Village");
                // selctedDistId = "-1";
                // selctedCityId = "-1";
                // selctedWordId = "-1";
                // selctedpanchyateId = "-1";
                selctedvillageId = "-1";
                //selctedtalukid = "-1";
                String name = data.getStringExtra("name");
                selctedpanchyateId = data.getStringExtra("name_id");
                txtGrampanchyateSpin.setText(name);
            }
            //txtWordSpin.requestFocus();
        } else if (requestCode == RES_VILLAGE) {
            String name = data.getStringExtra("name");
            selctedvillageId = data.getStringExtra("name_id");
            txtVillageSpin.setText(name);
            //txtWordSpin.requestFocus();
        }
    }

    @Override
    public void onItemChecked(View v, int position, ModelSymptomGVT item, ArrayList<ModelSymptomGVT> listString, boolean isChecked) {

    }

    @Override
    public void onFragmentInteraction(String uri) {
        if (daovvalue.equalsIgnoreCase("dao")) {
            startdate = uri;
            txtDOA.setText("" + AppConstants.dateFormatChangerGVT(uri));

        } else if (daovvalue.equalsIgnoreCase("qao")) {
            enddate = uri;
            txtQurantinedate.setText("" + AppConstants.dateFormatChangerGVT(uri));

        }else if (daovvalue.equalsIgnoreCase("dfs")) {
            dateofsymtom = uri;
            txtDOA11.setText("" + AppConstants.dateFormatChangerGVT(uri));

        }

    }
}
