package com.example.da3_phamvanminh_101185;

public class CauHoi {
    private int maCH;
    private String CauHoi,CauTraLoi,DapAn;

    public CauHoi() {
    }

    public int getMaCH() {
        return maCH;
    }

    public void setMaCH(int maCH) {
        this.maCH = maCH;
    }

    public String getCauHoi() {
        return CauHoi;
    }

    public void setCauHoi(String cauHoi) {
        CauHoi = cauHoi;
    }

    public String getCauTraLoi() {
        return CauTraLoi;
    }

    public void setCauTraLoi(String cauTraLoi) {
        CauTraLoi = cauTraLoi;
    }

    public String getDapAn() {
        return DapAn;
    }

    public void setDapAn(String dapAn) {
        DapAn = dapAn;
    }

    public CauHoi(int maCH, String cauHoi, String cauTraLoi, String dapAn) {
        this.maCH = maCH;
        CauHoi = cauHoi;
        CauTraLoi = cauTraLoi;
        DapAn = dapAn;
    }
}
