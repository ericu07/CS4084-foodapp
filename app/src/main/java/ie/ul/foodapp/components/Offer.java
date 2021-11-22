package ie.ul.foodapp.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import ie.ul.foodapp.R;
import ie.ul.foodapp.utils.StringUtils;

public class Offer extends LinearLayout implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* UI parts */

    ImageView offerImage;
    TextView businessName;
    ImageView bookedIcon;
    TextView offerName;
    TextView offerPrice;
    TextView pickupTime;
    TextView description;
    Button book;
    Button cancelBooking;

    /* attributes */

    ie.ul.foodapp.model.Offer offer;

    /* Constructors */

    public Offer(Context context) {
        super(context);
        initialise(context);
    }

    public Offer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialise(context);
    }

    public Offer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(context);
    }

    public Offer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialise(context);
    }

    protected void initialise(Context context) {
        ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.offer, this);

        offerImage = findViewById(R.id.imageView_offerImage);
        businessName = findViewById(R.id.textView_businessName);
        bookedIcon =  findViewById(R.id.imageView_bookedIcon);
        offerName = findViewById(R.id.textView_offerName);
        offerPrice = findViewById(R.id.textView_offerPrice);
        pickupTime = findViewById(R.id.textView_pickupTime);
        description = findViewById(R.id.textView_description);
        book = findViewById(R.id.button_book);
        book.setOnClickListener(this::onClickButtonBook);
        cancelBooking = findViewById(R.id.button_cancelBooking);
        cancelBooking.setOnClickListener(this::onClickButtonCancelBooking);

        this.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
        this.setVisibility(GONE);
    }

    /* layout update */

    public void setOffer(ie.ul.foodapp.model.Offer offer) {
        this.offer = offer;

        if (this.offer == null) {
            this.setVisibility(GONE);
        } else {
            businessName.setText(this.offer.getBusiness().getName());
            offerName.setText(this.offer.getName());
            offerPrice.setText(StringUtils.priceToString(this.offer.getPrice()));
            pickupTime.setText(StringUtils.pickupTime(this.offer.getPickup()));

            updateLayout();

            this.setVisibility(VISIBLE);
        }
    }

    protected void updateLayout() {
        if (isFocused()) {
            offerImage.setImageBitmap(offer.getOfferImage());
            description.setVisibility(VISIBLE);

            if (offer.getBooker() != null) {
                bookedIcon.setVisibility(VISIBLE);
                book.setVisibility(GONE);
                cancelBooking.setVisibility(VISIBLE);
            } else {
                bookedIcon.setVisibility(GONE);
                book.setVisibility(VISIBLE);
                cancelBooking.setVisibility(GONE);
            }
        } else {
            if (offer.getBooker() != null) {
                bookedIcon.setVisibility(VISIBLE);
            } else {
                bookedIcon.setVisibility(GONE);
            }

            offerImage.setImageBitmap(offer.getCroppedImage());
            description.setVisibility(GONE);
            book.setVisibility(GONE);
            cancelBooking.setVisibility(GONE);
        }
    }

    /* Listeners */

    @Override
    public boolean isFocused() {
        return super.isFocused() || (this.getFocusedChild() != null);
    }

    @Override
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        updateLayout();
    }

    public void onClickButtonBook(View view) {
        offer.setBooker(new Object()); // TODO link with DB
        updateLayout();
    }

    public void onClickButtonCancelBooking(View view) {
        offer.setBooker(null); // TODO link with DB
        updateLayout();
    }

}
