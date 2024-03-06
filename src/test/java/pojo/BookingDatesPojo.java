package pojo;

public class BookingDatesPojo {

    // 1-Tümkeyler icin private variable olusturiyoruz


    private String checkin;
    private String checkout;

//2 Tüm parametlereler icin parametreli ve paremetresiz constroctor olustutuyoruz

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {

    }

    //3 public getter ve setter meht olusturoyurz


    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //4 toString meht olusturuyoruz


    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
