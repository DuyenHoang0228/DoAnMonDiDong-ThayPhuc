package com.nhom4.models;

public class TroGIup {
    String TieudeTroGiup, NoidungTroGiup;

    public TroGIup(String tieudeTroGiup, String noidungTroGiup) {
        TieudeTroGiup = tieudeTroGiup;
        NoidungTroGiup = noidungTroGiup;
    }

    public String getTieudeTroGiup() {
        return TieudeTroGiup;
    }

    public void setTieudeTroGiup(String tieudeTroGiup) {
        TieudeTroGiup = tieudeTroGiup;
    }

    public String getNoidungTroGiup() {
        return NoidungTroGiup;
    }

    public void setNoidungTroGiup(String noidungTroGiup) {
        NoidungTroGiup = noidungTroGiup;
    }
}
