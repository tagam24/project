package com.eccomerce.com.shopin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.eccomerce.com.Api;
import com.eccomerce.com.R;
import com.eccomerce.com.constants;
import com.eccomerce.com.dil;
import com.eccomerce.com.main.RecycleAdapter;
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;
import com.viewpagerindicator.CirclePageIndicator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;



public class show_details extends AppCompatActivity implements ViewPagerEx.OnPageChangeListener, RatingDialogListener {
    TextView content,price,item_name,next;
    ViewPager mPager;
    Button call;
    Menu menu;
    MenuItem item;
    String loved;
    RecycleAdapter recycleAdapter;
    String id;
    String skidka; Intent i;
    public static ArrayList<String > images;
    Toolbar toolbar;
    SliderLayout mDemoSlider;
    viewpager_adapter v;
    LinearLayout rt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_details1);
        toolbar=(Toolbar)findViewById(R.id.toolbar_car_sahypa);
        dil d=new dil();
         //setSupportActionBar(toolbar);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rt=(LinearLayout)findViewById(R.id.l_rate);
 next=(TextView)findViewById(R.id.items);
        item_name=(TextView)findViewById(R.id.item_name);
        content = (TextView) findViewById(R.id.Content);
       mPager = (ViewPager) findViewById(R.id.viewpager_detail);
        price = (TextView) findViewById(R.id.item_price);
        call = (Button) findViewById(R.id.call_btn);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recycleAdapter = new RecycleAdapter(constants.vip,this);
        recyclerView.setAdapter(recycleAdapter);
       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(show_details.this, allshopitems.class);
               i.putExtra("shopid",constants.selected.getShopid());
               startActivity(i);
           }
       });
       rt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
          send_rate();
           }
       });
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        Typeface tp= Typeface.createFromAsset(getAssets(),"fonts/Panton.otf");
  //      Typeface tp1= Typeface.createFromAsset(getAssets(),"fonts/Panton-SemiBold.otf");;
    //    content.setTypeface(tp);
      //  item_name.setTypeface(tp1);
        //price.setTypeface(tp1);
    //    mDemoSlider=(SliderLayout)findViewById(R.id.slider_show);
      i=getIntent();
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + i.getStringExtra("number")));
                startActivity(call);
            }
        });
        images=new ArrayList<>();
  images.add(constants.selected.getImage1());
      images.add(constants.selected.getImage2());
      images.add(constants.selected.getImage3());
        id=constants.selected.getId();
v=new viewpager_adapter(show_details.this, images);
       // Log.d("imagesize",""+images.size()+"image2/"+images.get(1));
    mPager.setAdapter(v);
  CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.small_indicator_realtor_show_details);
     indicator.setViewPager(mPager);
        item_name.setText(constants.selected.getName());
    content.setText(constants.selected.getContent());
        price.setText(constants.selected.getPrice());
        skidka=constants.selected.getSkidka();
      //  daimaija();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if (res_id == android.R.id.home) {
           // mDemoSlider.removeAllViews();
           onBackPressed();

        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
     //   mDemoSlider.removeAllViews();
        images.clear();
        v.notif(images);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;

        return true;
    }
    void daimaija(){
        for(final String name : images){
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image("http://"+ Api.url+"images/"+name)
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {

                            Intent i=new Intent(show_details.this,reklam_photo.class);
                            startActivity(i);
                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(10000);
        mDemoSlider.addOnPageChangeListener(this);




    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    public void send_rate() {
        AppRatingDialog.Builder appRatingDialog = new AppRatingDialog.Builder();
        appRatingDialog.setPositiveButtonText(dil.tassykla);
        appRatingDialog.setNegativeButtonText(dil.yza);
        appRatingDialog.setNoteDescriptions(Arrays.asList(dil.erbet, dil.kanagatlanarly, dil.gowy, dil.oran_gowy, dil.ajayyp));
        appRatingDialog.setDefaultRating(2);
        appRatingDialog.setTitle(dil.tagamy_bahalndyryn);
        appRatingDialog.setDescription(dil.mynasyp_baha_bermeginizi_hayys);
        appRatingDialog.setStarColor(R.color.colorPrimary);
        appRatingDialog.setNoteDescriptionTextColor(R.color.button_blue);
        appRatingDialog.setTitleTextColor(R.color.colorPrimary);
        appRatingDialog.setCommentInputEnabled(false);
        appRatingDialog.setDescriptionTextColor(R.color.colorPrimary);
        appRatingDialog.setWindowAnimation(R.style.MyDialogFadeAnimation);
        appRatingDialog.setCancelable(false);
        appRatingDialog.setCanceledOnTouchOutside(false);
        appRatingDialog.create((FragmentActivity) this).show();
    }

    @Override
    public void onPositiveButtonClicked(int postion, @NotNull String s) {

    }

    @Override
    public void onNegativeButtonClicked() {

    }

    @Override
    public void onNeutralButtonClicked() {

    }


}
