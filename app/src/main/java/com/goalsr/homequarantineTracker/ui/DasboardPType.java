package com.goalsr.homequarantineTracker.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import com.goalsr.homequarantineTracker.R;
import com.goalsr.homequarantineTracker.Utils.PreferenceStore;
import com.goalsr.homequarantineTracker.YelligoApplication;
import com.goalsr.homequarantineTracker.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DasboardPType extends BaseActivity {

    @BindView(R.id.btn_qurantine)
    Button btnQurantine;
    @BindView(R.id.btn_observer)
    Button btnObserver;
    @BindView(R.id.tv_header_fcl)
    TextView tvHeaderFcl;
    @BindView(R.id.iv_back_fcl)
    ImageButton ivBackFcl;
    @BindView(R.id.txt_logout)
    TextView txtLogout;
    @BindView(R.id.iv_dropdown_fcl)
    ImageView ivDropdownFcl;
    @BindView(R.id.toolbar_fcl)
    Toolbar toolbarFcl;
    @BindView(R.id.divider1)
    View divider1;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtnameHeading)
    TextView txtnameHeading;
    @BindView(R.id.txtdistrictname)
    TextView txtdistrictname;
    @BindView(R.id.txtrelationChange)
    TextView txtrelationChange;
    @BindView(R.id.ll_main_familly)
    LinearLayout llMainFamilly;
    @BindView(R.id.img_1)
    ImageView img1;
    @BindView(R.id.img_2)
    ImageView img2;
    @BindView(R.id.img_3)
    ImageView img3;
    @BindView(R.id.img_4)
    ImageView img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_type);
        ButterKnife.bind(this);
        if (PreferenceStore.getPrefernceHelperInstace().getIntValue(YelligoApplication.getContext(), PreferenceStore.DISTRICT_ID) != 0) {
            txtdistrictname.setText("" + PreferenceStore.getPrefernceHelperInstace().getString(YelligoApplication.getContext(), PreferenceStore.DISTRICT_NAME));
        }
    }

    @OnClick({R.id.btn_qurantine, R.id.btn_observer,R.id.img_1, R.id.img_2, R.id.img_3, R.id.img_4})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {

            case R.id.btn_qurantine:

                bundle.putString("key", "a");
                //bundle.putString("key_id","0");
              // PreferenceStore.getPrefernceHelperInstace().setFlag(YelligoApplication.getContext(),PreferenceStore.PERSIONTYPE,true);
              //  getCommonApi().openNewScreen(AdminPatientLsitActivity.class, bundle);
                break;
            case R.id.btn_observer:

                bundle.putString("key", "b");
                //bundle.putString("key_id","0");
               // PreferenceStore.getPrefernceHelperInstace().setFlag(YelligoApplication.getContext(),PreferenceStore.PERSIONTYPE,false);
               // getCommonApi().openNewScreen(AdminPatientLsitActivity.class, bundle);
                break;

            case R.id.img_1:
                PreferenceStore.getPrefernceHelperInstace().setFlag(YelligoApplication.getContext(),PreferenceStore.PERSIONTYPE,true);
                bundle.putString("key", "a");
                //bundle.putString("key_id","0");
                getCommonApi().openNewScreen(AdminPatientLsitActivity.class, bundle);
                break;
            case R.id.img_2:
                bundle.putString("key", "b");
                //bundle.putString("key_id","0");
                PreferenceStore.getPrefernceHelperInstace().setFlag(YelligoApplication.getContext(),PreferenceStore.PERSIONTYPE,false);
                getCommonApi().openNewScreen(AdminPatientLsitActivity.class, bundle);
                break;
            case R.id.img_3:
                break;
            case R.id.img_4:
                break;
            case R.id.txtrelationChange:
                Intent intent = new Intent(getApplicationContext(), DistrictListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {

    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DasboardPType.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();

    }


}
