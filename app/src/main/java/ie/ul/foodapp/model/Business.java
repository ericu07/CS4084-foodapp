package ie.ul.foodapp.model;

import android.graphics.Bitmap;
import android.media.Image;

import androidx.annotation.NonNull;

import java.time.LocalTime;
import java.util.Arrays;

public class Business {

    public static class TimeSpan {
        protected LocalTime from;
        protected LocalTime to;

        public TimeSpan() {
            this(LocalTime.of(8, 0), LocalTime.of(20, 0));
        }
        public TimeSpan(LocalTime from, LocalTime to) {
            this.from = from;
            this.to = to;
        }
        public TimeSpan(TimeSpan ts) {
            this(ts.getFrom(), ts.getTo());
        }

        @NonNull
        @Override
        protected Object clone() {
            return new TimeSpan(this);
        }

        public LocalTime getFrom() {
            return from;
        }

        public LocalTime getTo() {
            return to;
        }
    }

    protected String name;
    protected Bitmap banner;
    protected TimeSpan[] openingHours;
    protected Object localisation;

    protected Object[] previousOffers;
    protected Object[] currentOffers;

    public Business() {
        name = "My business";
        banner = null;
        openingHours = new TimeSpan[7];
        Arrays.fill(openingHours, null);
        localisation = null;
    }
    public Business(Business b) {
        this.name = b.name;
        this.banner = b.banner;
        this.openingHours = new TimeSpan[7];
        System.arraycopy(b.openingHours, 0, this.openingHours, 0, this.openingHours.length);
        this.localisation = b.localisation;
    }


    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Business(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBanner() {
        return banner;
    }

    public void setBanner(Bitmap banner) {
        this.banner = banner;
    }

    public TimeSpan getOpeningHours(int day) {
        if (day < 0 || day >= 7) {
            return null;
        } else {
            return openingHours[day];
        }
    }

    public void setOpeningHours(TimeSpan openingHours, int day) {
        if (!(day < 0 || day >= 7)) {
            this.openingHours[day] = openingHours;
        }
    }

    public Object getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Object localisation) {
        this.localisation = localisation;
    }

}
